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
public class StatsResult {

	public StatsResult(String region, float montant) {
		this.region = region;
                this.montant = montant;
	}
	
	public StatsResult() {
		this("Inconnu", 0);
	}
	
	// Pas utile de mettre des "getter" ici (final)
	@XmlElement
	public final String region;

	@XmlElement
	public final float montant;
	
}
