/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DateTraitementFacade;
import entity.DateTraitement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Alex
 */
@Controller
@Path("accueil")
@View("accueil.jsp")
public class AccueilController {

    @Inject
    Models models;
    @Inject
    DateTraitementFacade dateTraitementFacade;

    @GET
    public void showMoisPresent() {
        TreeSet<Date> toutesLesDates = new TreeSet<>();
        ArrayList<String> dates = new ArrayList<>();
        
        //Parcourir toutes les entités "date de traitemet" de la BDD
        for (DateTraitement d : dateTraitementFacade.findAll()) {
            Date dateD = d.getFlxAnnMoi();
            //Vérifier que la date n'a pas déjà été prise en compte
            if (!toutesLesDates.contains(dateD)) {
                //Ajouter la date à la liste
                toutesLesDates.add(dateD);
            }
        }
        //Parcourir la liste des dates différentes
        for (Date d : toutesLesDates) {
            //Convertir la date au format adéquat
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
            String strDate = formatter.format(d);
            //Ajouter la date convertie à la liste
            dates.add(strDate);
        }
        //Envoyer la liste à la vue
        models.put("toutesLesDates", dates);
    }

}
