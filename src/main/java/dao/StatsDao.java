/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.StatsResult_1;
import dto.StatsResult_2_3;
import dto.StatsResult_4_5;
import java.util.Date;
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
    
    //Requête n°1
    //Montant des remboursements par région
    private static final String MONTANT_REMBOURSEMENT_PAR_REGION
        = "SELECT new dto.StatsResult_1"
        + "(Reg.codeGeo, SUM(I.prsRemMnt)) "
        + "FROM BenResRegClair Reg "
        + "JOIN Reg.beneficiaireCollection B "
        + "JOIN B.prestation P "
        + "JOIN P.dateTraitement D "
        + "JOIN P.indicateurs I "
        + "WHERE D.flxAnnMoi between :minDate and :maxDate "
        + "GROUP BY Reg.codeGeo";

    //Requête n°2
    //Tranche d'âge la plus remboursée par région
    private static final String TRANCHE_AGE_PLUS_REMBOURSEE_REGION
        ="SELECT new dto.StatsResult_2_3"
        + "(B.AGE_BEN_SNDS, SUM(I.PRS_REM_MNT) AS montanRem, B.BEN_RES_REG) "
        + "FROM Indicateurs I, Beneficiaire B, Prestation P "
        + "WHERE I.idIndicateurs = P.idPrestation "
        + "AND P.idPrestation = B.idBeneficiaire "
        + "AND FLX_ANN_MOI between :minDate and :maxDate "
        + "GROUP BY B.AGE_BEN_SNDS, B.BEN_RES_REG"
        + "HAVING SUM(I.PRS_REM_MNT) =( "
            + "SELECT MAX(montanRem) "
            + "FROM ( "
            + "SELECT SUM(I.PRS_REM_MNT) AS montanRem "
            + "FROM Indicateurs I, Beneficiaire B, Prestation P "
            + "WHERE I.idIndicateurs = P.idPrestation "
            + "AND P.idPrestation = B.idBeneficiaire "
            + "GROUP BY B.AGE_BEN_SNDS, B.BEN_RES_REG))";
    
    //Requête n°3
    //Nature de la prestation la plus remboursée par tranche d'âge
    private static final String NATURE_PRESTATION_PLUS_REMBOURSEE_PAR_TRANCHE_AGE
        ="SELECT new dto.StatsResult_2_3"
        + "(B.AGE_BEN_SNDS, P.PRES_NAT, COUNT(P.IdPrestation) AS nbPrestation) "
        + "FROM Beneficiaire B, Prestation P "
        + "WHERE P.idPrestation = B.idBeneficiair "
        + "GROUP BY P.PRES_NAT, B.AGE_BEN_SNDS "
        + "AND FLX_ANN_MOI between :minDate and :maxDate "
        + "HAVING COUNT(IdPrestation) =( "
            + "SELECT MAX(nbPrestation) "
            + "FROM ( "
            + "SELECT COUNT (IdPrestation) AS nbPrestation "
            + "FROM Beneficiaire B, Prestation P "
            + "WHERE P.idPrestation = B.idBeneficiair "
            + "GROUP BY B.AGE_BEN_SNDS, P.PRES_NAT))";
    
    //Requête n°4
    //Montant des dépenses par secteur privé/public par tranche d'âge
    private static final String MONTANT_DEPENSE_PAR_SECTEUR_PRIVE_PUBLIC_PAR_TRANCHE_AGE
        = "SELECT new dto.StatsResult_4_5"
        + "(Sec.secClair, Age.ageClair, SUM(I.prsPaiMnt)) " 
        + "FROM AgeBenSndsClair Age "
        + "JOIN Age.beneficiaireCollection B "
        + "JOIN B.prestation P "
        + "JOIN P.indicateurs I "
        + "JOIN P.prsPpuSec Sec "
        + "JOIN P.dateTraitement D "
        + "WHERE D.flxAnnMoi between :minDate and :maxDate "
        + "GROUP BY Sec.secClair, Age.ageClair";
    
    //Requête n°5
    //Montant moyen des dépenses et remboursement par spécialité du médecin exécutant
    private static final String MONTANT_MOYEN_DEPENSE_ET_REMBOURSEMENTS_PAR_SPECIALITE_MEDECIN_EXECUTANT
        ="SELECT new dto.StatsResult_4_5"
        + "(Spe.speClair, AVG(I.prsPaiMnt), AVG(I.prsRemMnt)) "
        + "FROM PseSpeSndsClair Spe "
        + "JOIN Spe.executantCollection E "
        + "JOIN E.prestation P "
        + "JOIN P.dateTraitement D "
        + "JOIN P.indicateurs I "
        + "WHERE D.flxAnnMoi between :minDate and :maxDate "
        + "GROUP BY Spe.speClair";

    
    @PersistenceContext(unitName = "damir")
    private EntityManager em;
    
    //Requête n°1
    public List<StatsResult_1> montantRemboursementsParRegion(Date minDate, Date maxDate) {
        Query query = em.createQuery(MONTANT_REMBOURSEMENT_PAR_REGION, StatsResult_1.class)
            .setParameter("minDate", minDate)
            .setParameter("maxDate", maxDate);
        List<StatsResult_1> results = query.getResultList();
        return results;
    }
    //Requête n°2
    public List<StatsResult_2_3> trancheAgePlusRembourseeParRegion(Date minDate, Date maxDate) {
        Query query = em.createQuery(TRANCHE_AGE_PLUS_REMBOURSEE_REGION, StatsResult_2_3.class)
            .setParameter("minDate", minDate)
            .setParameter("maxDate", maxDate);
        List<StatsResult_2_3> results = query.getResultList();
        return results;
    }
    //Requête n°3
    public List<StatsResult_2_3> naturePrestationPlusRembourseeParTrancheAge(Date minDate, Date maxDate) {
        Query query = em.createQuery(NATURE_PRESTATION_PLUS_REMBOURSEE_PAR_TRANCHE_AGE, StatsResult_2_3.class)
            .setParameter("minDate", minDate)
            .setParameter("maxDate", maxDate);
        List<StatsResult_2_3> results = query.getResultList();
        return results;
    }
    //Requête n°4
    public List<StatsResult_4_5> montantDepensesParSecteurPrivePublicParTrancheAge(Date minDate, Date maxDate) {
        Query query = em.createQuery(MONTANT_DEPENSE_PAR_SECTEUR_PRIVE_PUBLIC_PAR_TRANCHE_AGE, StatsResult_4_5.class)
            .setParameter("minDate", minDate)
            .setParameter("maxDate", maxDate);
        List<StatsResult_4_5> results = query.getResultList();
        return results;
    }
    //Requête n°5
    public List<StatsResult_4_5> montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant(Date minDate, Date maxDate) {
        Query query = em.createQuery(MONTANT_MOYEN_DEPENSE_ET_REMBOURSEMENTS_PAR_SPECIALITE_MEDECIN_EXECUTANT, StatsResult_4_5.class)
            .setParameter("minDate", minDate)
            .setParameter("maxDate", maxDate);
        List<StatsResult_4_5> results = query.getResultList();
        return results;
    }
}
