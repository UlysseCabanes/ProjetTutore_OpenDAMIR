/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "PRS_NAT_CLAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrsNatClair.findAll", query = "SELECT p FROM PrsNatClair p"),
    @NamedQuery(name = "PrsNatClair.findByNatNum", query = "SELECT p FROM PrsNatClair p WHERE p.natNum = :natNum"),
    @NamedQuery(name = "PrsNatClair.findByNatClair", query = "SELECT p FROM PrsNatClair p WHERE p.natClair = :natClair")})
public class PrsNatClair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAT_NUM")
    private Integer natNum;
    @Size(max = 200)
    @Column(name = "NAT_CLAIR")
    private String natClair;

    public PrsNatClair() {
    }

    public PrsNatClair(Integer natNum) {
        this.natNum = natNum;
    }

    public Integer getNatNum() {
        return natNum;
    }

    public void setNatNum(Integer natNum) {
        this.natNum = natNum;
    }

    public String getNatClair() {
        return natClair;
    }

    public void setNatClair(int a) {
        if(a==0){this.natClair = "SANS OBJET"}
        if( a==1096){this.natClair = 'TELECONSULTATION MEDECIN TRAITANT AVEC EHPAD'}
        if( a==1097){this.natClair = 'TELE EXPERTISE DOSSIER TRAITANT'}
        if( a==1098){this.natClair = 'CONSULTATION CCMU 3'}
        if( a==1099){this.natClair = 'CONSULTATION CCMU 4 ET 5'}        
        if( a==1100){this.natClair = 'PROTOCOLE MURAINE - BILAN VISUEL '}
        if( a==1101){this.natClair = 'AVIS PONCTUEL DE CONSULTANT PUPH'}
        if( a==1102){this.natClair = 'AVIS PONCTUEL DE CONSULTANT PSYCHIATRE'}
        if( a==1103){this.natClair = 'AVIS PONCTUEL DE CONSULTANT DU MEDECIN'}
        if( a==1104){this.natClair = 'CONSULTATION OBLIGATOIRE ENFANT'}
        if( a==1105){this.natClair = 'CONSULTATION COMPLEXE'}
        if( a==1106){this.natClair = 'MAJORATION CONSULTATION COMPLEXE'}
        if( a==1107){this.natClair = 'CONSULTATION TRES COMPLEXE ENFANT'}
        if( a==1108){this.natClair = 'MAJORATION CONSULTATION TRES COMPLEXE'}
        if( a==1109){this.natClair = 'CONSULTATION SPECIALISTE MEDECINE GENERALE'}
        if( a==1110){this.natClair = 'CONSULTATION MEDECINE GENERALE'}
        if( a==1111){this.natClair = 'CONSULTATION COTEE C'}
        if( a==1112){this.natClair = 'CONSULTATION COTEE CS'}
        if( a==1113){this.natClair = 'CONSULTATION COTEE CNP'}
        if( a==1114){this.natClair = 'CONSULTATION SPECIFIQUE CARDIOLOGIE'}
        if( a==1115){this.natClair = 'CONSULTATION BILAN'}
        if( a==1116){this.natClair = 'MAJORATION FORFAITAIRE TRANSITOIRE'}
        if( a==1117){this.natClair = 'CONSULTATION DES SPECIALISTES COTEE C2'}
        if( a==1118){this.natClair = 'CONSULTATION DES PSYCHIATRES COTEE C2,5'}
        if( a==1119){this.natClair = 'MAJORATION TRANSITOIRE SPECIFIQUE'}
        if( a==1120){this.natClair = 'COMPLEMENT CONSULTATION SPECIALISTE'}
        if( a==1121){this.natClair = 'HONORAIRE DE SURVEILLANCE'}
        if( a==1122){this.natClair = 'EXAMEN SPECIAL (PROTOCOLE)'}
        if( a==1123){this.natClair = 'SUITE D  EXAMEN DE SANTE'}
        if( a==1124){this.natClair = 'REMUNERATION MEDECIN TRAITANT PAR PATIENT  EN ALD'}
        if( a==1125){this.natClair = 'MAJORATION DE COORDINATION DES GENERALISTES'}
        if( a==1126){this.natClair = 'MAJORATION DE COORDINATION SPECIALISTES'}
        if( a==1127){this.natClair = 'MAJORATION DE COORDINATION CARDIOLOGUES'}
        if( a==1128){this.natClair = 'DIFFERENTIEL REFERENT TRAITANT'}
        if( a==1129){this.natClair = 'MAJORATION FORFAITAIRE TRANSITOIRE (POUR LES MOINS DE 16 ANS)'}
        if( a==1130){this.natClair = 'FORFAIT MEDECIN TRAITANT'}
        if( a==1131){this.natClair = 'MAJORATION CONSULTATION APPAREILLAGE'}
        if( a==1132){this.natClair = 'MAJORATION CONSULTATION ENDOCRINO'}
        if( a==1133){this.natClair = 'MAJORATION GENERALISTE ENFANT'}
        if( a==1134){this.natClair = 'MAJORATION PREMIERE CONSULTATION FAMILLE'}
        if( a==1135){this.natClair = 'MAJORATION CONSULTATION ANNUELLE FAMILLE'}
        if( a==1136){this.natClair = 'MAJORATION ANNUELLE DE SYNTHESE'}
        if( a==1137){this.natClair = 'MAJORATION NOURRISSON'}
        if( a==1138){this.natClair = 'REMUNERATION ADDITIONNELLE CAPI'}
        if( a==1139){this.natClair = 'REMUNERATION DES ADHERENTS AU  CAPI'}
        if( a==1140){this.natClair = 'CONSULTATION SPECIFIQUE DE DEPISTAGE'}
        if( a==1141){this.natClair = 'MAJORATION PEDIATRE ENFANT'}
        if( a==1142){this.natClair = 'REMUNERATION ADHESION SOPHIA (SOINS DE VILLE)'}
        if( a==1143){this.natClair = 'REMUNERATION RENOUVELLEMENT SOPHIA (SOINS DE VILLE)'}
        if( a==1144){this.natClair = 'REMUNERATION FORFAITAIRE POUR LE SUIVI DES PATIENTS EN POST ALD'}
        if( a==1145){this.natClair = 'REMUNERATION OBJECTIF MEDECIN ET CENTRES DE SANTE'}
        if( a==1146){this.natClair = 'REMUNERATION OBJECTIF MEDECIN COMPLEMENT ET CENTRES DE SANTE'}
        if( a==1147){this.natClair = 'CONTESTATION FORFAIT MEDECIN TRAITANT'}
        if( a==1148){this.natClair = 'REMUNERATION FORFAITAIRE PAR CONSULTATION POUR LE SUIVI DES PERSONNES AGEES'}
        if( a==1149){this.natClair = 'CONTESTATION REMUNERATION SUIVI PERSONNES AGEES'}
        if( a==1150){this.natClair = 'REMUNERATION PRATICIENS TERRITORIAUX DE MEDECINE GENERALE '}
        if( a==1152){this.natClair = 'MAJORATION SUIVI DES ENFANTS GRANDS PREMATURES OU ATTEINTS DE PATHOLOGIE CONGENITALE GRAVE'}
        if( a==1153){this.natClair = 'MAJORATION CONSULTATION POUR INSUFFISANT CARDIAQUE APRES HOSPITALISATION'}
        if( a==1154){this.natClair = 'MAJORATION CONSULTATION SUIVI APRES HOSPITALISATION PATIENTS A FORTE COMORBIDITE'}
        if( a==1155){this.natClair = 'REMU CAS COTISATIONS SOCIALES'}
        if( a==1156){this.natClair = 'CONT. CAS COT.SOC.'}
        if( a==1157){this.natClair = 'Acte de téléconsultation'}
        if( a==1158){this.natClair = 'Acte de télé expertise'}
        if( a==1159){this.natClair = 'renouvellement d optique'}
        if( a==1160){this.natClair = 'INVESTISSEMENT ACTIVITE SAISONNIERE'}
        if( a==1161){this.natClair = 'COMPLEMENT PRATIQUE SAISONNIERE'}
        if( a==1162){this.natClair = 'REMUNERATION DES PRATICIENS TERRITORIAUX DE MEDECINE AMBULATOIRE'}
        if( a==1163){this.natClair = 'REMUNERATION DEPISTAGE DU CANCER COLORECTAL'}
        if( a==1164){this.natClair = 'TÉLÉ CONSULTATION - ALD ET / OU EHPAD'}
        if( a==1165){this.natClair = 'TÉLÉ EXPERTISE - ALD ET/OU EHPAD'}
        if( a==1166){this.natClair = 'FORFAIT COMPLÉMENTAIRE TÉLÉ EXPERTISE'}
        if( a==1167){this.natClair = 'VERSEMENT DE PENALITE DE RETARD AMO'}
        if( a==1168){this.natClair = 'CONSULTATION DE CONTRACEPTION ET PREVENTION'}
        if( a==1169){this.natClair = 'REMUNERATION POUR CERTIFICAT DE DECES '}
        if( a==1170){this.natClair = 'PEC EXCEPTIONNELLE DÉPASSEMENT HONORAIRE'}
        if( a==1171){this.natClair = 'RÉMUNÉRATION MÉDECIN TRAITANT CENTRES DE SANTÉ'}
        if( a==1172){this.natClair = 'TELESURVEILLANCE : PS EFFECTUANT L ACCOMPAGNEMENT'}
        if( a==1173){this.natClair = 'FORFAIT PATIENTELE MEDECIN TRAITANT'}
        if( a==1174){this.natClair = 'TELESURVEILLANCE : MEDECIN TELESURVEILLANT'}
        if( a==1175){this.natClair = 'PEC EXCEPTIONNELLE DEPASSEMENT HONORAIRE TP'}
        if( a==1176){this.natClair = 'CONTRAT INDIVIDUEL EMBAUCHE - AVANCE'}
        if( a==1177){this.natClair = 'AIDE FINANCIERE MATERNITE PATERNITE ADOPTION'}
        if( a==1178){this.natClair = 'FORFAIT STRUCT. MEDECIN'}
        if( a==1179){this.natClair = 'FORFAIT STRUCT. MEDECIN COMPLEMENT'}
        if( a==1180){this.natClair = 'ROSP MT ENFANT'}
        if( a==1181){this.natClair = 'ROSP MT ENFANT COMPLEMENT'}
        if( a==1182){this.natClair = 'REMUNERATION OPTAM'}
        if( a==1183){this.natClair = 'CONTESTATION OPTAM'}
        if( a==1188){this.natClair = 'CONTRAT COLLECTIF   ATTEINTE DES OBJECTIFS'}
        if( a==1191){this.natClair = 'TELECONSULTATION TOUTES SPECIALITES'}
        if( a==1192){this.natClair = 'TELECONSULTATION GENERALISTE'}
        if( a==1193){this.natClair = 'TELE EXPERTISE DE NIVEAU 1'}
        if( a==1194){this.natClair = 'TELE EXPERTISE DE NIVEAU 2'}
        if( a==1196){this.natClair = 'FORFAIT INNOVATION SYSTEME DE SANTE'}
        if( a==1209){this.natClair = 'VISITE SPECIALISTE MEDECINE GENERALE'}
        if( a==1210){this.natClair = 'VISITE MEDECINE GENERALE'}
        if( a==1211){this.natClair = 'VISITE COTEE V'}
        if( a==1212){this.natClair = 'VISITE COTEE VS'}
        if( a==1213){this.natClair = 'VISITE COTEE VNP'}
        if( a==1214){this.natClair = 'VISITE LONGUE ET COMPLEXE'}
        if( a==1215){this.natClair = 'AVIS PONCTUEL DE CONSULTANT MEDECIN (VISITE)'}
        if( a==1216){this.natClair = 'AVIS PONCTUEL DE CONSULTANT PSYCHIATRE (VISITE)'}
        if( a==1221){this.natClair = 'VISITE D  URGENCE'}
        if( a==1222){this.natClair = 'VISITE URGENCE VU/MU'}
        if( a==1223){this.natClair = 'MAJORATION MAINTIEN A DOMICILE'}
        if( a==1224){this.natClair = 'MD (CRITERES MEDICAUX)'}
        if( a==1225){this.natClair = 'MDE ( CRITERES ENVIRONNEMENTAUX)'}
        if( a==1226){this.natClair = 'MD DE NUIT'}
        if( a==1227){this.natClair = 'MD  DE MILIEU NUIT'}
        if( a==1228){this.natClair = 'MD  DE DIMANCHE ET JOUR FERIES'}
        if( a==1229){this.natClair = 'MDE  DE NUIT'}
        if( a==1231){this.natClair = 'MDE MILIEU DE NUIT'}
        if( a==1232){this.natClair = 'MDE DIMANCHE ET JOUR FERIES'}
        if( a==1311){this.natClair = 'ACTES EN K CHIRURGICAL'}
        if( a==1312){this.natClair = 'ACTES DE SPECIALITE EN K'}
        if( a==1313){this.natClair = 'ACTES EN K D  URGENCE'}
        if( a==1314){this.natClair = 'FORFAIT CHIRURGIE 1'}
        if( a==1315){this.natClair = 'FORFAIT CHIRURGIE 2'}
        if( a==1316){this.natClair = 'ACTES DE DIAGNOSTIC COTES KE'}
        if( a==1317){this.natClair = 'ACTES EN KCC: ACTES SPECIFIQUES DES CHIRURGIENS'}
        if( a==1318){this.natClair = 'ACTE DE PHONIATRIE PAR MEDECIN'}
        if( a==1319){this.natClair = 'MAJORATION FORFAIT ACCOUCHEMENT'}
        if( a==1320){this.natClair = 'FORFAIT RADIOGRAPHIE){this.natClair =ECHOGRAPHIE'}
        if( a==1321){this.natClair = 'ACTE DE CHIRURGIE CCAM'}
        if( a==1322){this.natClair = 'ACTE D OBSTETRIQUE CCAM'}
        if( a==1323){this.natClair = 'ACTE D ANESTHESIE CCAM'}
        if( a==1324){this.natClair = 'ACTE D ECHOGRAPHIE CCAM'}
        if( a==1331){this.natClair = 'ACTES DE RADIOLOGIE'}
        if( a==1332){this.natClair = 'ACTES DE RADIOLOGIE NUCLEAIRE'}
        if( a==1333){this.natClair = 'MAJORATION POUR PRODUIT RADIOPHARMACEUTIQUE'}
        if( a==1335){this.natClair = 'ACTE DE RADIOLOGIE MAMMOGRAPHIE'}
        if( a==1336){this.natClair = 'ACTE DE RADIOLOGIE MAMMOGRAPHIE DEPISTAGE'}
        if( a==1341){this.natClair = 'ACTES D  ANATOMO-CYTO-PATHOLOGIE/MEDECINS'}
        if( a==1342){this.natClair = 'MAJORATION ANATOMO-CYTO-PATHOLOGIE'}
        if( a==1345){this.natClair = 'MAJORATION TRANSITOIRE'}
        if( a==1351){this.natClair = 'ACTE D IMAGERIE (hors ECHOGRAPHIE) CCAM'}
        if( a==1352){this.natClair = 'ACTES TECHNIQUES MEDICAUX  (hors IMAGERIE) CCAM'}
        if( a==1361){this.natClair = 'VIDEOCAPSULE'}
        if( a==1400){this.natClair = 'BRIDGE RAC MODERE'}
        if( a==1401){this.natClair = 'PROTHESE FIXE RAC 0'}
        if( a==1402){this.natClair = 'PROTHESE FIXE RAC MODERE'}
        if( a==1403){this.natClair = 'REPARATION FACETTE PROTHESE AMOVIBLE RAC 0'}
        if( a==1404){this.natClair = 'REPARATION ADJONCTION RAC 0'}
        if( a==1405){this.natClair = 'REPARATION PROTHESE ADJOINTE SIMPLE RAC 0'}
        if( a==1406){this.natClair = 'SUPPLEMENT PROTHESE RESINE RAC 0'}
        if( a==1407){this.natClair = 'COURONNE TRANSITOIRE RAC MODERE'}
        if( a==1408){this.natClair = 'COURONNE ZIRCONE RAC MODERE'}
        if( a==1409){this.natClair = 'INLAY CORE RAC MODERE'}
        if( a==1410){this.natClair = 'INLAY ONLAY RAC MOERE'}
        if( a==1411){this.natClair = 'ACTES EN SCM (ET SPA POUR LA CRPCEN)'}
        if( a==1412){this.natClair = 'PROTHESE AMOVIBLE RAC MODERE'}
        if( a==1413){this.natClair = 'REPARATION PROTHESE RAC MODERE'}
        if( a==1414){this.natClair = 'SUPPLEMENT PROTHESE METALLIQUE RAC MODERE'}
        if( a==1415){this.natClair = 'PROTHESE FIXE METALLIQUE RAC 0'}
        if( a==1416){this.natClair = 'COURONNE TRANSITOIRE RAC 0'}
        if( a==1417){this.natClair = 'COURONNE ZIRCONE RAC 0'}
        if( a==1418){this.natClair = 'INLAY CORE RAC 0'}
        if( a==1419){this.natClair = 'PROTHESE AMOVIBLE RAC 0'}
        if( a==1420){this.natClair = 'PROTHESE AMOVIBLE DE TRANSITION RAC 0'}
        if( a==1421){this.natClair = 'ACTES DE PROTHESE DENTAIRE PRATIQUES PAR LE MEDECIN'}
        if( a==1422){this.natClair = 'TRAITEMENTS D  ORTHODONTIE PRATIQUES PAR LE MEDECIN (ET EOS POUR LA CRPCEN)'}
        if( a==1423){this.natClair = 'ACTES DE PROTHESE DENTAIRE PRATIQUES PAR LE CHIRURGIEN-DENTISTE'}
        if( a==1424){this.natClair = 'TRAITEMENTS D  ORTHODONTIE PRATIQUES PAR LE CHIRURGIEN-DENTISTE (ET ETO POUR LA CRPCEN)'}
        if( a==1425){this.natClair = 'COMPLEMENT AT 150% DENTAIRE'}
        if( a==1426){this.natClair = 'PEC EXCEPTIONNELLE DÉPASSEMENT DENTAIRE '}
        if( a==1427){this.natClair = 'PEC EXCEPTIONNELLE DEPASSEMENT DENTAIRE TP'}
        if( a==1431){this.natClair = 'ACTES EN D (ET OCC POUR LA CRPCEN)'}
        if( a==1432){this.natClair = 'ACTES EN DC'}
        if( a==1433){this.natClair = 'ACTES EN SC (ET SCA POUR LA CRPCEN)'}
        if( a==1434){this.natClair = 'PREVENTION BUCCO-DENTAIRE: CONSULTATION - MATER'}
        if( a==1435){this.natClair = 'PREVENTION BUCCO-DENTAIRE: RADIO DEUX CLICHES-MATER'}
        if( a==1436){this.natClair = 'PREVENTION BUCCO-DENTAIRE: RADIO QUATRE CLICHES-MATER'}
        if( a==1437){this.natClair = 'Majoration spécifique PDS Clinique Dentiste'}
        if( a==1451){this.natClair = 'SOINS DENTAIRES'}
        if( a==1452){this.natClair = 'PROTHESE AMOVIBLE DEFINITIVE RESINE){this.natClair = A partir du 01/04/2019 (en date de soins) PROTHESE AMOVIBLE RESINE TARIF LIBRE '}
        if( a==1453){this.natClair = 'PROPHYLAXIE BUCCO DENTAIRE CCAM'}
        if( a==1461){this.natClair = 'ACTES DIVERS PROTHESE DENTAIRE CCAM'}
        if( a==1462){this.natClair = 'PROTHESE FIXE METALLIQUE){this.natClair = A partir du 01/04/2019 (en date de soins) PROTHESE FIXE METALLIQUE TARIF LIBRE'}
        if( a==1463){this.natClair = 'PROTHESE DENTAIRE FIXE ESTHETIQUE CCAM'}
        if( a==1464){this.natClair = 'PROTHESE DENTAIRE AMOVIBLE CCAM'}
        if( a==1465){this.natClair = 'IMPLANTOLOGIE - CCAM'}
        if( a==1466){this.natClair = 'TRAITEMENT ORTHOPEDIE DENTO FACIALE CCAM'}
        if( a==1470){this.natClair = 'ENDODONTIE'}
        if( a==1471){this.natClair = 'INLAY-ONLAY){this.natClair = A partir du 01/04/2019 (en date de soins) INLAY-ONLAY TARIF LIBRE'}
        if( a==1472){this.natClair = 'PARODONTOLOGIE'}
        if( a==1473){this.natClair = 'INLAY-CORE){this.natClair = A partir du 01/04/2019 (en date de soins) INLAY-CORE TARIF LIBRE'}
        if( a==1474){this.natClair = 'PROTHESE AMOVIBLE DEFINITIVE METALLIQUE){this.natClair = A partir du 01/04/2019 (en date de soins) PROTHESE AMOVIBLE METALLIQUE TARIF LIBRE'}
        if( a==1475){this.natClair = 'PROTHESE DENTAIRE PROVISOIRE){this.natClair = A partir du 01/04/2019 (en date de soins) COURONNE TRANSITOIRE TARIF LIBRE '}
        if( a==1476){this.natClair = 'PROTHESE FIXE CERAMIQUE){this.natClair = A partir du 01/04/2019 (en date de soins) PROTHESE FIXE CERAMIQUE TARIF LIBRE'}
        if( a==1477){this.natClair = 'REPARATION SUR PROTHESE){this.natClair = A partir du 01/04/2019 (en date de soins) REPARATION PROTHESE TARIF LIBRE'}
        if( a==1511){this.natClair = 'FORFAIT D  ACCOUCHEMENT SIMPLE DES SAGES-FEMMES (FORFAIT N91)'}
        if( a==1521){this.natClair = 'MAJORATION POUR GARDE'}
        if( a==1522){this.natClair = 'MAJORATION ASTREINTE'}
        if( a==1523){this.natClair = 'Permanence Rémunération demi-journée Chirurgien-dentiste'}
        if( a==1602){this.natClair = 'FORFAIT CONTRAT DE BONNES PRATIQUES'}
        if( a==1603){this.natClair = 'FORFAIT CONTRAT DE BONNES PRATIQUES CP1'}
        if( a==1605){this.natClair = 'FORFAIT CONTRAT DE BONNES PRATIQUES CP3'}
        if( a==1606){this.natClair = 'FORFAIT CONTRAT DE BONNES PRATIQUES'}
        if( a==1607){this.natClair = 'FORFAIT CONTRAT DE SANTE PUBLIQUE INFIRMIER'}
        if( a==1608){this.natClair = 'FORFAIT CONTRAT DE SANTE PUBLIQUE BIOLOGISTES'}
        if( a==1609){this.natClair = 'CONTRAT DE BONNES PRATIQUES ZONE RURAL'}
        if( a==1610){this.natClair = 'RÉMUNÉRATION CONTRAT D ACCÈS AUX SOINS DENTAIRES'}
        if( a==1611){this.natClair = 'CONTRAT DE BONNES PRATIQUES ZONE MONTAGNE'}
        if( a==1612){this.natClair = 'CONTRAT DE BONNES PRATIQUES ZONE URBAINE'}
        if( a==1613){this.natClair = 'CONTRAT DE BONNES PRATIQUES ZONE FRANCHE URBAINE'}
        if( a==1614){this.natClair = 'CONTRAT DE BONNES PRATIQUES TRANSPORTEURS 2006'}
        if( a==1615){this.natClair = 'CONTRAT DE BONNES PRATIQUES TRANSPORTEURS 2007'}
        if( a==1616){this.natClair = 'CONTRAT DE BONNES PRATIQUES TRANSPORTEURS 2008'}
        if( a==1617){this.natClair = 'REDEVANCE CHEF DE CLINIQUE'}
        if( a==1618){this.natClair = 'COMPLEMENT DE REMUNERATION CHEF DE CLINIQUE'}
        if( a==1619){this.natClair = 'CONTRAT SANTE SOLIDARITE'}
        if( a==1621){this.natClair = 'CONTRAT D AMELIORATION DE L ORGANISATION DES SOINS - TRANSPORTS'}
        if( a==1622){this.natClair = 'CONTRAT D AMELIORATION DE L ORGANISATION DES SOINS - PHARMACIE/LPP'}
        if( a==1623){this.natClair = 'REVERSEMENTS CONTRAT D AMELIORATION DE L ORGANISATION DES SOINS TRANSPORTS'}
        if( a==1624){this.natClair = 'REVERSEMENTS CONTRAT D AMELIORATION DE L ORGANISATION DES SOINS - PHARMACIE / LPP'}
        if( a==1625){this.natClair = 'PENALITES CONTRAT D AMELIORATION DE L ORGANISATION DES SOINS - TRANSPORT'}
        if( a==1627){this.natClair = 'CONTRAT INCITATIF CHIRURGIEN-DENTISTE'}
        if( a==1628){this.natClair = 'DEMO. AIDE FORFAITAIRE GROUPE'}
        if( a==1629){this.natClair = 'DEMO. AIDE FORFAITAIRE POLE SANTE'}
        if( a==1630){this.natClair = 'DEMO. ACTIVITE GROUPE'}
        if( a==1631){this.natClair = 'DEMO. ACTIVITE POLE SANTE'}
        if( a==1632){this.natClair = 'SST AIDE ACTIVITE'}
        if( a==1633){this.natClair = 'SST FRAIS DEPLACEMENT'}
        if( a==1634){this.natClair = 'CONTESTATION POUR AIDE FORFAITAIRE POUR LES ADHERENTS A L OPTION DEMOGRAPHIE DANS UN GROUPE'}
        if( a==1636){this.natClair = 'CONTESTATION POUR AIDE A L ACTIVITE POUR LES ADHERENTS A L OPTION DEMOGRAPHIE DANS UN GROUPE'}
        if( a==1640){this.natClair = 'FORFAIT AIDE A L INSTALLATION DU MEDECIN - CAIM'}
        if( a==1641){this.natClair = 'MAJORATION AIDE À L INSTALLATION DU MEDECIN - CAIM'}
        if( a==1642){this.natClair = 'MAJORATION POUR EXERCICE PARTIEL EN HÔPITAL DE PROXIMITÉ - CAIM'}
        if( a==1643){this.natClair = 'PAIEMENT AIDE ACTIVITE - CSTM'}
        if( a==1644){this.natClair = 'MAJO REMUNERATION ARS - CSTM'}
        if( a==1645){this.natClair = 'PAIEMENT PRISE EN CHARGE FRAIS DEPLACEMENT - CSTM'}
        if( a==1646){this.natClair = 'AIDE FORFAITAIRE - COSCOM'}
        if( a==1647){this.natClair = 'REMUNERATION COMPLEMENTAIRE ACCUEIL DE STAGIAIRE - COSCOM'}
        if( a==1648){this.natClair = 'REMUNERATION COMPLEMENTAIRE EXERCICE EN HOPITAL - COSCOM'}
        if( a==1649){this.natClair = 'PAIEMENT MAJORATION DE LA REMUNERATION ARS - COSCOM'}
        if( a==1650){this.natClair = 'AIDE A L ACTIVITE   COTRAM'}
        if( a==1651){this.natClair = 'PAIEMENT MAJORATION REMUNERATION ARS   COTRAM'}
        if( a==1652){this.natClair = 'PTMR  -  REMPLACEMENT'}
        if( a==1653){this.natClair = 'PTMR  - MALADIE,MATERNITE,PATERNITE'}
        if( a==1701){this.natClair = 'CDS  MEDICAL OPTANT FORF DEBUT'}
        if( a==1702){this.natClair = 'CDS MEDICAL OPTANT FORF FIN'}
        if( a==1703){this.natClair = 'CDS MEDICAL OPTANT FORFTACITE'}
        if( a==1704){this.natClair = 'CDS DENTAIRE OPTANT FORF INITIAL'}
        if( a==1705){this.natClair = 'CDS DENTAIRE OPTANT FORF SUIVI'}
        if( a==1706){this.natClair = 'CDS DENTAIRE OPTANT FORF FINAL'}
        if( a==1707){this.natClair = 'CDS INFIRMIER OPTANT FORF DEBUT'}
        if( a==1708){this.natClair = 'CDS INFIRMIER OPTANT FORF FIN'}
        if( a==1711){this.natClair = 'FORFAIT MEDECIN REFERENT DEBUT DE CONTRAT'}
        if( a==1712){this.natClair = 'FORFAIT MEDECIN REFERENT FIN DE CONTRAT'}
        if( a==1718){this.natClair = 'FORFAIT D ADHESION ZONE DEFICITAIRE'}
        if( a==1721){this.natClair = 'FORFAIT PROFESSIONNEL (F01) FILIERES ET RESEAUX'}
        if( a==1722){this.natClair = 'FORFAIT PROFESSIONNEL (F02) FILIERES ET RESEAUX'}
        if( a==1724){this.natClair = 'FORFAIT PROFESSIONNEL (F04) FILIERES ET RESEAUX'}
        if( a==1727){this.natClair = 'FORFAIT PROFESSIONNEL (F07) FILIERES ET RESEAUX'}
        if( a==1728){this.natClair = 'FORFAIT PROFESSIONNEL (F08) FILIERES ET RESEAUX'}
        if( a==1729){this.natClair = 'FORFAIT PROFESSIONNEL (F09) FILIERES ET RESEAUX'}
        if( a==1735){this.natClair = 'FORFAIT PROFESSIONNEL (F14) FILIERES ET RESEAUX'}
        if( a==1744){this.natClair = 'FORFAIT CONSULTATION (FC3) FILIERES ET RESEAUX'}
        if( a==1745){this.natClair = 'FORFAIT CONSULTATION (FC4) FILIERES ET RESEAUX'}
        if( a==1763){this.natClair = 'FORFAIT FORMATION (FF2) FILIERES ET RESEAUX'}
        if( a==1764){this.natClair = 'FORFAIT FORMATION (FF3) FILIERES ET RESEAUX'}
        if( a==1766){this.natClair = 'FORFAIT FORMATION (FF5) FILIERES ET RESEAUX'}
        if( a==1767){this.natClair = 'FORFAIT FORMATION (FF6) FILIERES ET RESEAUX'}
        if( a==1771){this.natClair = 'FORFAIT FORMATION (FF9) FILIERES ET RESEAUX'}
        if( a==1781){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP0) FILIERES ET RESEAUX'}
        if( a==1782){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP1) FILIERES ET RESEAUX'}
        if( a==1783){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP2) FILIERES ET RESEAUX'}
        if( a==1784){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP3) FILIERES ET RESEAUX'}
        if( a==1785){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP4) FILIERES ET RESEAUX'}
        if( a==1786){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP5) FILIERES ET RESEAUX'}
        if( a==1787){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP6) FILIERES ET RESEAUX'}
        if( a==1788){this.natClair = 'FORFAIT PREVENTION/DEPISTAGE (FP7) FILIERES ET RESEAUX'}
        if( a==1811){this.natClair = 'IK PLAINE'}
        if( a==1812){this.natClair = 'IK MONTAGNE'}
        if( a==1813){this.natClair = 'IK PIED SKI'}
        if( a==1814){this.natClair = 'FRAIS DE DEPLACEMENT VACATION'}
        if( a==1821){this.natClair = 'ID PARIS LYON MARSEILLE,+100.000 HA,-100.000 HA'}
        if( a==1841){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT'}
        if( a==1842){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT DES AUXILIAIRES MEDICAUX ET ASSIMILES'}
        if( a==1843){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT MK ORTHOPEDIQUE ET RHUMATOLOGIQUE'}
        if( a==1844){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT MK RHUMATISMALE'}
        if( a==1845){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT MK NEUROLOGIQUE'}
        if( a==1846){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT MK PNEUMOLOGIE'}
        if( a==1847){this.natClair = 'INDEMNITES FORFAITAIRES DE DEPLACEMENT DE SORTIE'}
        if( a==1903){this.natClair = 'MAJORATION ENFANT GENERALISTE '}
        if( a==1904){this.natClair = 'MAJORATION ENFANT PEDIATRE'}
        if( a==1905){this.natClair = 'NOUVEAU FORFAIT ENFANT'}
        if( a==1906){this.natClair = 'NOUVEAU FORFAIT PEDIATRIQUE'}
        if( a==1907){this.natClair = 'REMUNERATION DES SOINS DE PROXIMITE'}
        if( a==1908){this.natClair = 'FORFAIT SORTIE PRECOCE ET TEST GUTHRIE'}
        if( a==1909){this.natClair = 'FORFAIT SORTIE PRECOCE'}
        if( a==1910){this.natClair = 'Plan personnalisé de santé'}
        if( a==1911){this.natClair = 'ACTES DES SAGES-FEMMES'}
        if( a==1912){this.natClair = 'HONORAIRES NON VENTILABLES INDIVIDUALISES'}
        if( a==1913){this.natClair = 'MAJORATION MILIEU DE NUIT'}
        if( a==1914){this.natClair = 'FORFAIT PEDIATRIQUE'}
        if( a==1915){this.natClair = 'FORFAIT ASTREINTE PROF'}
        if( a==1916){this.natClair = 'REMUNERATION POUR GARDE ETS PRIVES'}
        if( a==1917){this.natClair = 'REMUNERATION POUR ASTREINTE ETS PRIVES'}
        if( a==1918){this.natClair = 'MAJORATION D URGENCE'}
        if( a==1920){this.natClair = 'CONTRAT DEMOGRAPHIQUE SAGE-FEMME'}
        if( a==1921){this.natClair = 'TEST DE DIAGNOSTIC RAPIDE '}
        if( a==1922){this.natClair = 'CONSULTATION'}
        if( a==1923){this.natClair = 'EXAMEN DE SUIVI POST NATAL'}
        if( a==1924){this.natClair = 'REMUNERATION VACCINATION GRIPPE A MEDECIN'}
        if( a==1925){this.natClair = 'REMUNERATION VACCINATION GRIPPE A PAR MEDECIN RETRAITE ET SALARIES HORS OBLIGATIONS '}
        if( a==1926){this.natClair = 'ACTE DE VACCINATION GRIPPE A/H1N1'}
        if( a==1931){this.natClair = 'MAJORATION NOURRISSON PEDIATRE'}
        if( a==1932){this.natClair = 'MAJORATION NOURRISSON GENERALISTE'}
        if( a==1933){this.natClair = 'MAJORATION CONSULTATION REGULEE  DE NUIT'}
        if( a==1934){this.natClair = 'MAJORATION CONSULTATION REGULEE MILIEU DE NUIT'}
        if( a==1935){this.natClair = 'MAJORATION CONSULTATION REGULEE DIMANCHE){this.natClair = JOURS FERIES ET ASSIMILES'}
        if( a==1936){this.natClair = 'MAJORATION VISITE REGULEE  DE NUIT'}
        if( a==1937){this.natClair = 'MAJORATION VISITE REGULEE MILIEU DE NUIT'}
        if( a==1938){this.natClair = 'MAJORATION VISITE REGULEE DE DIMANCHE){this.natClair = JOURS FERIES ET ASSIMILES'}
        if( a==1939){this.natClair = 'MAJORATION SAGE-FEMME'}
        if( a==1940){this.natClair = 'FORFAIT SORTIE PRECOCE'}
        if( a==1941){this.natClair = 'MAJORATION CONSULTATION REGULEE SAMEDI APRES MIDI'}
        if( a==1942){this.natClair = 'MAJORATION VISITE REGULEE SAMEDI APRES MIDI'}
        if( a==1943){this.natClair = 'MAJORATION URGENCE MT'}
        if( a==1944){this.natClair = 'MAJORATION CORRESPONDANT URGENCE'}
        if( a==1945){this.natClair = 'MAJORATION MEDECIN TRAITANT REGULATION'}
        if( a==1951){this.natClair = 'PARTICIPATION FORFAITAIRE HORS TIERS PAYANT'}
        if( a==1952){this.natClair = 'PARTICIPATION FORFAITAIRE TIERS PAYANT'}
        if( a==1954){this.natClair = 'PARTICIPATION ASSURE CONSULTATIONS ET SOINS EXTERNES (CMU + AME)'}
        if( a==1955){this.natClair = 'PARTICIPATION ASSURE CONSULTATIONS ET SOINS EXTERNES (REGIME LOCAL)'}
        if( a==1956){this.natClair = 'PARTICIPATION ASSURE EN AMBULATOIRE'}
        if( a==1957){this.natClair = 'MAJORATION HORS PARCOURS DE SOINS'}
        if( a==1960){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR ACTE PROFESSIONNEL NON REMBOURSABLE (CNMSS)'}
        if( a==1961){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR ACTE PROFESSIONNEL REMBOURSABLE (CNMSS)'}
        if( a==1971){this.natClair = 'FRANCHISE HORS TIERS PAYANT SUR MEDICAMENT'}
        if( a==1972){this.natClair = 'FRANCHISE TIERS PAYANT SUR MEDICAMENT'}
        if( a==1973){this.natClair = 'FRANCHISE HORS TIERS PAYANT SUR TRANSPORT'}
        if( a==1974){this.natClair = 'FRANCHISE TIERS PAYANT SUR TRANSPORT'}
        if( a==1975){this.natClair = 'FRANCHISE HORS TIERS PAYANT ACTE D AUXILIAIRE MEDICAUX'}
        if( a==1976){this.natClair = 'FRANCHISE TIERS PAYANT ACTE D AUXILIAIRE MEDICAUX'}
        if( a==1977){this.natClair = 'PARTICIPATION ASSURE HORS TIERS PAYANT TRANSMISE SANS ACTE DE REFERENCE OU TYPE DE FRANCHISES'}
        if( a==1978){this.natClair = 'PARTICIPATION ASSURE EN TIERS PAYANT TRANSMISE SANS ACTE DE REFERENCE OU TYPE DE FRANCHISES'}
        if( a==1981){this.natClair = 'FORFAIT IVG HONORAIRES DE VILLE'}
        if( a==1990){this.natClair = 'FORFAIT D INTERVENTION PAR SORTIE SUR DEMANDE DE LA REGULATION'}
        if( a==1991){this.natClair = 'REMUNERATION REGULATION'}
        if( a==1992){this.natClair = 'PERMANENCE REMUNERATION DE NUIT'}
        if( a==1993){this.natClair = 'PERMANENCE REMUNERATION MILIEU DE NUIT'}
        if( a==1994){this.natClair = 'PERMANENCE REMUNERATION DIMANCHE ET FERIE'}
        if( a==1995){this.natClair = 'PERMANENCE REMUNERATION TOTAL'}
        if( a==1996){this.natClair = 'PERMANENCE REMUNERATION SAMEDI MATIN'}
        if( a==1997){this.natClair = 'PERMANENCE REMUNERATION SAMEDI APRES MIDI'}
        if( a==1998){this.natClair = 'ASTREINTE DE JOUR CORRESPONDANT SAMU'}
        if( a==1999){this.natClair = 'ASTREINTE DE NUIT CORRESPONDANT SAMU'}
        if( a==2103){this.natClair = 'SUPPLEMENT TRANSPORT PERMISSION THERAPEUTIQUE (PSY/SSR)'}
        if( a==2104){this.natClair = 'SUPPLEMENT TRANSPORT PROVISOIRE (PSY/SSR)'}
        if( a==2105){this.natClair = 'SUPPLEMENT TRANSPORT DEFINITIF (PSY/SSR)'}
        if( a==2106){this.natClair = 'TRANSPORT DEFINITIF DIALYSE'}
        if( a==2107){this.natClair = 'TRANSPORT SEANCE DIALYSE'}
        if( a==2108){this.natClair = 'SUPPLEMENT TRANSPORT 2'}
        if( a==2109){this.natClair = 'SUPPLEMENT TRANSPORT SEANCES'}
        if( a==2111){this.natClair = 'FRAIS D HEBERGEMENT ET ENVIRONNEMENT EN GHS'}
        if( a==2112){this.natClair = 'FRAIS DE SEJOUR SUPPLEMENTAIRE AU GHS'}
        if( a==2113){this.natClair = 'GROUPE HOMOGENE DE TARIFS'}
        if( a==2114){this.natClair = 'SUPPLEMENT SOINS PARTICULIEREMENT COUTEUX (ARRETE DU 29/06/1978)'}
        if( a==2115){this.natClair = 'SUPPLEMENT SOINS CONTINUS'}
        if( a==2116){this.natClair = 'SUPPLEMENT NEONATOLOGIE 1'}
        if( a==2117){this.natClair = 'SUPPLEMENT NEONATOLOGIE 2'}
        if( a==2118){this.natClair = 'SUPPLEMENT NEONATOLOGIE 3'}
        if( a==2119){this.natClair = 'SUPPLEMENT DEFIBRILLATEUR'}
        if( a==2120){this.natClair = 'DIFFERENTIEL TARIFAIRE CLINIQUE'}
        if( a==2121){this.natClair = 'HEMODIALYSE EN CENTRE OU EN UNITE DE DIALYSE MEDICALISEE'}
        if( a==2122){this.natClair = 'AUTODIALYSE SIMPLE OU ASSISTEE'}
        if( a==2123){this.natClair = 'ENTRAINEMENT A L HEMODIALYSE A DOMICILE ET A L AUTODIALYSE'}
        if( a==2124){this.natClair = 'ENTRAINEMENT A LA DPA'}
        if( a==2125){this.natClair = 'ENTRAINEMENT A LA DPCA'}
        if( a==2126){this.natClair = 'HEMODIALYSE A DOMICILE'}
        if( a==2127){this.natClair = 'DIALYSE PERITONEALE AUTOMATISEE (DPA)'}
        if( a==2128){this.natClair = 'DIALYSE PERITONEALE CONTINUE AMBULATOIRE (DPCA)'}
        if( a==2129){this.natClair = 'FORFAIT D HEMODIALYSE EN CENTRE'}
        if( a==2131){this.natClair = 'FORFAIT D HEMODIALYSE EN CENTRE POUR ENFANT'}
        if( a==2132){this.natClair = 'FORFAIT D HEMODIALYSE EN UNITE DE DIALYSE MEDICALISEE'}
        if( a==2133){this.natClair = 'DIALYSE TIERCE PERSONNE'}
        if( a==2134){this.natClair = 'FORFAIT D AUTODIALYSE SIMPLE'}
        if( a==2135){this.natClair = 'FORFAIT D AUTODIALYSE ASSISTEE'}
        if( a==2136){this.natClair = 'FORFAIT D HEMODIALYSE A DOMICILE'}
        if( a==2137){this.natClair = 'FORFAIT DE DIALYSE PERITONEALE AUTOMATISEE (DPA)'}
        if( a==2138){this.natClair = 'FORFAIT DE DIALYSE PERITONEALE CONTINUE AMBULATOIRE (DPCA)'}
        if( a==2139){this.natClair = 'FORFAIT D ENTRAINEMENT A L HEMODIALYSE A  DOMICILE ET AUTODIALYSE'}
        if( a==2140){this.natClair = 'FORFAIT D ENTRAINEMENT A LA DIALYSE PERITONEALE AUTOMATISEE'}
        if( a==2141){this.natClair = 'FRAIS DE CHAMBRE PARTICULIERE POUR CONVENANCE PERSONNELLE'}
        if( a==2142){this.natClair = 'FORFAIT D ENTRAINEMENT A DIALYSE PERITONEALE CONTINUE AMBULATOIRE'}
        if( a==2143){this.natClair = 'FF D ENTRAINEMENT A LA DIALYSE PERITONEALE AUTOMATISEE A DOMICILE'}
        if( a==2144){this.natClair = 'FF D ENTRAINEMENT A LA DIALYSE PERITONEALE CONTINUE AMBULATOIRE A DOMICILE'}
        if( a==2145){this.natClair = 'FORFAIT DE DIALYSE PERITONEALE AUTOMATISE POUR HOSPITALISATION DE 3 A 6 JOURS'}
        if( a==2146){this.natClair = 'FORFAIT DE DIALYSE PERITONEALE CONTINUE AMBULATOIRE POUR HOSPITALISATION DE 3 A 6 JOURS'}
        if( a==2147){this.natClair = 'FORFAIT D ENTRAINEMENT A L HEMODIALYSE EN UNITE DE DIALYSE MEDICALISEE'}
        if( a==2150){this.natClair = 'VIDEOCAPSULE'}
        if( a==2151){this.natClair = 'SUPPLEMENT REANIMATION'}
        if( a==2152){this.natClair = 'SUPPLEMENT SURVEILLANCE CONTINUE'}
        if( a==2153){this.natClair = 'FORFAIT SOINS INTENSIFS'}
        if( a==2154){this.natClair = 'REANIMATION PEDIATRIQUE'}
        if( a==2155){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 1'}
        if( a==2156){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 2'}
        if( a==2157){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 3'}
        if( a==2158){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 4'}
        if( a==2159){this.natClair = 'FORFAIT DE SECURITE DERMATOLOGIQUE'}
        if( a==2160){this.natClair = 'MISSION D  INTERET GENERAL SSR'}
        if( a==2161){this.natClair = 'FORFAIT MISSION D INTERET GENERAL D AIDE A LA CONTRACTUALISATION'}
        if( a==2162){this.natClair = 'FORFAIT HAUTE TECHNICITE'}
        if( a==2163){this.natClair = 'SUPPLEMENT JOURNALIER DIALYSE PERITONEALE'}
        if( a==2164){this.natClair = 'ADMINISTRATION DE PRODUITS ET PRESTATIONS EN ENVIRONNEMENT HOSPITALIER'}
        if( a==2165){this.natClair = 'FORFAIT PRESTATION INTERMEDIAIRE'}
        if( a==2166){this.natClair = 'ADMINISTRATION DE MEDICAMENTS EN ENVIRONNEMENT HOSPITALIER'}
        if( a==2167){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 5'}
        if( a==2168){this.natClair = 'FORFAIT ENVIRONNEMENT HOSPITALIER 6'}
        if( a==2170){this.natClair = 'FIR ETS PRIVES'}
        if( a==2173){this.natClair = 'DIFFERENTIEL PSY REGLEMENTAIRE'}
        if( a==2176){this.natClair = 'DIFFERENTIEL SSR REGLEMENTAIRE'}
        if( a==2181){this.natClair = 'PRELEVEMENT D ORGANE 1'}
        if( a==2182){this.natClair = 'PRELEVEMENT D ORGANE 2'}
        if( a==2183){this.natClair = 'PRELEVEMENT D ORGANE 3'}
        if( a==2184){this.natClair = 'COORDINATION PRELEVEMENT D ORGANES'}
        if( a==2185){this.natClair = 'PRELEVEMENT D ORGANE 4'}
        if( a==2186){this.natClair = 'PRELEVEMENT D ORGANE 5'}
        if( a==2187){this.natClair = 'PRELEVEMENT D ORGANE 6'}
        if( a==2188){this.natClair = 'PRELEVEMENT D ORGANE 7'}
        if( a==2189){this.natClair = 'PRELEVEMENT D ORGANE 8'}
        if( a==2190){this.natClair = 'PRELEVEMENT D ORGANE 9'}
        if( a==2191){this.natClair = 'PRELEVEMENT D ORGANE'}
        if( a==2195){this.natClair = 'SUPPLEMENT ANTEPARTUM'}
        if( a==2202){this.natClair = 'MEDICALISATION DES PERSONNES AGEES'}
        if( a==2204){this.natClair = 'CAMSP: CENTRE ACTION MEDICO-SOCIALE PRECOCE'}
        if( a==2206){this.natClair = 'VIH'}
        if( a==2211){this.natClair = 'FRAIS DE SEJOUR'}
        if( a==2212){this.natClair = 'MAJORATION PMSI'}
        if( a==2213){this.natClair = 'FRAIS DE SEJOUR IME'}
        if( a==2214){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR PRESTATION SEJOUR NON REMBOURSABLE (CNMSS)'}
        if( a==2215){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR PRESTATION SEJOUR REMBOURSABLE (CNMSS)'}
        if( a==2221){this.natClair = 'SUPPLEMENT CHAMBRE PARTICULIERE'}
        if( a==2222){this.natClair = 'SUPPLEMENT POUR SURVEILLANCE DU MALADE'}
        if( a==2223){this.natClair = 'FRAIS D  HOSPITALISATION DU NOUVEAU-NE DONNANT LIEU A FACTURATION EN SUPPLEMENT DE L  HOSPITALISATION DE LA MERE EN MAISON DE REPOS'}
        if( a==2224){this.natClair = 'SUPPLEMENT POUR  CHAMBRE CHAUDE'}
        if( a==2225){this.natClair = 'SUPPLEMENT POUR INCUBATEUR'}
        if( a==2227){this.natClair = 'SUPPLEMENT POUR ALIMENTATION PARENTERALE'}
        if( a==2229){this.natClair = 'FORFAIT PRISE EN CHARGE DU NOUVEAU NE'}
        if( a==2230){this.natClair = 'PRIX DE JOURNEE REGIME LOCAL'}
        if( a==2231){this.natClair = 'FORFAIT PHARMACEUTIQUE'}
        if( a==2232){this.natClair = 'FORFAIT TRANSPLANTATION D  ORGANE'}
        if( a==2234){this.natClair = 'FORFAIT D  ENTREE'}
        if( a==2235){this.natClair = 'FORFAIT D  ACTIVITE NON PROGRAMMEE'}
        if( a==2236){this.natClair = 'FORFAIT CONSOMMABLE CARDIOLOGIE'}
        if( a==2237){this.natClair = 'PART COMPLEMENTAIRE AIDE MEDICALE ETAT (REGULARISATION CMU COMPLEMENTAIRE)'}
        if( a==2238){this.natClair = 'FORFAIT D ACCUEIL ET DE TRAITEMENT DES URGENCES'}
        if( a==2239){this.natClair = 'FORFAIT ANNUEL D URGENCE'}
        if( a==2240){this.natClair = 'TARIF JOURNALIER COMPLEMENTAIRE'}
        if( a==2241){this.natClair = 'FRAIS DE SALLE D  OPERATION'}
        if( a==2242){this.natClair = 'FRAIS D  ANESTHESIE ET REANIMATION'}
        if( a==2243){this.natClair = 'FRAIS D  ENVIRONNEMENT'}
        if( a==2245){this.natClair = 'FRAIS DE SALLE D  ACCOUCHEMENT'}
        if( a==2246){this.natClair = 'FRAIS DE SALLE D  ACCOUCHEMENT MULTIPLE'}
        if( a==2247){this.natClair = 'FORFAIT PSYCHIATRIE  DE SECURITE - HOSPITALISATION AVEC HEBERGEMENT'}
        if( a==2248){this.natClair = 'Forfait Innovation HIFU'}
        if( a==2249){this.natClair = 'FORFAIT ACTIVITE ISOLE'}
        if( a==2250){this.natClair = 'FORFAIT JOURNALIER AIDE MEDICALE (REGULARISATION CMU COMPLEMENTAIRE)'}
        if( a==2251){this.natClair = 'FORFAIT JOURNALIER'}
        if( a==2252){this.natClair = 'FORFAIT JOURNALIER DE SORTIE'}
        if( a==2257){this.natClair = 'FJ TRANSPLANTATION ORGANES'}
        if( a==2258){this.natClair = 'FORFAIT DE SOINS JOURNALIER'}
        if( a==2259){this.natClair = 'SAISIE MANUELLE DES SEJOURS POUR LEQUELS LE FJ EST SUPERIEUR AU TM'}
        if( a==2260){this.natClair = 'FORFAIT HOPITAL PROXIMITE COMPLEMENTAIRE'}
        if( a==2261){this.natClair = 'FORFAIT ACCUEIL DU PATIENT N 1'}
        if( a==2262){this.natClair = 'FORFAIT ACCUEIL DU PATIENT N 2'}
        if( a==2263){this.natClair = 'FORFAIT IFAQ'}
        if( a==2264){this.natClair = 'FORFAIT IFAQ SSR'}
        if( a==2265){this.natClair = 'DOTATION MODULEE A L ACTIVITE'}
        if( a==2268){this.natClair = 'FORFAIT INNOVATION RETINA'}
        if( a==2271){this.natClair = 'FORFAIT HPT GROUPE 1'}
        if( a==2273){this.natClair = 'FORFAIT HPT 15 %'}
        if( a==2282){this.natClair = 'PARTICIPATION ASSURE TRANSITOIRE'}
        if( a==2283){this.natClair = 'PARTICIPATION ASSURE HOSPITALISATION PUBLIQUE (CMU + AME)'}
        if( a==2284){this.natClair = 'PARTICIPATION ASSURE HOSPITALISATION PUBLIQUE (REGIME LOCAL)'}
        if( a==2285){this.natClair = 'PARTICIPATION ASSURE SUR SEJOUR'}
        if( a==2321){this.natClair = 'FORFAIT - LONG SEJOUR PERSONNES AGEES'}
        if( a==2331){this.natClair = 'RADIUMTHERAPIE ET CHIMIOTHERAPIE'}
        if( a==2332){this.natClair = 'READAPTATION FONCTIONNELLE'}
        if( a==2333){this.natClair = 'REEDUCATION PROFESSIONNELLE'}
        if( a==2334){this.natClair = 'SEANCE D  HEMODIALYSE'}
        if( a==2335){this.natClair = 'FORFAIT DE PANSEMENT'}
        if( a==2336){this.natClair = 'FORFAIT POUR CONSULTATION EN CENTRE MEDICO-PSYCHO PEDAGOGIQUE'}
        if( a==2337){this.natClair = 'SEANCE DE DIAGNOSTIC'}
        if( a==2338){this.natClair = 'FORFAIT PETIT MATERIEL'}
        if( a==2339){this.natClair = 'AUTRES FORFAITS DIVERS (Y COMPRIS NUTRITION ENTERALE A DOMICILE)'}
        if( a==2341){this.natClair = 'SUPPLEMENT AU FORFAIT CHIMIOTHERAPIE'}
        if( a==2342){this.natClair = 'FORFAIT POUR GARDE DE DEBUT DE NUIT EN ETABLIS. PRIVE'}
        if( a==2343){this.natClair = 'FORFAIT POUR GARDE DE NUIT OU SAMEDI APRES MIDI EN ETABLIS. PRIVE'}
        if( a==2344){this.natClair = 'FORFAIT DE GARDE NUIT ET FERIE EN ETABLIS. PRIVE'}
        if( a==2345){this.natClair = 'FORFAIT POUR ASTREINTE DE DEBUT DE NUIT EN ETABLIS. PRIVE'}
        if( a==2346){this.natClair = 'FORFAIT POUR ASTREINTE DE NUIT OU SAMEDI APRES MIDI EN ETABLIS. PRIVE'}
        if( a==2347){this.natClair = 'FORFAIT D ASTREINTE NUIT ET FERIE EN ETABLIS. PRIVE'}
        if( a==2351){this.natClair = 'FORFAIT TECHNIQUE NORMAL IRMN -SCANNERS'}
        if( a==2352){this.natClair = 'FORFAIT TECHNIQUE REDUIT IRMN -SCANNERS'}
        if( a==2353){this.natClair = 'FORFAIT TECHNIQUE SCANNER (SPP expo amiante)'}
        if( a==2354){this.natClair = 'FORFAIT TECHNIQUE TOMOGRAPHIE'}
        if( a==2355){this.natClair = 'FORFAIT CONCOMMABLE MEDECINE NUCLEAIRE 01'}
        if( a==2371){this.natClair = 'TARIF SOINS GIR 1 ET 2'}
        if( a==2372){this.natClair = 'TARIF SOINS GIR 3 ET 4'}
        if( a==2380){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE COLL){this.natClair = 1 INTERVENANT 3 à 4H'}
        if( a==2381){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE IND){this.natClair = 1 INTERVENANT 3 à 4H'}
        if( a==2382){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE COLL){this.natClair = 2 INTERVENANTS 3 à 4H'}
        if( a==2383){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE IND. 2 INTERVENANTS 3 à 4H'}
        if( a==2384){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE COLL){this.natClair = 1 INTERVENANT 6 à 8H'}
        if( a==2385){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE IND. 1 INTERVENANT 6 à 8H'}
        if( a==2386){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE COLL){this.natClair = 2 INTERVENANT 6 à 8H'}
        if( a==2387){this.natClair = 'FORFAIT PSYCHIATRIE SEANCE IND. 2 INTERVENANTS 6 à 8H'}
        if( a==2388){this.natClair = 'FORFAIT PSYCHIATRIE DE SECURITE HOSPITALISATION SANS HEBERGEMENT'}
        if( a==2389){this.natClair = 'PRISE EN CHARGE DE NUIT POUR UNE DUREE ENTRE 8 ET 12H'}
        if( a==2391){this.natClair = 'FORFAIT TECHNIQUE TARIF REDUIT N°2'}
        if( a==2392){this.natClair = 'FORFAIT TECHNIQUE TARIF REDUIT N°3'}
        if( a==2411){this.natClair = 'INTERVENTION IVG'}
        if( a==2412){this.natClair = 'ANESTHESIE GENERALE'}
        if( a==2413){this.natClair = 'INVESTIGATIONS BIOLOGIQUES'}
        if( a==2414){this.natClair = 'CONSULTATION IVG'}
        if( a==2415){this.natClair = 'MEDICAMENTS: MIFEYGINE'}
        if( a==2416){this.natClair = 'MEDICAMENTS: PROSTAGLANDINES'}
        if( a==2417){this.natClair = 'VERIFICATION BIOLOGIQUE'}
        if( a==2418){this.natClair = 'VERIFICATION ECHOGRAPHIQUE'}
        if( a==2419){this.natClair = 'FORFAIT INTERVENTION AMBULATOIRE'}
        if( a==2420){this.natClair = 'FORFAIT INTERVENTION DUREE < OU = 12 H PRIVE MEDIC'}
        if( a==2421){this.natClair = 'INTERVENTION + ANESTHESIE AMBULATOIRE'}
        if( a==2422){this.natClair = 'FORFAIT POUR IVG MEDICAMENTEUSE'}
        if( a==2423){this.natClair = 'FORFAIT INTERVENTION AVEC NUITEE'}
        if( a==2424){this.natClair = 'INTERVENTION + ANESTHESIE AVEC NUITEE'}
        if( a==2425){this.natClair = 'FORFAIT IVG POUR 24H SUPPLEMENTAIRES - SECTEUR PRIVE/SECTEUR PUBLIC'}
        if( a==2426){this.natClair = 'CONSULTATION IVG SPECIALISTE'}
        if( a==2428){this.natClair = 'ECHO PRE IVG'}
        if( a==2501){this.natClair = 'FORFAIT FIR PDSES PUBLIQUE'}
        if( a==2502){this.natClair = 'FORFAIT FIR CENTRE DEPISTAGE ANONYME ET GRATUIT'}
        if( a==2503){this.natClair = 'FORFAIT FIR CENTRE PERINATAUX DE PROXIMITE'}
        if( a==2504){this.natClair = 'FORFAIT FIR EDUCATION THERAPEUTIQUE'}
        if( a==3101){this.natClair = 'FORFAIT STRUCTURE PS AUXILIAIRES'}
        if( a==3110){this.natClair = 'CONTRAT INCITATIF INFIRMIER'}
        if( a==3111){this.natClair = 'ACTES EN AMI'}
        if( a==3112){this.natClair = 'ACTES INFIRMIERS DE SOINS (AMI3-AMI13){this.natClair =AMI16)'}
        if( a==3113){this.natClair = 'ACTES INFIRMIERS DES SAGES-FEMMES (SFI)'}
        if( a==3115){this.natClair = 'DEMARCHE INFIRMIER'}
        if( a==3116){this.natClair = 'MAJORATION POUR ACTE UNIQUE'}
        if( a==3117){this.natClair = 'MAJORATION DE COORDINATION ET D ENVIRONNEMENT DE SOIN INFIRMIER'}
        if( a==3118){this.natClair = 'REMUNERATION VACCINATION GRIPPE A PAR INFIRMIERS LIBERAUX'}
        if( a==3119){this.natClair = 'REMUNERATION VACCINATION GRIPPE A PAR INFIRMIER RETRAITE OU SALARIE HORS OBLIGATIONS '}
        if( a==3121){this.natClair = 'ACTES AMC'}
        if( a==3122){this.natClair = 'ACTES EN AMK'}
        if( a==3125){this.natClair = 'ACTES DE KINESITHERAPIE OSTEO-ARTICULAIRE'}
        if( a==3126){this.natClair = 'CONTRAT DEMOGRAPHIQUE KINE'}
        if( a==3127){this.natClair = 'FORFAIT PRISE EN CHARGE AVC'}
        if( a==3128){this.natClair = 'RETOUR A DOMICILE POST CHIRURGIE ORTHOPEDIQUE'}
        if( a==3131){this.natClair = 'ACTES DES PEDICURES'}
        if( a==3132){this.natClair = 'ACTES DES ORTHOPHONISTES'}
        if( a==3133){this.natClair = 'ACTES DES ORTHOPTISTES'}
        if( a==3134){this.natClair = 'ACTE DE PEDICURE-PODOLOGUE (DIABETIQUE)'}
        if( a==3135){this.natClair = 'FORFAIT EVALUATION DOMICILE HANDICAP'}
        if( a==3136){this.natClair = 'MAJORATION ENFANT - ORTHOPHONIE'}
        if( a==3137){this.natClair = 'FORFAIT POST HOSPITALISATION - ORTHOPHONIE'}
        if( a==3138){this.natClair = 'FORFAIT EVALUATION DOMICILE HANDICAP - ORTHOPHONIE'}
        if( a==3139){this.natClair = 'CONTRAT INCITATIF ORTHOPHONISTE'}
        if( a==3211){this.natClair = 'ACTES DE BIOLOGIE'}
        if( a==3212){this.natClair = 'ACTES D  ANATOMO-CYTO-PATHOLOGIE EN LABORATOIRE'}
        if( a==3213){this.natClair = 'FORFAIT PREALABLE BIOLOGIE IVG VILLE'}
        if( a==3216){this.natClair = 'FORFAIT ULTERIEUR BIOLOGIE IVG VILLE'}
        if( a==3221){this.natClair = 'PRELEVEMENT AUTRE QUE SANGUIN PAR UN DIRECTEUR DE LABORATOIRE'}
        if( a==3222){this.natClair = 'PRELEVEMENT SANGUIN PAR UN DIRECTEUR DE LABORATOIRE'}
        if( a==3223){this.natClair = 'PRELEVEMENT SANGUIN PAR UN TECHNICIEN DE LABORATOIRE'}
        if( a==3225){this.natClair = 'PRELEVEMENT PAR PONCTION VEINEUSE DIRECTE POUR UN MEDECIN BIOLOGISTE'}
        if( a==3300){this.natClair = 'REMUNERATION ROSP AOD'}
        if( a==3301){this.natClair = 'CONTESTATION ROSP AOD'}
        if( a==3304){this.natClair = 'PAIEMENT QUALITE DE SERVICE PHARMACIE'}
        if( a==3306){this.natClair = 'BILAN MEDICATION REMUNERATION PHARMACIE'}
        if( a==3307){this.natClair = 'BILAN MEDICATION CONTESTATION PHARMACIE'}
        if( a==3311){this.natClair = 'PHARMACIE 100%'}
        if( a==3312){this.natClair = 'PHARMACIE PH4'}
        if( a==3313){this.natClair = 'PHARMACIE 65%'}
        if( a==3314){this.natClair = 'HORMONE DE CROISSANCE'}
        if( a==3315){this.natClair = 'MEDICAMENTS ANTIRETROVIRAUX'}
        if( a==3316){this.natClair = 'MEDICAMENTS D  EXCEPTION'}
        if( a==3317){this.natClair = ' PHARMACIE HOSPITALIERE A 100%'}
        if( a==3318){this.natClair = ' PHARMACIE HOSPITALIERE A 65%'}
        if( a==3319){this.natClair = ' PHARMACIE HOSPITALIERE '}
        if( a==3320){this.natClair = 'PHARMACIE HOSPITALIERE EN SUS DU GHS'}
        if( a==3321){this.natClair = 'FORFAIT PHARMACEUTIQUE EN MATERNITE'}
        if( a==3322){this.natClair = 'MAJORATION POUR ACHAT HORS HEURES OUVRABLES'}
        if( a==3323){this.natClair = 'COPIE D  ORDONNANCE'}
        if( a==3324){this.natClair = 'ECART MEDICAMENT INDEMNISABLE'}
        if( a==3325){this.natClair = 'MAJORATION PHARMACIE DES ILES'}
        if( a==3326){this.natClair = 'PREPARATION MAGISTRALE REMBOURSABLE'}
        if( a==3327){this.natClair = 'PREPARATION MAGISTRALE HOMEOPATHIQUE'}
        if( a==3328){this.natClair = 'MEDICAMENTS  HOMEOPATHIQUES UNITAIRES'}
        if( a==3329){this.natClair = 'FORFAIT MEDICAMENT IVG VILLE'}
        if( a==3330){this.natClair = 'ECART INDEMNISABLE RETROCESSION'}
        if( a==3331){this.natClair = 'VACCIN ANTI-GRIPPE'}
        if( a==3332){this.natClair = 'VACCIN ROR'}
        if( a==3334){this.natClair = 'Vaccin anti grippe Hémisphère Sud VAXIGRIP HS  '}
        if( a==3335){this.natClair = 'Vaccin anti grippe Hémisphère Sud FLUARIX HS  '}
        if( a==3336){this.natClair = 'PHARMACIE SOUS ATU SEJOUR'}
        if( a==3337){this.natClair = 'FORFAIT FAUSSE COUCHE VILLE'}
        if( a==3338){this.natClair = 'FORFAIT FAUSSE COUCHE VILLE SANS ÉCHOGRAPHIE'}
        if( a==3339){this.natClair = 'FORFAIT FAUSSE COUCHE ETABLISSEMENT AVEC ECHOGRAPHIE'}
        if( a==3340){this.natClair = 'FORFAIT FAUSSE COUCHE ETABLISSEMENT SANS ECHOGRAPHIE'}
        if( a==3341){this.natClair = 'PHARMACIE 15%'}
        if( a==3342){this.natClair = 'PREPARATION MAGISTRALE ALLOPATHIQUE 15 %'}
        if( a==3343){this.natClair = 'PREPARATION MAGISTRALE ALLOPATHIQUE'}
        if( a==3351){this.natClair = 'MEDICAMENT AVEC UNE AUTORISATION TEMPORAIRE D UTILISATION'}
        if( a==3352){this.natClair = 'PREPARATION MAGISTRALE HOSPITALIRE'}
        if( a==3353){this.natClair = 'PREPARATION HOSPITALIERE'}
        if( a==3354){this.natClair = 'MEDICAMENT AVEC AUTORISATION D IMPORTATION'}
        if( a==3355){this.natClair = 'MARGE FORFAITAIRE (MEDICAMENTS HOSPITALIERS)'}
        if( a==3356){this.natClair = 'PHARMACIE HOSPITALIERE DEROGATOIRE'}
        if( a==3357){this.natClair = 'PHARMACIE HOSPITALIERE MMH'}
        if( a==3361){this.natClair = 'GARDE PHARMACIE NUIT'}
        if( a==3362){this.natClair = 'GARDE PHARMACIE FERIE'}
        if( a==3363){this.natClair = 'GARDE PHARMACIE DIMANCHE'}
        if( a==3364){this.natClair = 'HONORAIRE MEDICAMENT REMBOURSABLE'}
        if( a==3365){this.natClair = 'HONORAIRE DISPENSATION EN LIEN AVEC AGE'}
        if( a==3366){this.natClair = 'HONORAIRE DE DISPENSATION MEDICAMENTS SPECIFIQUES'}
        if( a==3374){this.natClair = 'KIT ANTI-GRIPPE'}
        if( a==3375){this.natClair = 'REMUNERATION PHARMACIENS POUR VACCINS H1N1'}
        if( a==3379){this.natClair = 'Honoraire de dispensation spécifique vaccins anti grippaux Hémisphère Sud'}
        if( a==3380){this.natClair = 'HONO DISP COMP  '}
        if( a==3381){this.natClair = 'PREPARATION PHARMACEUTIQUE INDIVIDUALISEE (ALLERGENES)'}
        if( a==3382){this.natClair = 'PRISE EN CHARGE DEROGATOIRE PHARMACIE'}
        if( a==3383){this.natClair = 'HONO DISP 1 '}
        if( a==3384){this.natClair = 'HONO DISP 2 '}
        if( a==3385){this.natClair = 'HONO DISP 4 '}
        if( a==3386){this.natClair = 'HONO DISP 7 '}
        if( a==3387){this.natClair = 'HONO DISP GC 1 '}
        if( a==3388){this.natClair = 'HONO DISP GC 2 '}
        if( a==3389){this.natClair = 'HONO DISP GC 4 '}
        if( a==3390){this.natClair = 'HONO DISP GC 7 '}
        if( a==3391){this.natClair = 'REMU  OBJECTIF - PHARMACIEN'}
        if( a==3392){this.natClair = 'REMU OBJECTIF - PHARMACIEN COMPLEMENT'}
        if( a==3393){this.natClair = 'ROSP AVK'}
        if( a==3394){this.natClair = 'ROSP AVK COMPLEMENT'}
        if( a==3395){this.natClair = 'Plan personnalisé de santé pharmacie'}
        if( a==3396){this.natClair = 'ROSP ASTHME'}
        if( a==3397){this.natClair = 'ROSP ASTHME COMPLEMENT'}
        if( a==3398){this.natClair = 'ROSP TRANSMISSION RPPS'}
        if( a==3399){this.natClair = 'REMUNERATION PHARMACIENS POUR VACCINS H1N1 - REGULARISATION COMPTABLE ET SAISIE MANUELLE'}
        if( a==3411){this.natClair = 'SANG){this.natClair =PLASMA ET LEURS DERIVES'}
        if( a==3412){this.natClair = 'TRANSPORT DU PRODUIT'}
        if( a==3413){this.natClair = 'LAIT HUMAIN'}
        if( a==3414){this.natClair = 'AUTRES PRODUITS D  ORIGINE HUMAINE'}
        if( a==3511){this.natClair = 'APPAREILS D  ASSISTANCE RESPIRATOIRE){this.natClair =OXYGENOTHERAPIE A DOMICILE'}
        if( a==3512){this.natClair = 'AUTRES MATERIELS POUR TRAITEMENTS A DOMICILE (CHAP. 1)'}
        if( a==3513){this.natClair = 'MATERIELS ET APPAREILS DE CONTENTION ET DE MAINTIEN (CHAP. 2)'}
        if( a==3514){this.natClair = 'MATERIELS ET APPAREILS POUR TRAITEMENTS DIVERS (CHAP. 3)'}
        if( a==3515){this.natClair = 'ARTICLES DE PANSEMENTS (CHAP. 4)'}
        if( a==3516){this.natClair = 'NUTRIMENTS POUR INTOLERANTS AU GLUTEN (CHAP. 3)'}
        if( a==3517){this.natClair = 'ALIMENTS DESTINES A DES FINS MEDICALES'}
        if( a==3518){this.natClair = 'APPAREIL GENERATEUR D AEROSOL'}
        if( a==3521){this.natClair = 'ORTHESES (PETIT APPAREILLAGE) (CHAP. 1)'}
        if( a==3522){this.natClair = 'DIVERS ORTHESES'}
        if( a==3523){this.natClair = 'FORFAIT MONTURE MOINS DE 18 ANS CMU'}
        if( a==3524){this.natClair = 'FORFAIT OPTIQUE ENFANT -A- MULTIFOCAUX (CMU)'}
        if( a==3525){this.natClair = 'FORFAIT OPTIQUE ENFANT -B- MULTIFOCAUX (CMU)'}
        if( a==3526){this.natClair = 'FORFAIT OPTIQUE -N° 6 MULTIFOCAUX (CMU)'}
        if( a==3527){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 1 UNIFOCAUX (CMU)'}
        if( a==3528){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 2 UNIFOCAUX (CMU)'}
        if( a==3529){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 3 UNIFOCAUX (CMU)'}
        if( a==3530){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 4 UNIFOCAUX (CMU)'}
        if( a==3531){this.natClair = 'OPTIQUE MEDICALE PROPREMENT DIT'}
        if( a==3532){this.natClair = 'MONTURE/LUNETTE POUR ENFANT DE - DE 18 ANS CRPCEN (HORS CODAGE LPP)'}
        if( a==3533){this.natClair = 'VERRES / VERRES POUR ENFANT<18 ans -CRPCEN- (hors codage LPP)'}
        if( a==3534){this.natClair = 'REPARATION'}
        if( a==3535){this.natClair = 'LENTILLES'}
        if( a==3536){this.natClair = 'VERRES UNIFOCAUX OP1 (CMU)'}
        if( a==3537){this.natClair = 'VERRES UNIFOCAUX OP2 (CMU)'}
        if( a==3538){this.natClair = 'VERRES UNIFOCAUX OP3 (CMU)'}
        if( a==3539){this.natClair = 'VERRES UNIFOCAUX OP4 (CMU)'}
        if( a==3540){this.natClair = 'PROTHESE AUDITIVE RAC ZERO'}
        if( a==3541){this.natClair = 'APPAREILS ELECTRONIQUES DE SURDITE  (CHAP 3.)'}
        if( a==3542){this.natClair = 'PROTHESES EXTERNES NON ORTHOPEDIQUES (CHAP. 4)'}
        if( a==3543){this.natClair = 'PROTHESES OCULAIRES ET FACIALES (CHAP. 5)'}
        if( a==3544){this.natClair = 'CHAUSSURES ORTHOPEDIQUES (CHAP. 6)'}
        if( a==3545){this.natClair = 'ORTHOPROTHESES (CHAP 7.)'}
        if( a==3546){this.natClair = 'ACCESSOIRES DE PROTHESES ET D  ORTHOPEDIE (CENTRES D  APPAR.) (CHAP.8)'}
        if( a==3547){this.natClair = 'APPAREILS ELECTRONIQUES DE SURDITE (CONSOMMABLES Y.C. PILES)'}
        if( a==3548){this.natClair = 'ORTHOPROTHESES COUTEUSES'}
        if( a==3549){this.natClair = 'PROCESSEUR POUR IMPLANT OSTE-INTEGRE'}
        if( a==3550){this.natClair = 'PROTHESE AUDITIVE SUIVI'}
        if( a==3551){this.natClair = 'IMPLANT INTERNE (CHAP. 1){this.natClair = 2 ET 3)'}
        if( a==3552){this.natClair = 'IMPLANT MU PAR ELECTRICITE (CHAP. 4)'}
        if( a==3553){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 5 UNIFOCAUX (CMU)'}
        if( a==3554){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 6 UNIFOCAUX (CMU)'}
        if( a==3555){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 7 UNIFOCAUX (CMU)'}
        if( a==3556){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 8 UNIFOCAUX (CMU)'}
        if( a==3557){this.natClair = 'FORFAIT OPTIQUE -ENFANT-N° 9 UNIFOCAUX (CMU)'}
        if( a==3558){this.natClair = 'PROTHESE AUDITIVE DEPASSEMENT RAC ZERO'}
        if( a==3561){this.natClair = 'VEHICULES POUR HANDICAPES PHYSIQUES'}
        if( a==3571){this.natClair = 'FRAIS DE GESTION APPAREILLAGE'}
        if( a==3572){this.natClair = 'ECART TIPS INDEMNISABLE'}
        if( a==3573){this.natClair = 'FOURNITURE ET EQUIPEMENT DEROGATOIRES'}
        if( a==3574){this.natClair = 'DISPOSITIF MEDICAL (PRISE EN CHARGE EXCEPTIONNELLE)'}
        if( a==3575){this.natClair = 'COMPLEMENT AT 150% LPP'}
        if( a==3581){this.natClair = 'VERRES UNIFOCAUX OP5(CMU)'}
        if( a==3582){this.natClair = 'VERRES UNIFOCAUX OP6(CMU)'}
        if( a==3583){this.natClair = 'MONTURE (CMU)'}
        if( a==3591){this.natClair = 'PRISE EN CHARGE DEROGATOIRE LPP'}
        if( a==3592){this.natClair = 'PEC EXCEPTIONNELLE DÉPASSEMENT LPP'}
        if( a==3593){this.natClair = 'TELESURVEILLANCE : FOURNISSEUR DE LA SOLUTION'}
        if( a==3594){this.natClair = 'PEC EXCEPTIONNELLE DEPASSEMENT LPP TP'}
        if( a==3610){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR PRESTATION PHARMACIE NON REMBOURSABLE (CNMSS)'}
        if( a==3611){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR PRESTATION SANITAIRE NON REMBOURSABLE (CNMSS)'}
        if( a==3612){this.natClair = 'SUPPLEMENT DEROGATOIRE SG SUR PRESTATION SANITAIRE REMBOURSABLE (CNMSS)'}
        if( a==4111){this.natClair = 'FORFAIT DE SURVEILLANCE MEDICALE  1ER HANDICAP'}
        if( a==4112){this.natClair = 'FORFAIT DE SURVEILLANCE MEDICALE REDUIT  2EME HANDICAP'}
        if( a==4113){this.natClair = 'PRATIQUES MEDICALES COMPLEMENTAIRES COTEES EN K'}
        if( a==4114){this.natClair = 'COMPLEMENT SURVEILLANCE THERMALE'}
        if( a==4131){this.natClair = 'FRAIS DE TRANSPORT - CURES THERMALES'}
        if( a==4132){this.natClair = 'FRAIS D  HOTEL - CURES THERMALES'}
        if( a==4141){this.natClair = 'FORFAIT THERMAL 1'}
        if( a==4142){this.natClair = 'FORFAIT THERMAL 2 AVEC KINESITEHRAPIE'}
        if( a==4143){this.natClair = 'FORFAIT THERMAL 2EME ORIENTATION'}
        if( a==4144){this.natClair = 'FORFAIT THERMAL 3 AVEC 9 SEANCES KINESITHERAPIE'}
        if( a==4145){this.natClair = 'FORFAIT THERMAL 72 SEANCES AVEC KINE'}
        if( a==4151){this.natClair = 'FORFAIT THERMAL 18 SEANCES COLLECTIVES'}
        if( a==4152){this.natClair = 'FORFAIT THERMAL 18 SEANCES INDIVIDUELLES'}
        if( a==4153){this.natClair = 'FORFAIT THERMAL 9 SEANCES COLLECTIVES'}
        if( a==4154){this.natClair = 'FORFAIT THERMAL 9 SEANCES INDIVIDUELLES'}
        if( a==4206){this.natClair = 'PRESTATION FIN DE GARDE AMBULANCE'}
        if( a==4207){this.natClair = 'FORFAIT TRANSPORT D URGENCE EXPERIMENTATION CPAM AUDE'}
        if( a==4208){this.natClair = 'FORFAIT D URGENCE SUR APPEL DU SAMU EXPERIMENTATION CPAM BOUCHES-DU-RHONE'}
        if( a==4209){this.natClair = 'COMPLEMENT TRANSPORTS D URGENCE'}
        if( a==4210){this.natClair = 'Taxi tarif A'}
        if( a==4211){this.natClair = 'SERVICES MOBILES D  URGENCE ET DE REANIMATION (SMUR)'}
        if( a==4212){this.natClair = 'AMBULANCES AGREEES'}
        if( a==4213){this.natClair = 'VEHICULES SANITAIRES LEGERS (VSL)'}
        if( a==4214){this.natClair = 'TAXIS'}
        if( a==4215){this.natClair = 'VEHICULES PERSONNELS'}
        if( a==4216){this.natClair = 'TRANSPORT REEDUCATION PROFESSIONNEL'}
        if( a==4217){this.natClair = 'Taxi tarif B'}
        if( a==4218){this.natClair = 'Taxi tarif C'}
        if( a==4219){this.natClair = 'AUTRES MODES DE TRANSPORT'}
        if( a==4220){this.natClair = 'Taxi tarif D'}
        if( a==4221){this.natClair = 'AMBULANCE AGREEE DE GARDE'}
        if( a==4222){this.natClair = 'INDEMNITE DE GARDE AMBULANCIERE'}
        if( a==4223){this.natClair = 'PART ASSOCIATION TRANSPORTEUR'}
        if( a==4224){this.natClair = 'PRATIQUE DE GEO LOCALISATION PAR DISPOSITIF EMBARQUE'}
        if( a==4225){this.natClair = 'FORFAIT TRANSPORT PARTAGE PAR 2 PERSONNES'}
        if( a==4227){this.natClair = 'CONTRAT D AMELIORATION DE LA QUALITE ET DE LA COORDINATION DES SOINS'}
        if( a==4228){this.natClair = 'CONTRAT D AMELIORATION DE LA QUALITE ET DE LA COORDINATION DES SOINS COMPLEMENT'}
        if( a==4229){this.natClair = 'Taxi tarif F'}
        if( a==4311){this.natClair = 'FRAIS DE DEPLACEMENT - ENQUETE LEGALE AT'}
        if( a==4312){this.natClair = 'FRAIS DE DEPLACEMENT - COLLEGE 3 MEDECINS'}
        if( a==4313){this.natClair = 'HONORAIRES'}
        if( a==4315){this.natClair = 'AUTOPSIE'}
        if( a==4316){this.natClair = 'EXPERTISE'}
        if( a==4317){this.natClair = 'HONORAIRE COMITE  REGIONAL  RECONNAISSANCE Maladie  Professionnelle'}
        if( a==4318){this.natClair = 'DEPLACEMENT COMITE REGIONAL RECONNAISSANCE MP'}
        if( a==4319){this.natClair = 'DEPLACEMENT PERSONNE ENTENDUE (CRRMP)'}
        if( a==4320){this.natClair = 'AVIS SAPITEUR'}
        if( a==4321){this.natClair = 'FRAIS FUNERAIRES'}
        if( a==4322){this.natClair = 'TRANSPORT DU CORPS'}
        if( a==4323){this.natClair = 'INDEMNITE ALLOUEE EN REPARATION DES PREJUDICES EXTRA-PATRIMOMIAUX'}
        if( a==4324){this.natClair = 'INDEMNITE DE CHANGEMENT D  EMPLOI'}
        if( a==4325){this.natClair = 'INDEMNITE COMPLEMENTAIRE POUR REEDUCATION PROFESSIONNELLE'}
        if( a==4326){this.natClair = 'PRETIUM PULCHRITUDINIS'}
        if( a==4327){this.natClair = 'PRETIUM SEXUALE'}
        if( a==4328){this.natClair = 'PREJUDICE D AGREMENT'}
        if( a==4329){this.natClair = 'PREJUDICE PERTE OU DIMINUTION PROMOTION PROFESSIONNELLE'}
        if( a==4330){this.natClair = 'PREJUDICES EXTRA PATRIMONIAUX - HORS IV'}
        if( a==4331){this.natClair = 'REMBOURSEMENTS DE SOINS A L  ETRANGER (ET1 A ET6 ET ET8 A ET9){this.natClair = ETB ETA){this.natClair = ETH){this.natClair = ETT){this.natClair = ETP){this.natClair = ETX )'}
        if( a==4332){this.natClair = 'PREJUDICE AMIANTE'}
        if( a==4339){this.natClair = 'REMBOURSEMENT DE SOINS'}
        if( a==4341){this.natClair = 'FRAIS DE TUTELLE'}
        if( a==4342){this.natClair = 'COTISATIONS A.T. EN CAS DE READAPTATION FONCTIONNELLE'}
        if( a==4343){this.natClair = 'COTISATIONS A.T. EN CAS DE REEDUCATION PROFESSIONNELLE'}
        if( a==4351){this.natClair = 'PRIME DE FIN DE REEDUCATION'}
        if( a==4352){this.natClair = 'AUTRES PRESTATIONS DIVERSES'}
        if( a==4353){this.natClair = 'INDEMNITE POUR PERTE DE SALAIRE (MALADIE){this.natClair = AT)'}
        if( a==4359){this.natClair = 'FORFAIT UTILISATION DES TELESERVICES'}
        if( a==4360){this.natClair = 'FORFAIT PARTICIPATION A LA TELETRANSMISSION'}
        if( a==4361){this.natClair = 'FACTURATION FEUILLE DE SOINS (POUR INFORMATION)'}
        if( a==4363){this.natClair = 'AIDE A LA FACTURATION FEUILLE DES FLUX NON SECURISES'}
        if( a==4364){this.natClair = 'AIDE MAINTENANCE TELETRANSMISSION'}
        if( a==4365){this.natClair = 'AIDE PORTABLE TELETRANSMISSION'}
        if( a==4366){this.natClair = 'AIDE DEMARRAGE TELETRANSMISSION'}
        if( a==4368){this.natClair = 'FORFAIT STRUCTURE CENTRE DE SANTE'}
        if( a==4369){this.natClair = 'FORFAIT PROFESSIONNEL DE SANTE CENTRE DE SANTE'}
        if( a==4370){this.natClair = 'FORFAIT D INCITATION FORFAITAIRE A LA NUMERISATION ET A LA TRANSMISSION'}
        if( a==4371){this.natClair = 'FORFAIT DE SOINS MEDICALISES (REGIME DES MINISTRES DES CULTES ET DES MEMBRES CONGR. ET COLL.RELIGIEUSES)'}
        if( a==4372){this.natClair = 'FORFAIT REPOS CONVALESCENCE (REGIME DES MINISTRES DES CULTES ET DES MEMBRES CONGR. ET COLL.RELIGIEUSES)'}
        if( a==4375){this.natClair = 'AIDE OUTIL DE MISE A JOUR'}
        if( a==4376){this.natClair = 'LIGNE TELEPHONIQUE DEDIEE'}
        if( a==4377){this.natClair = 'PIED SUPPORT MATERIEL'}
        if( a==4378){this.natClair = 'SUPPLEMENT OFFICINE DOM'}
        if( a==4379){this.natClair = 'AVANCE RÉMUNÉRATION SPÉCIFIQUE CENTRES DE SANTÉ '}
        if( a==4380){this.natClair = 'SOLDE RÉMUNÉRATION SPÉCIFIQUE CENTRES DE SANTÉ '}
        if( a==4381){this.natClair = 'ACTES NON NOMENCLATURE'}
        if( a==4382){this.natClair = 'PHARMACIE NON REMBOURSABLE'}
        if( a==4391){this.natClair = 'RESPONSABILITE CIVILE PROFESSIONNELLE'}
        if( a==4392){this.natClair = 'RESPONSABILITE CIVILE ECHOGRAPHIE OBSTETRICALE'}
        if( a==4393){this.natClair = 'RESPONSABILITE CIVILE CHIRURGIE 1'}
        if( a==4394){this.natClair = 'RESPONSABILITE CIVILE CHIRURGIE 2'}
        if( a==4395){this.natClair = 'RESPONSABILITE CIVILE ANESTHESIE REANIMATION'}
        if( a==4396){this.natClair = 'PRIME RESPONSABILITE SPECIALISTE'}
        if( a==4397){this.natClair = 'PRIME ACCREDITATION SPECIALISTE'}
        if( a==4411){this.natClair = 'AIDE SOCIALE'}
        if( a==4412){this.natClair = 'DISPENSAIRES ANTITUBERCULEUX'}
        if( a==4413){this.natClair = 'DISPENSAIRES ANTIVENERIENS'}
        if( a==4414){this.natClair = 'HYGIENE MENTALE'}
        if( a==4415){this.natClair = 'ETABLISSEMENTS DE LUTTE CONTRE LA TUBERCULOSE'}
        if( a==4416){this.natClair = 'PROTECTION MATERNELLE ET INFANTILE'}
        if( a==4417){this.natClair = 'AUTRES PARTICIPATIONS FORFAITAIRES NON INDIVIDUALISEES'}
        if( a==4419){this.natClair = 'AUTRES DEPENSES NON INDIVIDUALISEES'}
        if( a==4501){this.natClair = 'CONTROLES MEDICAUX (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==4511){this.natClair = 'CAPITAL DECES'}
        if( a==4611){this.natClair = 'FORFAIT DIVERS PAYES A LA STRUCTURE DE SOINS (FILIERES ET RESEAUX)'}
        if( a==4612){this.natClair = 'FORFAIT D EDUCATION THERAPEUTIQUE ET D INTERESSEMENT (FILIERES ET RESEAUX)'}
        if( a==5101){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP1'}
        if( a==5102){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP2'}
        if( a==5103){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP3'}
        if( a==5104){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP4'}
        if( a==5105){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP5'}
        if( a==5106){this.natClair = 'FORFAIT VERRES UNIFOCAUX OP6'}
        if( a==5107){this.natClair = 'FORFAIT MONTURE CMU'}
        if( a==5108){this.natClair = 'TM DU FORFAIT MONTURE MOINS DE 18 ANS CMU'}
        if( a==5109){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 1 UNIFOCAUX (CMU)'}
        if( a==5110){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 2 UNIFOCAUX (CMU)'}
        if( a==5111){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 3 UNIFOCAUX (CMU)'}
        if( a==5112){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 4 UNIFOCAUX (CMU)'}
        if( a==5113){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 5 UNIFOCAUX (CMU)'}
        if( a==5114){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 6 UNIFOCAUX (CMU)'}
        if( a==5115){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 7 UNIFOCAUX (CMU)'}
        if( a==5116){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 8 UNIFOCAUX (CMU)'}
        if( a==5117){this.natClair = 'TM DU FORFAIT OPTIQUE -ENFANT-N° 9 UNIFOCAUX (CMU)'}
        if( a==5118){this.natClair = 'TM DU FORFAIT OPTIQUE ENFANT -A- MULTIFOCAUX (CMU)'}
        if( a==5119){this.natClair = 'TM DU FORFAIT OPTIQUE ENFANT -B- MULTIFOCAUX (CMU)'}
        if( a==5120){this.natClair = 'TM DU FORFAIT OPTIQUE -N° 6 MULTIFOCAUX (CMU)'}
        if( a==5201){this.natClair = 'FORFAIT PROTHESE DENTAIRE ADJOINTE'}
        if( a==5202){this.natClair = 'FORFAIT REPARATION PROTHESE ADJOINTE'}
        if( a==5203){this.natClair = 'FORFAIT PROTHESE DENTAIRE CONJOINTE'}
        if( a==5204){this.natClair = 'FORFAIT ORTHODONTIE'}
        if( a==5205){this.natClair = 'FORFAIT PROTHESE CONJOINTE (CMU HORS PANIER DE SOINS)'}
        if( a==5206){this.natClair = 'FORFAIT ORTHODONTIQUE (CMU HORS PANIER DE SOINS)'}
        if( a==5401){this.natClair = 'FORFAIT AUDIO-PROTHESE'}
        if( a==6011){this.natClair = 'CARENCE -'}
        if( a==6012){this.natClair = 'CARENCE +'}
        if( a==6013){this.natClair = 'IJ CARENCE (CRPCEN)'}
        if( a==6014){this.natClair = 'COMPLEMENT IJ >PLAFOND   (CRPCEN)'}
        if( a==6110){this.natClair = 'IJ NORMALES + 6MOIS'}
        if( a==6111){this.natClair = 'IJ NORMALES -3 MOIS'}
        if( a==6112){this.natClair = 'IJ NORMALES +3MOIS'}
        if( a==6113){this.natClair = 'IJ REDUITES -3MOIS'}
        if( a==6114){this.natClair = 'IJ REDUITES +3MOIS'}
        if( a==6115){this.natClair = 'IJ MAJOREES -3MOIS'}
        if( a==6116){this.natClair = 'IJ MAJOREES +3MOIS'}
        if( a==6117){this.natClair = 'IJ PARTIELLE){this.natClair =  PERTE DE SALAIRE -3MOIS'}
        if( a==6118){this.natClair = 'IJ PARTIELLE){this.natClair =  PERTE DE SALAIRE +3MOIS'}
        if( a==6119){this.natClair = 'IJ MAJOREES + 6 MOIS'}
        if( a==6120){this.natClair = 'INDEMNITE TEMPORAIRE D INAPTITUDE AT/MP'}
        if( a==6121){this.natClair = 'IJ PRENATALES'}
        if( a==6122){this.natClair = 'IJ POSTNATALES'}
        if( a==6123){this.natClair = 'IJ EN CAS D  ADOPTION'}
        if( a==6124){this.natClair = 'IJ CONGE SUPPLEMENTAIRE PREMA'}
        if( a==6126){this.natClair = 'FORFAIT GROSSESSE TAUX PLEIN TI'}
        if( a==6127){this.natClair = 'FORFAIT GROSSESSE TAUX REDUIT TI'}
        if( a==6131){this.natClair = 'IJ NORMALES POUR CURE THERMALE'}
        if( a==6132){this.natClair = 'IJ MAJOREES POUR CURE THERMALE'}
        if( a==6133){this.natClair = 'IJ REDUITES POUR CURE THERMALE'}
        if( a==6134){this.natClair = 'IJ MALADIE  PAMC MOINS DE 3 MOIS'}
        if( a==6135){this.natClair = 'IJ MALADIE  PAMC PLUS DE 3 MOIS'}
        if( a==6210){this.natClair = 'IJ PATERNITE HOSPITALISATION ENFANT'}
        if( a==6212){this.natClair = 'IJ CONGE MATERNITE AU PERE'}
        if( a==6213){this.natClair = 'INDEMNITE DE REMPLACEMENT PATERNITE'}
        if( a==6214){this.natClair = 'IJ CONGE SUPPLEMENTAIRE MATERNITE PAMC'}
        if( a==6215){this.natClair = 'IJ CONGE POSTNATAL PAMC'}
        if( a==6221){this.natClair = 'ALLOCATION REPOS MATERNEL NORMAL'}
        if( a==6222){this.natClair = 'ALLOCATION REPOS MATERNEL ADOPTION'}
        if( a==6231){this.natClair = 'IJ CONGE PRENATAL PAMC'}
        if( a==6232){this.natClair = 'IJ CONGE ADOPTION PAMC'}
        if( a==6233){this.natClair = 'IJ CONGE PATHOLOGIQUE PAMC'}
        if( a==6234){this.natClair = 'INDEMNITE MATERNITE EN CAS DE NAISSANCES MULTIPLES'}
        if( a==6235){this.natClair = 'INDEMNITE DE REMPLACEMENT CONJOINTE COLLABORATRICE'}
        if( a==6236){this.natClair = 'IJ PATERNITE PAMC'}
        if( a==6237){this.natClair = 'INDEMNITE PATERNITE CONJOINT PAMC'}
        if( a==6238){this.natClair = 'INDEMNITES PATERNITE CONJOINT INFIRMIER'}
        if( a==6239){this.natClair = 'INDEMNITÉ MALADIE DOUBLE ACTIVITÉ  PAMC'}
        if( a==6241){this.natClair = 'ALLOCATION ACCOMPAGNEMENT FIN DE VIE CESSATION ACTIVITE TEMPS PLEIN'}
        if( a==6242){this.natClair = 'ALLOCATION ACCOMPAGNEMENT FIN DE VIE CESSATION ACTIVITE REDUITE'}
        if( a==6251){this.natClair = 'ALLOCATION NUIT NORMALE - 3 MOIS'}
        if( a==6252){this.natClair = 'ALLOCATION NUIT NORMALE + 3 MOIS'}
        if( a==6253){this.natClair = 'ALLOCATION NUIT MAJOREE  3 ENFANTS - 3 MOIS'}
        if( a==6257){this.natClair = 'ALLOCATION EXPOSITION NORMALE - 3 MOIS'}
        if( a==6258){this.natClair = 'ALLOCATION EXPOSITION NORMALE + 3 MOIS'}
        if( a==6261){this.natClair = 'ALLOCATION EXPOSITION MAJOREE 3 ENFANTS - 3 MOIS'}
        if( a==6262){this.natClair = 'ALLOCATION EXPOSITION MAJOREE 3 ENFANTS + 3 MOIS'}
        if( a==6311){this.natClair = 'RDS IJ MATERNITE'}
        if( a==7111){this.natClair = 'PENSION INVALIDITE AVANTAGES DE BASE'}
        if( a==7112){this.natClair = 'PENSION INVALIDITE ALLOCATIONS SUPPLEMENTAIRES'}
        if( a==7113){this.natClair = 'PENSION INVALIDITE MAJORATIONS POUR ASSISTANCE D  UNE TIERCE PERSONNE'}
        if( a==7119){this.natClair = 'PENSIONS D  INVALIDITE SERVIES PAR LE REGIME SPECIAL DE SECURITE SOCIALE DANS LES MINES'}
        if( a==8111){this.natClair = 'RENTES DE VICTIME'}
        if( a==8112){this.natClair = 'MAJORATIONS POUR ASSISTANCE D  UNE TIERCE PERSONNE'}
        if( a==8113){this.natClair = 'RENTES DE CONJOINT SURVIVANT'}
        if( a==8114){this.natClair = 'RENTES DE REVERSION'}
        if( a==8115){this.natClair = 'RENTES D  ORPHELIN'}
        if( a==8116){this.natClair = 'RENTES D  ASCENDANT'}
        if( a==8117){this.natClair = 'MAJORATION FAUTE INEXCUSABLE RENTE ASCENDANT'}
        if( a==8118){this.natClair = 'MAJORATION FAUTE INEXCUSABLE RENTE VICTIME'}
        if( a==8119){this.natClair = 'MAJORATION FAUTE INEXCUSABLE RENTE CONJOINT'}
        if( a==8120){this.natClair = 'MAJORATION FAUTE INEXCUSABLE RENTE ORPHELIN'}
        if( a==8121){this.natClair = 'PRESTATION COMPLEMENTAIRE POUR RECOURS A TIERCE PERSONNE'}
        if( a==8222){this.natClair = 'RACHAT OBLIGATOIRE'}
        if( a==8223){this.natClair = 'RACHAT FACULTATIF TOTAL'}
        if( a==8224){this.natClair = 'RACHAT FACULTATIF PARTIEL'}
        if( a==8225){this.natClair = 'TRANSFERT DE CAPITAUX'}
        if( a==8226){this.natClair = 'INDEMNITE EN CAPITAL ACCIDENT DU TRAVAIL'}
        if( a==8227){this.natClair = 'MAJORATION FAUTE INEXCUSABLE INDEMNITE EN CAPITAL'}
        if( a==9111){this.natClair = 'COMPLEMENT TICKET MODERATEUR'}
        if( a==9112){this.natClair = 'COMPLEMENT FRAIS DE TRANSPORT ET DE SEJOUR'}
        if( a==9113){this.natClair = 'FRAIS OCCASIONNE PAR LE DON D ORGANES'}
        if( a==9114){this.natClair = 'COMPLEMENT AUX FRAIS D HOSPITALISATION DE LA MERE QUI ALLAITE SON ENFANT'}
        if( a==9115){this.natClair = 'PERTE DE SALAIRE POUR ENFANT MALADE'}
        if( a==9116){this.natClair = 'INDEMNITES JOURNALIERES MATERNITE POUR CERTAINES CATEGORIES D ASSURES'}
        if( a==9118){this.natClair = 'FRAIS FUNERAIRES'}
        if( a==9119){this.natClair = 'COMPLEMENT POUR CURE THERMALE'}
        if( a==9121){this.natClair = 'COMPLEMENT TICKET MODERATEUR POUR ENFANT DE MOINS D UN AN'}
        if( a==9122){this.natClair = 'ALLOCATION DECES'}
        if( a==9123){this.natClair = 'COMPLEMENT MALADIES CHRONIQUES ET MAINTIEN A DOMICILE'}
        if( a==9129){this.natClair = 'INDEMNITES COMPLEMENTAIRES EN REEDUCATION PROFESSIONNELLE'}
        if( a==9131){this.natClair = 'INDEMNITE DE PERTE DE SALAIRE Y COMPRIS  DIALYSE A DOMICILE'}
        if( a==9132){this.natClair = 'FRAIS DE DEPLACEMENT EN CURE THERMALE'}
        if( a==9133){this.natClair = 'FRAIS D  HEBERGEMENT EN CURE THERMALE'}
        if( a==9134){this.natClair = 'PRIME DE FIN DE REEDUCATION PROFESSIONNELLE'}
        if( a==9135){this.natClair = 'AIDE FINANCIERE EXCEPTIONNELLE (SECOURS)'}
        if( a==9141){this.natClair = 'MAJORATION LIEE A UNE VISITE D  URGENCE'}
        if( a==9143){this.natClair = 'SUPPLEMENT POUR SOINS AUX POLYTRAUMATISES'}
        if( a==9144){this.natClair = 'HONORAIRES REMUNERANT LA PERMANENCE TELEPHONIQUE SUR LA BASE DE 3 C DE L HEURE (ASTREINTE)'}
        if( a==9151){this.natClair = 'PLAN SEGUIN'}
        if( a==9152){this.natClair = 'PLAN EVIN'}
        if( a==9161){this.natClair = 'PRESTATIONS SUPPLEMENTAIRES ALSACE-MOSELLE'}
        if( a==9162){this.natClair = 'SURVEILLANCE MEDICALE MATERNELLE EN ACTION SANITAIRE ET SOCIALE'}
        if( a==9163){this.natClair = 'CENTRE EXAMEN SANTE  SAISIE MANUELLE'}
        if( a==9164){this.natClair = 'PRESTATIONS D ASS SNCF ET REGIME GENERAL'}
        if( a==9167){this.natClair = 'PRESTATIONS D ASS SNCF ET REGIME GENERAL'}
        if( a==9170){this.natClair = 'PRESTATIONS D ASS SNCF ET REGIME GENERAL'}
        if( a==9191){this.natClair = 'TICKET MODERATEUR - PREVENTION BUCCO-DENTAIRE'}
        if( a==9201){this.natClair = 'ENTRETIEN EVALUATION PSYCHOLOGUE'}
        if( a==9202){this.natClair = 'ACCOMPAGNEMENT PSYCHOLOGIQUE DE SOUTIEN'}
        if( a==9203){this.natClair = 'PSYCHOTHERAPIE STRUCTUREE'}
        if( a==9211){this.natClair = 'VACCIN (MILITAIRES) / VACCIN GRIPPE (CRPCEN)'}
        if( a==9221){this.natClair = 'TEST DE DEPISTAGE RAPIDE (FOURNISSEUR)'}
        if( a==9311){this.natClair = 'DEPISTAGE DU CANCER COLO-RECTAL'}
        if( a==9312){this.natClair = 'DEPISTAGE DU CANCER DU SEIN (PREVENTION MALADIE)'}
        if( a==9313){this.natClair = 'FRAIS DE LECTURE POUR MAMMOGRAPHIE'}
        if( a==9318){this.natClair = 'ANALYSES DEPISTAGE CANCER UTERUS (PREVENTION MALADIE)'}
        if( a==9411){this.natClair = 'CONSULTATION HYGIENE BUCCO-DENTAIRE'}
        if( a==9412){this.natClair = 'HYGIENE BUCCO-DENTAIRE N91 (SCELLEMENT D  UNE MOLAIRE)'}
        if( a==9413){this.natClair = 'HYGIENE BUCCO-DENTAIRE N92 (SCELLEMENT DE DEUX MOLAIRES)'}
        if( a==9421){this.natClair = 'PREVENTION BUCCO-DENTAIRE: CONSULTATION'}
        if( a==9422){this.natClair = 'PREVENTION BUCCO-DENTAIRE: RADIO DEUX CLICHES'}
        if( a==9423){this.natClair = 'PREVENTION BUCCO-DENTAIRE: RADIO QUATRE CLICHES'}
        if( a==9424){this.natClair = 'PREVENTION BUCCO-DENTAIRE: RADIO EN IMAGERIE NUMERISEE'}
        if( a==9429){this.natClair = 'CAMPAGNE BUCCO DENTAIRE MOCALES'}
        if( a==9430){this.natClair = 'TM DE L ACTE DE VACCINATION GRIPPE A/H1N1'}
        if( a==9431){this.natClair = 'PREVENTION ENTRETIEN DE SANTE'}
        if( a==9432){this.natClair = 'TM DES INDEMNITES DE DEPLACEMENTS ID et MD'}
        if( a==9433){this.natClair = 'TM DE LA RETINOPATHIE DIABETIQUE'}
        if( a==9434){this.natClair = 'ACTE DE DEPISTAGE DU CANCER COLORECTAL'}
        if( a==9511){this.natClair = 'EXAMEN ET BILAN DE SANTE'}
        if( a==9512){this.natClair = 'AUTRES ACTIONS COLLECTIVES DE PREVENTION'}
        if( a==9521){this.natClair = 'ACTES DE PREVENTION'}
        if( a==9566){this.natClair = 'TRAITEMENT NICOTINIQUE DE SUBSTITUTION'}
        if( a==9567){this.natClair = 'REMUNERATION ADHESION SOPHIA (PREVENTION)'}
        if( a==9568){this.natClair = 'REMUNERATION RENOUVELLEMENT SOPHIA (PREVENTION)'}
        if( a==9569){this.natClair = 'RETOUR DOM. INSUFFISANT CARDIAQUE'}
        if( a==9570){this.natClair = 'BRONCHO-PNEUMOPATHIE CHRONIQUE OBSTRUCTIVE'}
        if( a==9601){this.natClair = 'MUTUELLE CHAMBRE PARTICULIERE (CAVIMAC)'}
        if( a==9701){this.natClair = 'COMPLEMENT D ACTION SOCIALE APPAREIL DE SURDITE (CLERCS ET EMPLOYES DE NOTAIRES){this.natClair = PORT AUTONOME DE BORDEAUX)'}
        if( a==9703){this.natClair = 'COMPLEMENT D ACTION SOCIALE DENTAIRE (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9704){this.natClair = 'COMPLEMENT D ACTION SOCIALE PROTHESES DENTAIRES (CLERCS ET EMPLOYES DE NOTAIRES){this.natClair = PORT AUTONOME DE BORDEAUX)'}
        if( a==9705){this.natClair = 'COMPLEMENT D ACTION SOCIALE DENTAIRE ALSACE MOSELLE (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9706){this.natClair = 'COMPLEMENT D ACTION SOCIALE OPTIQUE (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9707){this.natClair = 'COMPLEMENT D ACTION SOCIALE OPTIQUE){this.natClair = ENFANT DE MOINS DE 16 ANS (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9708){this.natClair = 'COMPLEMENT D ACTION SOCIALE MONTURES (CLERCS ET EMPLOYES DE NOTAIRES){this.natClair = PORT AUTONOME DE BORDEAUX)'}
        if( a==9709){this.natClair = 'COMPLEMENT D ACTION SOCIALE VERRES (CLERCS ET  EMPLOYES DE NOTAIRES){this.natClair = PORT AUTONOME DE BORDEAUX)'}
        if( a==9710){this.natClair = 'COMPLEMENT D ACTION SOCIALE LENTILLES (CLERCS ET EMPLOYES DE NOTAIRES){this.natClair = PORT AUTONOME DE BORDEAUX)'}
        if( a==9711){this.natClair = 'PRIME DE LAYETTE (CLERCS ET  EMPLOYES DE NOTAIRES)'}
        if( a==9712){this.natClair = 'ALLOCATION VOYAGE DES ENFANTS A LA COLONIE DU PRARIAND (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9713){this.natClair = 'AIDE AUX SEJOURS DES ENFANTS (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9714){this.natClair = 'ALLOCATION VACANCES (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9715){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES OPTIQUE'}
        if( a==9716){this.natClair = 'ACTION SOCIALE DENTAIRE'}
        if( a==9717){this.natClair = 'ACTION SOCIALE AUDITIF'}
        if( a==9719){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES HOSPITALISATION'}
        if( a==9721){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES DIFFICULTES FINANCIERES'}
        if( a==9722){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES AUTRES'}
        if( a==9723){this.natClair = 'VACANCES RETRAITES (CLERCS ET EMPLOYES DE NOTAIRES)'}
        if( a==9724){this.natClair = 'AIDE A LA SCOLARITE (CRPCEN)'}
        if( a==9725){this.natClair = 'ACCUEIL JEUNE ENFANT (CRPCEN)'}
        if( a==9726){this.natClair = 'PRESTATIONS SUPPLÉMENTAIRES OPTIQUES CRPCEN'}
        if( a==9727){this.natClair = 'PRESTATIONS SUPPLÉMENTAIRES ACOUSTIQUES CRPCEN'}
        if( a==9731){this.natClair = 'COMPLEMENT A L ACS'}
        if( a==9732){this.natClair = 'AIDE A L ACQUISITION D UNE COUVERTURE COMPLEMENTAIRE POUR LES VICTIMES DU SEUIL ACS'}
        if( a==9741){this.natClair = 'AIDES AU LOGEMENT'}
        if( a==9742){this.natClair = 'AIDE A LA COMMUNICATION HORS AUDITIF'}
        if( a==9743){this.natClair = 'AIDES A LA DEAMBULATION ET AU TRANSPORT'}
        if( a==9744){this.natClair = 'AUTRES TYPES D AIDES'}
        if( a==9751){this.natClair = 'FOURNITURES ET ACCESSOIRES NON REMBOURSABLES'}
        if( a==9752){this.natClair = 'GARDES MALADES A DOMICILE'}
        if( a==9761){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES ORTHODONTIE'}
        if( a==9762){this.natClair = 'AIDES FINANCIERES INDIVIDUELLES PHARMACIE/LPP'}
        if( a==9763){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL AFFECTEES AU LOGEMENT'}
        if( a==9764){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL AFFECTEES AUX BESOINS ALIMENTAIRES ET VESTIMENTAIRES'}
        if( a==9765){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL AFFECTEES AUX FRAIS DE SCOLARISATION'}
        if( a==9766){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL AFFECTEES AUX REGLEMENTS D IMPOTS TAXES ET PRIMES'}
        if( a==9767){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL D ATTENTE DE VERSEMENT DE REVENUS DE SUBSTITUTION'}
        if( a==9768){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL AFFECTEES AUX FRAIS D OBSEQUES'}
        if( a==9769){this.natClair = 'AIDES FINANCIERES A CARACTERE SOCIAL PALLIANT L ABSENCE DE REVENUS'}
        if( a==9771){this.natClair = 'AIDES PROTHESES AUDITIVES'}
        if( a==9772){this.natClair = 'AIDES MENAGERES'}
        if( a==9773){this.natClair = 'AIDES MENAGERES SORTIE D HOSPITALISATION COORDONNEE'}
        if( a==9774){this.natClair = 'ACTES FOURNITURES SORTIE D HOSPITALISATION COORDONNEE'}
        if( a==9775){this.natClair = 'AIDES MENAGERES PROGRAMME D ACCOMPAGNEMENT APRES INTERVENTION ORTHOPEDIQUE'}
        if( a==9776){this.natClair = 'ACTES FOURNITURES PROGRAMME D ACCOMPAGNEMENT APRES INTERVENTION ORTHOPEDIQUE'}
        if( a==9777){this.natClair = 'PHARMACIE NON REMBOURSABLE SOINS PALLIATIFS'}
        if( a==9778){this.natClair = 'BILANS DE COMPETENCES ET REORIENTATION PROFESSIONNELLE'}
        if( a==9802){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9803){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9806){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9808){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9809){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9810){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9812){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9813){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9814){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9815){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9816){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9817){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9820){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9822){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9823){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9825){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9830){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9831){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9832){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9833){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9841){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9842){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9843){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9844){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9845){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9847){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9849){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9851){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9852){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9853){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9854){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9855){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9856){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9857){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9858){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9859){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9860){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9861){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9862){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9863){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9864){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9865){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9866){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9867){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9871){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9872){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9873){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9875){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9880){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9890){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9891){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9894){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9895){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9896){this.natClair = 'CODES MIS A LA DISPOSITION DE LA SNCF'}
        if( a==9901){this.natClair = 'TRANSPORT POUR PERSONNE ACCOMPAGNANTE (MILITAIRES)'}
        if( a==9902){this.natClair = 'AIDE SOCIALE (MILITAIRES)'}
        if( a==9911){this.natClair = 'AIDE MENAGERE'}
        if( a==9912){this.natClair = 'AIDE MENAGERE FAMILIALE (MILITAIRES)'}
        if( a==9999){this.natClair = 'VALEUR INCONNUE'}
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (natNum != null ? natNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrsNatClair)) {
            return false;
        }
        PrsNatClair other = (PrsNatClair) object;
        if ((this.natNum == null && other.natNum != null) || (this.natNum != null && !this.natNum.equals(other.natNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrsNatClair[ natNum=" + natNum + " ]";
    }

}
