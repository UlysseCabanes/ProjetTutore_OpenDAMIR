package dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * un "Data Transfer Object" (DTO) pour les statistiques
 * "Unités vendues par catégorie"
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class StatsResult_1 {

	public StatsResult_1(String region, double montant) {
		this.region = region;
                this.montant = montant;
	}
	
	public StatsResult_1() {
		this("Inconnu", 0);
	}

	@XmlElement
	public final String region;

	@XmlElement
	public final double montant;
	
}
