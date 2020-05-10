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
public class StatsResult_4 {

	public StatsResult_4(String trancheAge, String secteur, double montant) {
                this.trancheAge = trancheAge;
                this.secteur = secteur;
                this.montant = montant;
	}
	
	public StatsResult_4() {
		this("Inconnu", "Inconnu", 0);
	}

	@XmlElement
	public final String trancheAge;
        
        @XmlElement
	public final String secteur;
        
        @XmlElement
	public final double montant;
	
}
