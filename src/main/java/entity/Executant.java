/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rbastide
 */
@Entity
@Table(name = "EXECUTANT")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Executant.findAll", query = "SELECT e FROM Executant e"),
	@NamedQuery(name = "Executant.findByIdexecutant", query = "SELECT e FROM Executant e WHERE e.idexecutant = :idexecutant")})
public class Executant implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "IDEXECUTANT")
	private Integer idexecutant;
	@JoinColumn(name = "IDEXECUTANT", referencedColumnName = "IDPRESTATION", insertable = false, updatable = false)
        @OneToOne(optional = false)
	private Prestation prestation;
	@JoinColumn(name = "PSE_SPE_SNDS", referencedColumnName = "SPE_NUM")
        @ManyToOne(optional = false)
	private PseSpeSndsClair pseSpeSnds;

	public Executant() {
	}

	public Executant(Integer idexecutant) {
		this.idexecutant = idexecutant;
	}

	public Integer getIdexecutant() {
		return idexecutant;
	}

	public void setIdexecutant(Integer idexecutant) {
		this.idexecutant = idexecutant;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	public PseSpeSndsClair getPseSpeSnds() {
		return pseSpeSnds;
	}

	public void setPseSpeSnds(PseSpeSndsClair pseSpeSnds) {
		this.pseSpeSnds = pseSpeSnds;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idexecutant != null ? idexecutant.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Executant)) {
			return false;
		}
		Executant other = (Executant) object;
		if ((this.idexecutant == null && other.idexecutant != null) || (this.idexecutant != null && !this.idexecutant.equals(other.idexecutant))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Executant[ idexecutant=" + idexecutant + " ]";
	}
	
}
