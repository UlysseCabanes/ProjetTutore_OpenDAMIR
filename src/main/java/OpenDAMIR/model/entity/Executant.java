/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpenDAMIR.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ulyss
 */
@Entity
@Table(name = "EXECUTANT")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Executant.findAll", query = "SELECT c FROM Executant c"),
})
public class Executant implements Serializable{
    
}
