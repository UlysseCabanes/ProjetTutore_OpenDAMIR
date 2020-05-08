/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import util.MoisNombre;

/**
 *
 * @author ulyss
 */
@Controller
@Path("requetes")
@View("requetes.jsp")
public class RequetesController {
    
    @Inject
    Models models;
    
    @GET
    public void show() {
        
    }
    
    @GET
    @Path("dates")
    public void dates(@QueryParam("moisDebut") String moisDebut,
        @QueryParam("anneeDebut") String anneeDebut,
        @QueryParam("moisFin") String moisFin,
        @QueryParam("anneeFin") String anneeFin) {
        
        //Convertir les mois en toutes lettres en mois en nombres
        String nbMoisDebut = MoisNombre.monthToNumber(moisDebut);
        String nbMoisFin = MoisNombre.monthToNumber(moisFin);
        
        //Convertir les dates
        LocalDate localdate = LocalDate.parse(anneeDebut + nbMoisDebut + "01", DateTimeFormatter.BASIC_ISO_DATE);
        Date dateMin = java.sql.Date.valueOf(localdate);
        localdate = LocalDate.parse(anneeFin + nbMoisFin + "01", DateTimeFormatter.BASIC_ISO_DATE);
        Date dateMax = java.sql.Date.valueOf(localdate);
        //Envoyer les dates au bon format à la vue
        models.put("dateMin", dateMin);
        models.put("dateMax", dateMax);
    }
}
