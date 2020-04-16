/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
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
@Table(name = "BEN_RES_REG_CLAIR")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "BenResRegClair.findAll", query = "SELECT b FROM BenResRegClair b"),
	@NamedQuery(name = "BenResRegClair.findByRegNum", query = "SELECT b FROM BenResRegClair b WHERE b.regNum = :regNum"),
	@NamedQuery(name = "BenResRegClair.findByRegClair", query = "SELECT b FROM BenResRegClair b WHERE b.regClair = :regClair")})
public class BenResRegClair implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @Basic(optional = false)
        @NotNull
        @Column(name = "REG_NUM")
	private Integer regNum;
	@Size(max = 200)
        @Column(name = "REG_CLAIR")
	private String regClair;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "benResReg")
	private List<Beneficiaire> beneficiaireList;

	public BenResRegClair() {
	}

	public BenResRegClair(Integer regNum) {
		this.regNum = regNum;
	}

	public Integer getRegNum() {
		return regNum;
	}

	public void setRegNum(Integer regNum) {
		this.regNum = regNum;
	}

	public String getRegClair() {
		return regClair;
	}

	public void setRegClair(String regClair) {
		this.regClair = regClair;
	}

	@XmlTransient
	public List<Beneficiaire> getBeneficiaireList() {
		return beneficiaireList;
	}

	public void setBeneficiaireList(List<Beneficiaire> beneficiaireList) {
		this.beneficiaireList = beneficiaireList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (regNum != null ? regNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof BenResRegClair)) {
			return false;
		}
		BenResRegClair other = (BenResRegClair) object;
		if ((this.regNum == null && other.regNum != null) || (this.regNum != null && !this.regNum.equals(other.regNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entity.BenResRegClair[ regNum=" + regNum + " ]";
	}
	
}
