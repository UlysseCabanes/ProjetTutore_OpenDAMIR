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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alex
 */
@Entity
@Table(name = "FICHIERSDAMIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichiersdamir.findAll", query = "SELECT f FROM Fichiersdamir f"),
    @NamedQuery(name = "Fichiersdamir.findByClefichier", query = "SELECT f FROM Fichiersdamir f WHERE f.clefichier = :clefichier"),
    @NamedQuery(name = "Fichiersdamir.findByUrlfichier", query = "SELECT f FROM Fichiersdamir f WHERE f.urlfichier = :urlfichier")})
public class Fichiersdamir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "CLEFICHIER")
    private String clefichier;
    @Size(max = 200)
    @Column(name = "URLFICHIER")
    private String urlfichier;

    public Fichiersdamir() {
    }

    public Fichiersdamir(String clefichier) {
        this.clefichier = clefichier;
    }

    public String getClefichier() {
        return clefichier;
    }

    public void setClefichier(String clefichier) {
        this.clefichier = clefichier;
    }

    public String getUrlfichier() {
        return urlfichier;
    }

    public void setUrlfichier(String urlfichier) {
        this.urlfichier = urlfichier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clefichier != null ? clefichier.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichiersdamir)) {
            return false;
        }
        Fichiersdamir other = (Fichiersdamir) object;
        if ((this.clefichier == null && other.clefichier != null) || (this.clefichier != null && !this.clefichier.equals(other.clefichier))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fichiersdamir[ clefichier=" + clefichier + " ]";
    }
    
}
