/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ulyss
 */
@Entity
@Table(name = "DATE_TRAITEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DateTraitement.findAll", query = "SELECT d FROM DateTraitement d"),
    @NamedQuery(name = "DateTraitement.findByIddate", query = "SELECT d FROM DateTraitement d WHERE d.iddate = :iddate"),
    @NamedQuery(name = "DateTraitement.findByFlxAnnMoi", query = "SELECT d FROM DateTraitement d WHERE d.flxAnnMoi = :flxAnnMoi")})
public class DateTraitement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDATE")
    private Integer iddate;
    @Column(name = "FLX_ANN_MOI")
    @Temporal(TemporalType.DATE)
    private Date flxAnnMoi;
    @JoinColumn(name = "IDDATE", referencedColumnName = "IDPRESTATION", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Prestation prestation;

    public DateTraitement() {
    }

    public DateTraitement(Integer iddate) {
        this.iddate = iddate;
    }

    public Integer getIddate() {
        return iddate;
    }

    public void setIddate(Integer iddate) {
        this.iddate = iddate;
    }

    public Date getFlxAnnMoi() {
        return flxAnnMoi;
    }

    public void setFlxAnnMoi(Date flxAnnMoi) {
        this.flxAnnMoi = flxAnnMoi;
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
        hash += (iddate != null ? iddate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DateTraitement)) {
            return false;
        }
        DateTraitement other = (DateTraitement) object;
        if ((this.iddate == null && other.iddate != null) || (this.iddate != null && !this.iddate.equals(other.iddate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DateTraitement[ iddate=" + iddate + " ]";
    }
    
}
