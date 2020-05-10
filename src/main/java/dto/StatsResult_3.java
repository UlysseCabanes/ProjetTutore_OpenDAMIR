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
public class StatsResult_3 {

	public StatsResult_3(String trancheAge, String nature, long nbPrestations) {
            this.trancheAge = trancheAge;
            this.nature = nature;
            this.nbPrestations = nbPrestations; 
	}
	
	public StatsResult_3() {
		this("Inconnu", "Inconnu", 0);
	}

        @XmlElement
	public final String trancheAge;
	
        @XmlElement
	public final String nature;

	@XmlElement
	public final long nbPrestations;
}
