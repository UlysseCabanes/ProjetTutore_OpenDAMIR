/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ulyss
 */
@Stateless
public class StatsDao {
    
    //Montant des remboursements par région
    private static final String MONTANT_REMBOURSEMENT_PAR_REGION
        = "SELECT dto.StatsResult (B.BEN_RES_REG, SUM(I.PRS_REM_MNT))"
        + "FROM Indicateurs I, Beneficiaire B, Prestation P"
        + "WHERE I.idIndicateurs = P.idPrestation"
        + "AND P.idPrestation = B.idBeneficiaire"
        + "GROUP BY B.BEN_RES_REG";
    
    //Tranche d'âge la plus remboursée par région
    private static final String TRANCHE_AGE_PLUS_REMBOURSEE_REGION
        ="SELECT B.AGE_BEN_SNDS, SUM(I.PRS_REM_MNT) AS montanRem, B.BEN_RES_REG"
        + "FROM Indicateurs I, Beneficiaire B, Prestation P"
        + "WHERE I.idIndicateurs = P.idPrestation"
        + "AND P.idPrestation = B.idBeneficiaire"
        + "GROUP BY B.AGE_BEN_SNDS, B.BEN_RES_REG"
        + "HAVING SUM(I.PRS_REM_MNT) =( "
            + "SELECT MAX(montanRem)"
            + "FROM ("
            + "SELECT SUM(I.PRS_REM_MNT) AS montanRem"
            + "FROM Indicateurs I, Beneficiaire B, Prestation P"
            + "WHERE I.idIndicateurs = P.idPrestation"
            + "AND P.idPrestation = B.idBeneficiaire;"
            + "GROUP BY B.AGE_BEN_SNDS, B.BEN_RES_REG));";
    
    //Nature de la prestation la plus remboursée par tranche d'âge
    private static final String NATURE_PRESTATION_PLUS_REMBOURSEE_PAR_TRANCHE_AGE
        ="SELECT B.AGE_BEN_SNDS, P.PRES_NAT, COUNT(IdPrestation) AS nbPrestation"
        + "FROM Beneficiaire B, Prestation P"
        + "WHERE P.idPrestation = B.idBeneficiair"
        + "GROUP BY P.PRES_NAT, B.AGE_BEN_SNDS"
        + "HAVING COUNT(IdPrestation) =("
            + "SELECT MAX(nbPrestation)"
            + "FROM ("
            + "SELECT COUNT (IdPrestation) AS nbPrestation"
            + "FROM Beneficiaire B, Prestation P"
            + "WHERE P.idPrestation = B.idBeneficiair"
            + "GROUP BY B.AGE_BEN_SNDS, P.PRES_NAT));";
    
    //Montant des dépenses par secteur privé/public par tranche d'âge
    private static final String MONTANT_DEPENSE_PAR_SECTEUR_PRIVE_PUBLIC_PAR_TRANCHE_AGE
        ="SELECT P.PRS_PPU_SEC, B.AGE_BEN_SNDS, SUM(I.PRS_PAI_MNT)"
        + "FROM  Indicateurs I, Beneficiaire B, Prestation P"
        + "WHERE I.idIndicateurs = P.idPrestation"
        + "AND P.idPrestation = B.idBeneficiaire"
        + "GROUP BY B.AGE_BEN_SNDS, P.PRS_PPU_SEC;";
    
    //Montant moyen des dépenses et remboursement par spécialité du médecin exécutant
    private static final String MONTANT_MOYEN_DEPENSE_ET_REMBOURSEMENTS_PAR_SPECIALITE_MEDECIN_EXECUTANT
        ="SELECT E.PSE_SPE_SNDS, AVG(I.PRS_PAI_MNT), AVG(I.PRS_REM_MNT)"
        + "FROM Indicateurs I, Executant E, Prestation P"
        + "WHERE I.idIndicateurs = P.idPrestation"
        + "AND P.idPrestation = E.idExecutant"
        + "GROUP BY E.PSE_SPE_SNDS;";
    
    @PersistenceContext(unitName = "damir")
    private EntityManager em;
    
    public List montantRemboursementsParRegion() {
        Query query = em.createQuery(MONTANT_REMBOURSEMENT_PAR_REGION);
        List results = query.getResultList();
        return results;
    }
    
    public List trancheAgePlusRembourseeParRegion() {
        Query query = em.createQuery(TRANCHE_AGE_PLUS_REMBOURSEE_REGION);
        List results = query.getResultList();
        return results;
    }
    
    public List naturePrestationPlusRembourseeParTrancheAge() {
        Query query = em.createQuery(NATURE_PRESTATION_PLUS_REMBOURSEE_PAR_TRANCHE_AGE);
        List results = query.getResultList();
        return results;
    }
    
    public List montantDepensesParSecteurPrivePublicParTrancheAge() {
        Query query = em.createQuery(MONTANT_DEPENSE_PAR_SECTEUR_PRIVE_PUBLIC_PAR_TRANCHE_AGE);
        List results = query.getResultList();
        return results;
    }

    public List montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant() {
        Query query = em.createQuery(MONTANT_MOYEN_DEPENSE_ET_REMBOURSEMENTS_PAR_SPECIALITE_MEDECIN_EXECUTANT);
        List results = query.getResultList();
        return results;
    }
}