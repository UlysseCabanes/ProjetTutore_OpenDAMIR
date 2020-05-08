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
public class StatsResult_2_3 {

	public StatsResult_2_3(String libelle, String trancheAge) {
		this.libelle = libelle;
                this.trancheAge = trancheAge;
	}
	
	public StatsResult_2_3() {
		this("Inconnu", "Inconnu");
	}

	@XmlElement
	public final String libelle;

	@XmlElement
	public final String trancheAge;
	
}
