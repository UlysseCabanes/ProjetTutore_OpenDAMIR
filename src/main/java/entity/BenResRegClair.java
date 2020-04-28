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

    public void setRegClair(int a) {
        if (a == 5) {
            this.regClair = "Régions et Départements d outre-mer";
        }
        if (a == 11) {
            this.regClair = "Ile-de-France";
        }
        if (a == 24) {
            this.regClair = "Centre-Val de Loire";
        }
        if (a == 27) {
            this.regClair = "Bourgogne-Franche-Comté";
        }
        if (a == 28) {
            this.regClair = "Normandie";
        }
        if (a == 32) {
            this.regClair = "Hauts-de-France - Nord-Pas-de-Calais-Picardie";
        }
        if (a == 44) {
            this.regClair = "Grand Est";
        }
        if (a == 52) {
            this.regClair = "Pays de la Loire";
        }
        if (a == 53) {
            this.regClair = "Bretagne";
        }
        if (a == 75) {
            this.regClair = "Aquitaine-Limousin-Poitou-Charentes";
        }
        if (a == 76) {
            this.regClair = "Languedoc-Roussillon-Midi-Pyrénées";
        }
        if (a == 84) {
            this.regClair = "Auvergne-Rhône-Alpes";
        }
        if (a == 93) {
            this.regClair = "Provence-Alpes-Côte d Azur et Corse";
        }
        if (a == 99) {
            this.regClair = "Inconnu";
        }
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
