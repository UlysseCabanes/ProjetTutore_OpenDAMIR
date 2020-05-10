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
@Table(name = "PRS_NAT_CLAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrsNatClair.findAll", query = "SELECT p FROM PrsNatClair p"),
    @NamedQuery(name = "PrsNatClair.findByNatNum", query = "SELECT p FROM PrsNatClair p WHERE p.natNum = :natNum"),
    @NamedQuery(name = "PrsNatClair.findByNatClair", query = "SELECT p FROM PrsNatClair p WHERE p.natClair = :natClair")})
public class PrsNatClair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAT_NUM")
    private Integer natNum;
    @Size(max = 200)
    @Column(name = "NAT_CLAIR")
    private String natClair;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prsNat")
    private Collection<Prestation> prestationCollection;

    public PrsNatClair() {
    }

    public PrsNatClair(Integer natNum) {
        this.natNum = natNum;
    }

    public Integer getNatNum() {
        return natNum;
    }

    public void setNatNum(Integer natNum) {
        this.natNum = natNum;
    }

    public String getNatClair() {
        return natClair;
    }

    public void setNatClair(String natClair) {
        this.natClair = natClair;
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
        hash += (natNum != null ? natNum.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrsNatClair)) {
            return false;
        }
        PrsNatClair other = (PrsNatClair) object;
        if ((this.natNum == null && other.natNum != null) || (this.natNum != null && !this.natNum.equals(other.natNum))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PrsNatClair[ natNum=" + natNum + " ]";
    }
    
}
