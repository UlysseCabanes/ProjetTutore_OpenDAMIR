 package service;

import dao.StatsDao;
import dto.StatsResult_1;
import dto.StatsResult_2_3;
import dto.StatsResult_4;
import dto.StatsResult_5;
import java.util.Date;
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
	public List<StatsResult_1> montantRemboursementsParRegion(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
                return dao.montantRemboursementsParRegion(minDate, maxDate);
	}
        
        @GET
	@Path("requete2")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult_2_3> trancheAgePlusRembourseeParRegion(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.trancheAgePlusRembourseeParRegion(minDate, maxDate);
	}

	@GET
	@Path("requete3")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult_2_3> naturePrestationPlusRembourseeParTrancheAge(
            @QueryParam("minDate") Date minDate,
            @QueryParam("maxDate") Date maxDate) {
		return dao.naturePrestationPlusRembourseeParTrancheAge(minDate, maxDate);
	}
        
        @GET
	@Path("requete4")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult_4> montantDepensesParSecteurPrivePublicParTrancheAge(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.montantDepensesParSecteurPrivePublicParTrancheAge(minDate, maxDate);
	}
        
        @GET
	@Path("requete5")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<StatsResult_5> montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant(
            @QueryParam("minDate") HtmlSqlDate minDate,
            @QueryParam("maxDate") HtmlSqlDate maxDate) {
		return dao.montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant(minDate, maxDate);
	}
}
