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
    public void show(@QueryParam("requete") String requete,
        @QueryParam("moisDebut") String moisDebut,
        @QueryParam("anneeDebut") String anneeDebut,
        @QueryParam("moisFin") String moisFin,
        @QueryParam("anneeFin") String anneeFin) {
        

    }
}
