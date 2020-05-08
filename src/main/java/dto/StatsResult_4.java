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

	public StatsResult_4(float montant, String secteur, String trancheAge) {
                this.montant = montant;
                this.secteur = secteur;
                this.trancheAge = trancheAge;
	}
	
	public StatsResult_4() {
		this(0, "Inconnu", "Inconnu");
	}

	@XmlElement
	public final float montant;
        
        @XmlElement
	public final String secteur;
        
        @XmlElement
	public final String trancheAge;
	
}
