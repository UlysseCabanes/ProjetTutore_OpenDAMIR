 package service;

import dao.StatsDao;
import java.util.List;
import javax.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("service")
public class StatisticsService {

	@Inject
	StatsDao dao;

	@GET
	@Path("requete1")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantRemboursementsParRegion() {
		return dao.montantRemboursementsParRegion();
	}
        
        @GET
	@Path("requete2")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List trancheAgePlusRembourseeParRegion() {
		return dao.trancheAgePlusRembourseeParRegion();
	}

	@GET
	@Path("requete3")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List naturePrestationPlusRembourseeParTrancheAge() {
		return dao.naturePrestationPlusRembourseeParTrancheAge();
	}
        
        @GET
	@Path("requete4")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantDepensesParSecteurPrivePublicParTrancheAge() {
		return dao.montantDepensesParSecteurPrivePublicParTrancheAge();
	}
        
        @GET
	@Path("requete5")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant() {
		return dao.montantMoyenDepensesRemboursementParSpecialiteMedecinExecutant();
	}
}
