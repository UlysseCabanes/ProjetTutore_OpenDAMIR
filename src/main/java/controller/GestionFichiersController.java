/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Gzip.Gzip;
import Gzip.MoisPresentsDansBDD;
import dao.AgeBenSndsClairFacade;
import dao.BenResRegClairFacade;
import dao.BeneficiaireFacade;
import dao.DateTraitementFacade;
import dao.ExecutantFacade;
import dao.FichiersdamirFacade;
import dao.IndicateursFacade;
import dao.PrestationFacade;
import dao.PrsNatClairFacade;
import dao.PrsPpuSecClairFacade;
import dao.PseSpeSndsClairFacade;
import entity.Beneficiaire;
import entity.DateTraitement;
import entity.Executant;
import entity.Indicateurs;
import entity.Prestation;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import util.MoisNombre;

/**
 *
 * @author ulyss
 */
@Controller
@Path("gestion")
@View("gestionFichier.html")
public class GestionFichiersController {

    @Inject
    MoisPresentsDansBDD moisPresentsDansBDD;

    @Inject
    Models models;

    @Inject
    FichiersdamirFacade fichiersDamirFacade;

    @Inject
    AgeBenSndsClairFacade ageBenSndsClairFacade;

    @Inject
    BenResRegClairFacade benResRegClairFacade;

    @Inject
    PseSpeSndsClairFacade pseSpeSndsClairFacade;

    @Inject
    PrsNatClairFacade prsNatClairFacade;

    @Inject
    PrsPpuSecClairFacade prsPpuSecClairFacade;

    @Inject
    BeneficiaireFacade beneficiaireFacade;

    @Inject
    DateTraitementFacade dateTraitementFacade;

    @Inject
    ExecutantFacade executantFacade;

    @Inject
    IndicateursFacade indicateursFacade;

    @Inject
    PrestationFacade prestationFacade;

    @GET
    @Path("importation")
    public void importation(@QueryParam("periodeChoisie") String periodeChoisie,
            @QueryParam("moisChoisis") String moisChoisis,
            @QueryParam("anneesChoisies") String anneesChoisies) throws Exception {
        //Envoyer la période choisie à la vue
        models.put("periodeChoisie", periodeChoisie);
        //Convertir les String années et mois choisis en tableaux de String en utilisant la virgule comme séparateur 
        String[] annees = anneesChoisies.split("\\,");
        String[] mois = moisChoisis.split("\\,");

        ArrayList<String> clesFichiers = new ArrayList<>();
        //Parcourir chaque période
        for (int i = 0; i < annees.length; i++) {
            //Convertir le mois en toutes lettres en mois en nombre
            String nbMois = MoisNombre.monthToNumber(mois[i]);
            //Créer la clé correspondante et l'ajouter à la variable de session
            clesFichiers.add("DAMIR_" + annees[i] + nbMois + "_SMALL");
        }
        //Envoyer la liste des clés à la vue
        models.put("clesFichiers", clesFichiers);

        ArrayList<String> urlFichiers = new ArrayList<>();
        //Pour chaque clé de la variable de session
        /*
        for (String cle : clesFichiers) {
            //Récupérer l'url du fichier correspondant à la clé
            String url = fichiersDamirFacade.find(cle).getUrlfichier();
            urlFichiers.add(url);
        }
        
        //Parcourir chaque url
        for (String url : urlFichiers) {
            //Créer les entités correspondantes dans la BDD
            this.readGzipURL(url);
        } 
         */
        readGzipURL("file:\\C:\\Users\\ulyss\\Desktop\\A201812_small.csv.gz");
    }

    public void readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        System.out.println("controller.testDAOController.readGzipURL() demarre.............");
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            int o = prestationFacade.findAll().size();
            //Pour chaque ligne du fichier, 
            while ((line = reader.readLine()) != null) {
                //on ajoute chaque ligne sous forme de int[] à j
                if (reader.getLineNumber() > 1) {

                    int id = reader.getLineNumber() + o;
                    //on ajoute chaque ligne sous forme de int[] à j
                    String[] processLine = processLine(reader.getLineNumber(), line);

                    //Création de Benficiaire correspondante à la ligne
                    Beneficiaire beneficiaire = new Beneficiaire(id);
                    beneficiaire.setAgeBenSnds(ageBenSndsClairFacade.find(Integer.parseInt(processLine[2])));
                    beneficiaire.setBenResReg(benResRegClairFacade.find(Integer.parseInt(processLine[3])));
                    //Création de DateTraitement correspondante à la ligne
                    DateTraitement dateTraitement = new DateTraitement(id);
                    //Transfomrer la date de type int en type date
                    LocalDate localdate = LocalDate.parse(processLine[0] + "01", DateTimeFormatter.BASIC_ISO_DATE);
                    Date date = java.sql.Date.valueOf(localdate);
                    dateTraitement.setFlxAnnMoi(date);

                    //Création de Executant correspondante à la ligne
                    Executant executant = new Executant(id);
                    executant.setPseSpeSnds(pseSpeSndsClairFacade.find(Integer.parseInt(processLine[47])));
                    //Création de Indicateurs correspondante à la ligne
                    Indicateurs indicateurs = new Indicateurs(id);
                    indicateurs.setPrsPaiMnt(Double.parseDouble(processLine[20]));
                    indicateurs.setPrsRemMnt(Double.parseDouble(processLine[22]));
                    //Création de Prestation correspondante à la ligne
                    Prestation prestation = new Prestation(id);
//                    prestation.setBeneficiaire(beneficiaire);
//                    prestation.setDateTraitement(dateTraitement);
//                    prestation.setExecutant(executant);
//                    prestation.setIndicateurs(indicateurs);
                    prestation.setPrsNat(prsNatClairFacade.find(Integer.parseInt(processLine[39])));
                    prestation.setPrsPpuSec(prsPpuSecClairFacade.find(Integer.parseInt(processLine[40])));

                    //prestation relié a chaque objet
                    beneficiaire.setPrestation(prestation);
                    dateTraitement.setPrestation(prestation);
                    executant.setPrestation(prestation);
                    indicateurs.setPrestation(prestation);

                    //Création des entités dans bdd
                    prestationFacade.create(prestation);
                    beneficiaireFacade.create(beneficiaire);
                    dateTraitementFacade.create(dateTraitement);
                    executantFacade.create(executant);
                    indicateursFacade.create(indicateurs);

                    System.out.println("une ligne lue" + "\n");
                }
            }
        }
        //on remet à jour la variable de session
        moisPresentsDansBDD.setMoisPresent(dateTraitementFacade.findAll());
    }

    protected String[] processLine(int lineNumber, String line) {
        //définit le séparateur des éléments de la ligne
        String SEPARATEUR = ";";
        //découpe chaque élément de la ligne en données seul dans un tableau de String
        String[] mots = line.split(SEPARATEUR);
        //Créer la variable à retourner @chaine correspondants aux éléments de la ligne souhaités du tableau @mots, aux index correpondants a chaque éléments du tableau @colonnes
        String[] chaine = new String[55];

        for (int i = 0; i < 55; i++) {
            if (mots[i].isEmpty() == true) {
                chaine[i] = "";
            } else {
                //@chaine se concstitue de int résultants de la conversion des éléments String du tableau mots[]
                chaine[i] = mots[i];
            }

        }
        //System.out.printf("Ligne n° %d : %n %s %n", lineNumber, chaine);
        return chaine;

    }

    @GET
    @Path("suppression")
    public void suppression(@QueryParam("periodeChoisie") String periodeChoisie,
            @QueryParam("moisChoisis") String moisChoisis,
            @QueryParam("anneesChoisies") String anneesChoisies) {
        //on recupere le nombre du mois
        String nbMois = MoisNombre.monthToNumber(moisChoisis);
        //on crée la date sous forme de string (ex:20181101)
        String futurDate = anneesChoisies + nbMois + "01";
        //on convertit ce String en Date 
        LocalDate localdate = LocalDate.parse(futurDate, DateTimeFormatter.BASIC_ISO_DATE);
        Date dateASupprimer = java.sql.Date.valueOf(localdate);

        //On récupère les id des DateTraitment correspondant à la date rentrée en paramètre
        //Pour chaque id on supprime les entités correspondantes
        for (DateTraitement t : dateTraitementFacade.findAll()) {
            if (t.getFlxAnnMoi().equals(dateASupprimer)) {

               
                beneficiaireFacade.remove(beneficiaireFacade.find(t.getIddate()));
                dateTraitementFacade.remove(dateTraitementFacade.find(t.getIddate()));
                executantFacade.remove(executantFacade.find(t.getIddate()));
                indicateursFacade.remove(indicateursFacade.find(t.getIddate()));
                prestationFacade.remove(prestationFacade.find(t.getIddate()));
            }
        }

        //on remet à jour la variable de session
        moisPresentsDansBDD.setMoisPresent(dateTraitementFacade.findAll());
    }
}
