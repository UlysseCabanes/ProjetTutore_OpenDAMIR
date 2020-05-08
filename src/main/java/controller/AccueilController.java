/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DateTraitementFacade;
import entity.DateTraitement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        TreeSet<Date> toutesLesDates = new TreeSet<Date>();
        ArrayList<String> dates=new ArrayList<>();

        for (DateTraitement d : dateTraitementFacade.findAll()) {
            Date dateD = d.getFlxAnnMoi();
            if (!toutesLesDates.contains(dateD)) {
                toutesLesDates.add(dateD);
            }
        }
       

        for (Date g : toutesLesDates) {
            
            SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
            String strDate = formatter.format(g);
            dates.add(strDate);
        }

        models.put("toutesLesDates", dates);
    }

}
