 package service;

import dao.StatsDao;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import util.HtmlSqlDate;

@Path("service")
public class StatisticsService {

	@Inject
	StatsDao dao;

	@GET
	@Path("requete1")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantRemboursementsParRegion(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
                return dao.montantRemboursementsParRegion(minDate, maxDate);
	}
        
        @GET
	@Path("requete2")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List trancheAgePlusRembourseeParRegion(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.trancheAgePlusRembourseeParRegion(minDate, maxDate);
	}

	@GET
	@Path("requete3")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List naturePrestationPlusRembourseeParTrancheAge(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.naturePrestationPlusRembourseeParTrancheAge(minDate, maxDate);
	}
        
        @GET
	@Path("requete4")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantDepensesParSecteurPrivePublicParTrancheAge(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.montantDepensesParSecteurPrivePublicParTrancheAge(minDate, maxDate);
	}
        
        @GET
	@Path("requete5")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant(minDate, maxDate);
	}
}
