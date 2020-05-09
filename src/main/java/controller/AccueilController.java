/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Gzip.MoisPresentsDansBDD;
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
    @Inject
    MoisPresentsDansBDD moisPresentsDansBDD;

    @GET
    public void show() {
        models.put("toutesLesDates", moisPresentsDansBDD.getDatesEnString());
    }
//    @Path("setMoisPresents")
//    public void voirLesMoisDejaPresents() {
//        moisPresentsDansBDD.setMoisPresent(dateTraitementFacade.findAll());
//        models.put("toutesLesDates", moisPresentsDansBDD.getDatesEnString());
//        
//    }

}
