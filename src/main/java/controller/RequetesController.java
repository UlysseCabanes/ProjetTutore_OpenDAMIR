/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Gzip.Gzip;
import dao.FichiersdamirFacade;
import dao.PrestationFacade;
import java.util.ArrayList;
import java.util.Arrays;
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
            //Ajouter l'url à la variable de session
            Fichiersdamir.getUrlFichiers().add(url);
        }
        System.out.println(Fichiersdamir.getUrlFichiers());
        
        int[] colonnes = {2,3,20,22,39,40,47};
        for (String url : Fichiersdamir.getUrlFichiers()) {
            Gzip downloader = new Gzip();
            ArrayList<int[]> d = downloader.readGzipURL(url, colonnes);
            for(int i=0;i < d.size();i++){
                System.out.println(Arrays.toString(d.get(i)));
            }
        } 
        /*
        for (int i = 0;i < remboursements.length; i++) {
            prestation.setIdprestation(i);
            prestation.setPrsNat(remboursements.get(i).get(nbcolonne PrsNat));
        }
        */
    }
    
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
}