package controller;

import dao.PrsNatClairFacade;
import entity.PrsNatClair;
import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Controller
@Path("prsnat")
@View("prsnat.jsp")
public class PrsNatController {
	@Inject // Le DAO généré par netBeans
	PrsNatClairFacade dao;

	@Inject
	Models models;

	@GET
	public void show() {
		List<PrsNatClair> prs = dao.findAll();
		models.put("prs", prs);
	}	
	
}
