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

	public StatsResult_5(String libelle, double montant1, double montant2) {
                this.libelle = libelle;
                this.montant1 = montant1;
                this.montant2 = montant2;
	}
	
	public StatsResult_5() {
		this("Inconnu", 0, 0);
	}

	@XmlElement
	public final String libelle;
        
        @XmlElement
	public final double montant1;
        
        @XmlElement
	public final double montant2;
	
}
