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
public class StatsResult_5 {

	public StatsResult_5(float depense, float remboursement, String specialite) {
                this.depense = depense;
                this.remboursement = remboursement;
                this.specialite = specialite;
	}
	
	public StatsResult_5() {
		this(0, 0, "Inconnu");
	}

	@XmlElement
	public final float depense;
        
        @XmlElement
	public final float remboursement;
        
        @XmlElement
	public final String specialite;
	
}
