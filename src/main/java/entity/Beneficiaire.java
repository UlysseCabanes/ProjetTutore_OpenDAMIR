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
 * @author Alex
 */
@Entity
@Table(name = "BENEFICIAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Beneficiaire.findAll", query = "SELECT b FROM Beneficiaire b"),
    @NamedQuery(name = "Beneficiaire.findByIdbeneficiaire", query = "SELECT b FROM Beneficiaire b WHERE b.idbeneficiaire = :idbeneficiaire")})
public class Beneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBENEFICIAIRE")
    private Integer idbeneficiaire;
    @JoinColumn(name = "AGE_BEN_SNDS", referencedColumnName = "AGE_NUM")
    @ManyToOne(optional = false)
    private AgeBenSndsClair ageBenSnds;
    @JoinColumn(name = "BEN_RES_REG", referencedColumnName = "REG_NUM")
    @ManyToOne(optional = false)
    private BenResRegClair benResReg;
    @JoinColumn(name = "IDBENEFICIAIRE", referencedColumnName = "IDPRESTATION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prestation prestation;

    public Beneficiaire() {
    }

    public Beneficiaire(Integer idbeneficiaire) {
        this.idbeneficiaire = idbeneficiaire;
    }

    public Integer getIdbeneficiaire() {
        return idbeneficiaire;
    }

    public void setIdbeneficiaire(Integer idbeneficiaire) {
        this.idbeneficiaire = idbeneficiaire;
    }

    public AgeBenSndsClair getAgeBenSnds() {
        return ageBenSnds;
    }

    public void setAgeBenSnds(AgeBenSndsClair ageBenSnds) {
        this.ageBenSnds = ageBenSnds;
    }

    public BenResRegClair getBenResReg() {
        return benResReg;
    }

    public void setBenResReg(BenResRegClair benResReg) {
        this.benResReg = benResReg;
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
        hash += (idbeneficiaire != null ? idbeneficiaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Beneficiaire)) {
            return false;
        }
        Beneficiaire other = (Beneficiaire) object;
        if ((this.idbeneficiaire == null && other.idbeneficiaire != null) || (this.idbeneficiaire != null && !this.idbeneficiaire.equals(other.idbeneficiaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Beneficiaire[ idbeneficiaire=" + idbeneficiaire + " ]";
    }
    
}
