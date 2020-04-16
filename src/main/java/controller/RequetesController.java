/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
    
    @Inject
    Models models;
    
    @GET
    public void show(@QueryParam("periode") String periode, @QueryParam("listeAnnee") String annee, @QueryParam("listeMois") String mois) {
        String periodeChoisie = null;
        if (periode.equals("Un mois")) {
           periodeChoisie = mois + " " + annee;
        }
        if (periode.equals("Une année")) {
           periodeChoisie = annee;
        }
        if (periode.equals("Plusieurs mois")) {
           
        }
        models.put("periodeChoisie", periodeChoisie);
    }
}