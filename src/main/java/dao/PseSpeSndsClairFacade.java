/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.PseSpeSndsClair;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ulyss
 */
@Stateless
public class PseSpeSndsClairFacade extends AbstractFacade<PseSpeSndsClair> {

    @PersistenceContext(unitName = "damir")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PseSpeSndsClairFacade() {
        super(PseSpeSndsClair.class);
    }
    
}
