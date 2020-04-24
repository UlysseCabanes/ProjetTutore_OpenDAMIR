/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Fichiersdamir;
import java.io.Serializable;
import java.util.ArrayList;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ulyss
 */
@SessionScoped
@Named("Fichiersdamir")
public class FichiersdamirFacade extends AbstractFacade<Fichiersdamir> implements Serializable{

    @PersistenceContext(unitName = "damir")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichiersdamirFacade() {
        super(Fichiersdamir.class);
    }
    
    //Créer une liste pour y stocker les clés des fichiers correspondant à la période choisie
    private ArrayList<String> clesFichiers = new ArrayList<>();
    
    private String periodeChoisie = new String();
    
    private ArrayList<String> urlFichiers = new ArrayList<>();
    
    public ArrayList<String> getClesFichiers() {
        return clesFichiers;
    }

    public void setClesFichiers(ArrayList<String> clesFichiers) {
        this.clesFichiers = clesFichiers;
    }

    public String getPeriodeChoisie() {
        return periodeChoisie;
    }

    public void setPeriodeChoisie(String periodeChoisie) {
        this.periodeChoisie = periodeChoisie;
    }

    public ArrayList<String> getUrlFichiers() {
        return urlFichiers;
    }

    public void setUrlFichiers(ArrayList<String> urlFichiers) {
        this.urlFichiers = urlFichiers;
    }
}
