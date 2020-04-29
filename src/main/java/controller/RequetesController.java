/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Gzip.Gzip;
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
import entity.AgeBenSndsClair;
import entity.BenResRegClair;
import entity.Beneficiaire;
import entity.DateTraitement;
import entity.Executant;
import entity.Indicateurs;
import entity.Prestation;
import entity.PrsNatClair;
import entity.PrsPpuSecClair;
import entity.PseSpeSndsClair;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ulyss
 */
@Controller
@Path("requetes")
@View("requetes.jsp")
public class RequetesController {
    
    // Les DAO générés par netBeans
    @Inject 
    FichiersdamirFacade Fichiersdamir;

    @Inject 
    PrestationFacade prestation;
    
    @Inject
    AgeBenSndsClairFacade ageBenSndsClairFacade;
    
    @Inject
    BenResRegClairFacade benResRegClairFacade;
    
    @Inject
    BeneficiaireFacade beneficiaireFacade;
    
    @Inject
    DateTraitementFacade dateTraitementFacade;
    
    @Inject
    ExecutantFacade executantFacade;
    
    @Inject
    FichiersdamirFacade fichiersdamirFacade;
    
    @Inject
    IndicateursFacade indicateursFacade;
    
    @Inject
    PrestationFacade prestationFacade;
    
    @Inject
    PrsNatClairFacade prsNatClairFacade;
    
    @Inject
    PrsPpuSecClairFacade prsPpuSecClairFacade;
    
    @Inject
    PseSpeSndsClairFacade pseSpeSndsClairFacade;
    
    
    
    
    @Inject
    Models models;
    
    @GET
    public void periode(@QueryParam("periodeChoisie") String periodeChoisie, 
    @QueryParam("moisChoisis") String moisChoisis, 
    @QueryParam("anneesChoisies") String anneesChoisies) throws Exception{
        //Attribuer la période choisie à la variable de session
        Fichiersdamir.setPeriodeChoisie(periodeChoisie);
        //Envoyer la période choisie à la vue
        models.put("periodeChoisie", Fichiersdamir.getPeriodeChoisie());
        //Convertir les String années et mois choisis en tableaux de String en utilisant la virgule comme séparateur 
        String[] annees = anneesChoisies.split("\\,");
        String[] mois = moisChoisis.split("\\,");
        //Vider la variable de session des clés des fichiers
        ArrayList<String> a = new ArrayList<>();
        Fichiersdamir.setClesFichiers(a);
        //Parcourir chaque période
        for (int i = 0; i < annees.length; i++) {
            String nbMois = "";
            //Convertir le mois en toutes lettres en mois en nombre
            switch(mois[i]) {
                case "Janvier" :
                    nbMois = "01";
                    break;
                case "Février" :
                    nbMois = "02";
                    break;
                case "Mars" :
                    nbMois = "03";
                    break;
                case "Avril" :
                    nbMois = "04";
                    break;
                case "Mai" :
                    nbMois = "05";
                    break;
                case "Juin" :
                    nbMois = "06";
                    break;
                case "Juillet" :
                    nbMois = "07";
                    break;
                case "Août" :
                    nbMois = "08";
                    break;
                case "Septembre" :
                    nbMois = "09";
                    break;
                case "Octobre" :
                    nbMois = "10";
                    break;
                case "Novembre" :
                    nbMois = "11";
                    break;
                case "Décembre" :
                    nbMois = "12";
                    break;
                case "null" :
                    nbMois = "";
                    break;
            }
            //Créer la clé correspondante et l'ajouter à la variable de session
            Fichiersdamir.getClesFichiers().add("DAMIR_" + annees[i] + nbMois + "_SMALL");
        }
        //Envoyer la liste des clés à la vue
        models.put("clesFichiers", Fichiersdamir.getClesFichiers());
        //Vider la variable de session des url des fichiers
        ArrayList<String> b = new ArrayList<>();
        Fichiersdamir.setUrlFichiers(b);
        //Pour chaque clé de la variable de session
        for (String cle : Fichiersdamir.getClesFichiers()) {
            //Récupérer l'url du fichier correspondant à la clé
            String url = Fichiersdamir.find(cle).getUrlfichier();
            System.out.println(url);
            //Ajouter l'url à la variable de session
            Fichiersdamir.getUrlFichiers().add(url);
        }
        //Afficher les url
        System.out.println(Fichiersdamir.getUrlFichiers());
        //Parcourir chaque url
        for (String url : Fichiersdamir.getUrlFichiers()) {
            Gzip downloader = new Gzip();
            //Créer les entités correspondantes dans la BDD
                this.readGzipURL(url);
        } 
    }
    //Requêtes
    @GET
    @Path("stats")
    public void stats(@QueryParam("colonnes") String colonnes) throws Exception {
        //Convertir les colonnes (String) en entiers en utilisant la virgule comme séparateur 
        String[] colonnesTab = colonnes.split("\\,");
       
        int[] nbColonnes = new int[colonnesTab.length];
        
        for (int i = 0; i < nbColonnes.length; i++) {
            nbColonnes[i] = Integer.parseInt(colonnesTab[i]);
        }  
    }
    
    
    public void readGzipURL(String gzipURL) throws MalformedURLException, IOException, Exception {
        //convertit l'url (String) saisi en un objet (URL)
        URL url = new URL(gzipURL);
        //Lit le fichier ligne par ligne
        try (
                //créér la variable @line (String) qui va représenter chaque ligne du fichier
                InputStream in = url.openStream();
                GZIPInputStream gzipIn = new GZIPInputStream(in);
                LineNumberReader reader = new LineNumberReader(new InputStreamReader(gzipIn));) {
            String line;
            ArrayList<float[]> j = new ArrayList<float[]>();
            //Pour chaque ligne du fichier, 
            while ((line = reader.readLine()) != null) {
                //on ajoute chaque ligne sous forme de int[] à j
                if (reader.getLineNumber() > 1) {
                    int id = reader.getLineNumber();
                    //on ajoute chaque ligne sous forme de int[] à j
                    String[] processLine = processLine(reader.getLineNumber(), line);
                    
                    //Création de Benficiaire correspondante à la ligne
                    Beneficiaire beneficiaire = new Beneficiaire(id);
                    beneficiaire.setAgeBenSnds(ageBenSndsClairFacade.find(processLine[2]));
                    beneficiaire.setBenResReg(benResRegClairFacade.find(processLine[3]));
                    
                    //Création de DateTraitement correspondante à la ligne
                    DateTraitement dateTraitement = new DateTraitement(id);
                    dateTraitement.setFlxAnnMoi(Integer.parseInt(processLine[0]));
                    
                    //Création de Executant correspondante à la ligne
                    Executant executant = new Executant(id);
                    executant.setPseSpeSnds(pseSpeSndsClairFacade.find(processLine[47]));
                    //Création de Indicateurs correspondante à la ligne
                    Indicateurs indicateurs = new Indicateurs(id);
                    indicateurs.setPrsPaiMnt(Double.parseDouble(processLine[20]));
                    indicateurs.setPrsRemMnt(Double.parseDouble(processLine[22]));
                    //Création de Prestation correspondante à la ligne
                    Prestation prestation = new Prestation(id);
                    prestation.setBeneficiaire(beneficiaire);
                    prestation.setDateTraitement(dateTraitement);
                    prestation.setExecutant(executant);
                    prestation.setIndicateurs(indicateurs);
                    prestation.setPrsNat(prsNatClairFacade.find(processLine[39]));
                    prestation.setPrsPpuSec(prsPpuSecClairFacade.find(processLine[40]));
                    
                    //prestation relié a chaque objet
                    beneficiaire.setPrestation(prestation);
                    dateTraitement.setPrestation(prestation);
                    executant.setPrestation(prestation);
                    indicateurs.setPrestation(prestation);
                    
                    System.out.println("Test ok");
                    //Création des entités dans bdd
                    beneficiaireFacade.create(beneficiaire);
                    dateTraitementFacade.create(dateTraitement);
                    executantFacade.create(executant);
                    indicateursFacade.create(indicateurs);
                    prestationFacade.create(prestation);
                    System.out.println("ok"+"\n");                                    
                }
            }
        }
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

}