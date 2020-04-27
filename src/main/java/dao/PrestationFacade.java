/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Prestation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rbastide
 */
@Stateless
public class PrestationFacade extends AbstractFacade<Prestation> {

	@PersistenceContext(unitName = "damir")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
        
        public void create(){
            
        }

	public PrestationFacade() {
		super(Prestation.class);
	}
	
}
