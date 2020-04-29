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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pseSpeSnds")
    private Collection<Executant> executantCollection;

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

    public void setSpeClair(String speClair) {
        this.speClair = speClair;
    }

    @XmlTransient
    public Collection<Executant> getExecutantCollection() {
        return executantCollection;
    }

    public void setExecutantCollection(Collection<Executant> executantCollection) {
        this.executantCollection = executantCollection;
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
