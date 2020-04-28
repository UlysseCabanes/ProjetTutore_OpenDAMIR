/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "PSE_SPE_SNDS_CLAIR")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "PseSpeSndsClair.findAll", query = "SELECT p FROM PseSpeSndsClair p"),
	@NamedQuery(name = "PseSpeSndsClair.findBySpeNum", query = "SELECT p FROM PseSpeSndsClair p WHERE p.speNum = :speNum"),
	@NamedQuery(name = "PseSpeSndsClair.findBySpeClair", query = "SELECT p FROM PseSpeSndsClair p WHERE p.speClair = :speClair")})
public class PseSpeSndsClair implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "SPE_NUM")
	private Integer speNum;
	@Size(max = 200)
        @Column(name = "SPE_CLAIR")
	private String speClair;

	public PseSpeSndsClair() {
	}

	public PseSpeSndsClair(Integer speNum) {
		this.speNum = speNum;
	}

	public Integer getSpeNum() {
		return speNum;
	}

	public void setSpeNum(Integer speNum) {
		this.speNum = speNum;
	}

	public String getSpeClair() {
		return speClair;
	}

	public void setSpeClair(int a) {
		if (a == 0) {
            this.speClair = "NON RENSEIGNE";
        }
        if (a == 1) {
            this.speClair = "MEDECINE GENERALE";
        }
        if (a == 2) {
            this.speClair = "ANESTHESIOLOGIE - REANIMATION";
        }
        if (a == 3) {
            this.speClair = "PATHOLOGIE CARDIO-VASCULAIRE";
        }
        if (a == 4) {
            this.speClair = "CHIRURGIE";
        }
        if (a == 5) {
            this.speClair = "DERMATOLOGIE ET VENEROLOGIE";
        }
        if (a == 6) {
            this.speClair = "RADIOLOGIE";
        }
        if (a == 7) {
            this.speClair = "GYNECOLOGIE OBSTETRIQUE";
        }
        if (a == 8) {
            this.speClair = "GASTRO-ENTEROLOGIE ET HEPATOLOGIE";
        }
        if (a == 9) {
            this.speClair = "MEDECINE INTERNE";
        }
        if (a == 11) {
            this.speClair = "OTO RHINO-LARYNGOLOGIE";
        }
        if (a == 12) {
            this.speClair = "PEDIATRIE";
        }
        if (a == 13) {
            this.speClair = "PNEUMOLOGIE";
        }
        if (a == 14) {
            this.speClair = "RHUMATOLOGIE";
        }
        if (a == 15) {
            this.speClair = "OPHTALMOLOGIE";
        }
        if (a == 18) {
            this.speClair = "STOMATOLOGIE";
        }
        if (a == 31) {
            this.speClair = "MEDECINE PHYSIQUE ET DE READAPTATION";
        }
        if (a == 32) {
            this.speClair = "NEUROLOGIE";
        }
        if (a == 33) {
            this.speClair = "PSYCHIATRIE";
        }
        if (a == 34) {
            this.speClair = "GERIATRIE";
        }
        if (a ==35) {
            this.speClair = "NEPHROLOGIE";
        }
        if (a ==36) {
            this.speClair = "CHIRURGIE DENTAIRE (SPECIALISTE O.D.F.)";
        }
        if (a ==37) {
            this.speClair = "ANATOMIE-CYTOLOGIE-PATHOLOGIQUE";
        }
        if (a == 38) {
            this.speClair = "DIRECTEUR LABORATOIRE MEDECIN";
        }
        if (a == 42) {
            this.speClair = "ENDOCRINOLOGIE ET METABOLISMES";
        }
        if (a == 80) {
            this.speClair = "SANTE PUBLIQUE ET MEDECINE SOCIALE";
        }
        if (a == 99) {
            this.speClair = "VALEUR INCONNUE";
        }
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (speNum != null ? speNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof PseSpeSndsClair)) {
			return false;
		}
		PseSpeSndsClair other = (PseSpeSndsClair) object;
		if ((this.speNum == null && other.speNum != null) || (this.speNum != null && !this.speNum.equals(other.speNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.PseSpeSndsClair[ speNum=" + speNum + " ]";
	}
	
}
