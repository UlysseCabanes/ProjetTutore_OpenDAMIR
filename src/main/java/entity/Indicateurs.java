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
@Table(name = "INDICATEURS")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Indicateurs.findAll", query = "SELECT i FROM Indicateurs i"),
	@NamedQuery(name = "Indicateurs.findByIdindicateurs", query = "SELECT i FROM Indicateurs i WHERE i.idindicateurs = :idindicateurs"),
	@NamedQuery(name = "Indicateurs.findByPrsPaiMnt", query = "SELECT i FROM Indicateurs i WHERE i.prsPaiMnt = :prsPaiMnt"),
	@NamedQuery(name = "Indicateurs.findByPrsRemMnt", query = "SELECT i FROM Indicateurs i WHERE i.prsRemMnt = :prsRemMnt")})
public class Indicateurs implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "IDINDICATEURS")
	private Integer idindicateurs;
	// @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
	@Column(name = "PRS_PAI_MNT")
	private Double prsPaiMnt;
	@Column(name = "PRS_REM_MNT")
	private Double prsRemMnt;
	@JoinColumn(name = "IDINDICATEURS", referencedColumnName = "IDPRESTATION", insertable = false, updatable = false)
        @OneToOne(optional = false)
	private Prestation prestation;

	public Indicateurs() {
	}

	public Indicateurs(Integer idindicateurs) {
		this.idindicateurs = idindicateurs;
	}

	public Integer getIdindicateurs() {
		return idindicateurs;
	}

	public void setIdindicateurs(Integer idindicateurs) {
		this.idindicateurs = idindicateurs;
	}

	public Double getPrsPaiMnt() {
		return prsPaiMnt;
	}

	public void setPrsPaiMnt(Double prsPaiMnt) {
		this.prsPaiMnt = prsPaiMnt;
	}

	public Double getPrsRemMnt() {
		return prsRemMnt;
	}

	public void setPrsRemMnt(Double prsRemMnt) {
		this.prsRemMnt = prsRemMnt;
	}

	public Prestation getPrestation() {
		return prestation;
	}

	public void setPrestation(Prestation prestation) {
		this.prestation = prestation;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idindicateurs != null ? idindicateurs.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Indicateurs)) {
			return false;
		}
		Indicateurs other = (Indicateurs) object;
		if ((this.idindicateurs == null && other.idindicateurs != null) || (this.idindicateurs != null && !this.idindicateurs.equals(other.idindicateurs))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.Indicateurs[ idindicateurs=" + idindicateurs + " ]";
	}
	
}
