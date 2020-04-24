/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Gzip.Gzip;
import dao.FichiersdamirFacade;
import java.util.ArrayList;
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
    
    
    @Inject // Le DAO généré par netBeans
    FichiersdamirFacade dao;
    
    @Inject
    Models models;
    
    @GET
    public void periode(@QueryParam("periodeChoisie") String periodeChoisie, 
    @QueryParam("moisChoisis") String moisChoisis, 
    @QueryParam("anneesChoisies") String anneesChoisies) throws Exception{
        dao.setPeriodeChoisie(periodeChoisie);
        //Envoyer la période choisie à la vue
        models.put("periodeChoisie", dao.getPeriodeChoisie());
       
        //Convertir les String années et mois en tableaux de String en utilisant la virgule comme séparateur 
        String[] annees = anneesChoisies.split("\\,");
        String[] mois = moisChoisis.split("\\,");
        //Vider la liste des clés des fichiers
        ArrayList<String> a = new ArrayList<>();
        dao.setClesFichiers(a);
        //Parcourir chaque période
        for (int i = 0; i < annees.length; i++) {
            String nbMois = "";
            //Convertir le mois en toutes lettres en un mois en nombre
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
            //Créer la clé correspondante et l'ajouter à la liste
            dao.getClesFichiers().add("DAMIR_" + annees[i] + nbMois + "_SMALL");
        }
        //Envoyer la liste à la vue
        models.put("clesFichiers", dao.getClesFichiers());
        
        for (String cle : dao.getClesFichiers()) {
            dao.getUrlFichiers().add(dao.find(cle).getUrlfichier());
        }
        System.out.println(dao.getUrlFichiers());
        /*
        for (String url : dao.getUrlFichiers()) {
            Gzip downloader = new Gzip();
            System.out.println(downloader.readGzipURL(url));
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