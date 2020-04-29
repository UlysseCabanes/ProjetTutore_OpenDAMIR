/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
 * @author Alex
 */
@Entity
@Table(name = "PRESTATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestation.findAll", query = "SELECT p FROM Prestation p"),
    @NamedQuery(name = "Prestation.findByIdprestation", query = "SELECT p FROM Prestation p WHERE p.idprestation = :idprestation")})
public class Prestation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRESTATION")
    private Integer idprestation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prestation")
    private DateTraitement dateTraitement;
    @JoinColumn(name = "PRS_NAT", referencedColumnName = "NAT_NUM")
    @ManyToOne(optional = false)
    private PrsNatClair prsNat;
    @JoinColumn(name = "PRS_PPU_SEC", referencedColumnName = "SEC_NUM")
    @ManyToOne(optional = false)
    private PrsPpuSecClair prsPpuSec;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prestation")
    private Executant executant;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prestation")
    private Beneficiaire beneficiaire;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prestation")
    private Indicateurs indicateurs;

    public Prestation() {
    }

    public Prestation(Integer idprestation) {
        this.idprestation = idprestation;
    }

    public Integer getIdprestation() {
        return idprestation;
    }

    public void setIdprestation(Integer idprestation) {
        this.idprestation = idprestation;
    }

    public DateTraitement getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(DateTraitement dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public PrsNatClair getPrsNat() {
        return prsNat;
    }

    public void setPrsNat(PrsNatClair prsNat) {
        this.prsNat = prsNat;
    }

    public PrsPpuSecClair getPrsPpuSec() {
        return prsPpuSec;
    }

    public void setPrsPpuSec(PrsPpuSecClair prsPpuSec) {
        this.prsPpuSec = prsPpuSec;
    }

    public Executant getExecutant() {
        return executant;
    }

    public void setExecutant(Executant executant) {
        this.executant = executant;
    }

    public Beneficiaire getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(Beneficiaire beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public Indicateurs getIndicateurs() {
        return indicateurs;
    }

    public void setIndicateurs(Indicateurs indicateurs) {
        this.indicateurs = indicateurs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprestation != null ? idprestation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.idprestation == null && other.idprestation != null) || (this.idprestation != null && !this.idprestation.equals(other.idprestation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Prestation[ idprestation=" + idprestation + " ]";
    }
    
}
