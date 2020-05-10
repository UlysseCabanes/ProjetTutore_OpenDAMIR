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
 * @author ulyss
 */
@Entity
@Table(name = "PRS_PPU_SEC_CLAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrsPpuSecClair.findAll", query = "SELECT p FROM PrsPpuSecClair p"),
    @NamedQuery(name = "PrsPpuSecClair.findBySecNum", query = "SELECT p FROM PrsPpuSecClair p WHERE p.secNum = :secNum"),
    @NamedQuery(name = "PrsPpuSecClair.findBySecClair", query = "SELECT p FROM PrsPpuSecClair p WHERE p.secClair = :secClair")})
public class PrsPpuSecClair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_NUM")
    private Integer secNum;
    @Size(max = 200)
    @Column(name = "SEC_CLAIR")
    private String secClair;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prsPpuSec")
    private Collection<Prestation> prestationCollection;

    public PrsPpuSecClair() {
    }

    public PrsPpuSecClair(Integer secNum) {
        this.secNum = secNum;
    }

    public Integer getSecNum() {
        return secNum;
    }

    public void setSecNum(Integer secNum) {
        this.secNum = secNum;
    }

    public String getSecClair() {
        return secClair;
    }

    public void setSecClair(String secClair) {
        this.secClair = secClair;
    }

    @XmlTransient
    public Collection<Prestation> getPrestationCollection() {
        return prestationCollection;
    }

    public void setPrestationCollection(Collection<Prestation> prestationCollection) {
        this.prestationCollection = prestationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secNum != null ? secNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrsPpuSecClair)) {
            return false;
        }
        PrsPpuSecClair other = (PrsPpuSecClair) object;
        if ((this.secNum == null && other.secNum != null) || (this.secNum != null && !this.secNum.equals(other.secNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrsPpuSecClair[ secNum=" + secNum + " ]";
    }
    
}
