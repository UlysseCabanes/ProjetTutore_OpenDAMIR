/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.DateTraitement;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.HtmlSqlDate;

/**
 *
 * @author Alex
 */
@Stateless
public class DateTraitementFacade extends AbstractFacade<DateTraitement> {

    @PersistenceContext(unitName = "damir")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DateTraitementFacade() {
        super(DateTraitement.class);
    }
    
    public HtmlSqlDate datePlusRecente() {
		Date result = em.createQuery("select max(c.flxAnnMoi) from DateTraitement c", Date.class)
			.getSingleResult();
		return new HtmlSqlDate(result);
	}

	public Date datePlusAncienne() {
		Date result = em.createQuery("select min(c.flxAnnMoi) from DateTraitement c", Date.class)
			.getSingleResult();
		return new HtmlSqlDate(result);
	}
}
