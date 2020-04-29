/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Fichiersdamir;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class FichiersdamirFacade extends AbstractFacade<Fichiersdamir> {

    @PersistenceContext(unitName = "damir")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FichiersdamirFacade() {
        super(Fichiersdamir.class);
    }
    
}
