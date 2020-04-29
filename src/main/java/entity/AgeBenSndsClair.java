/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Alex
 */
@Entity
@Table(name = "AGE_BEN_SNDS_CLAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgeBenSndsClair.findAll", query = "SELECT a FROM AgeBenSndsClair a"),
    @NamedQuery(name = "AgeBenSndsClair.findByAgeNum", query = "SELECT a FROM AgeBenSndsClair a WHERE a.ageNum = :ageNum"),
    @NamedQuery(name = "AgeBenSndsClair.findByAgeClair", query = "SELECT a FROM AgeBenSndsClair a WHERE a.ageClair = :ageClair")})
public class AgeBenSndsClair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AGE_NUM")
    private Integer ageNum;
    @Size(max = 200)
    @Column(name = "AGE_CLAIR")
    private String ageClair;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ageBenSnds")
    private Collection<Beneficiaire> beneficiaireCollection;

    public AgeBenSndsClair() {
    }

    public AgeBenSndsClair(Integer ageNum) {
        this.ageNum = ageNum;
    }

    public Integer getAgeNum() {
        return ageNum;
    }

    public void setAgeNum(Integer ageNum) {
        this.ageNum = ageNum;
    }

    public String getAgeClair() {
        return ageClair;
    }

    public void setAgeClair(String ageClair) {
        this.ageClair = ageClair;
    }

    @XmlTransient
    public Collection<Beneficiaire> getBeneficiaireCollection() {
        return beneficiaireCollection;
    }

    public void setBeneficiaireCollection(Collection<Beneficiaire> beneficiaireCollection) {
        this.beneficiaireCollection = beneficiaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ageNum != null ? ageNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgeBenSndsClair)) {
            return false;
        }
        AgeBenSndsClair other = (AgeBenSndsClair) object;
        if ((this.ageNum == null && other.ageNum != null) || (this.ageNum != null && !this.ageNum.equals(other.ageNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AgeBenSndsClair[ ageNum=" + ageNum + " ]";
    }
    
}
