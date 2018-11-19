/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Magazin")
@NamedQueries({
    @NamedQuery(name = "Magazin.findAll", query = "SELECT e FROM Magazin e"),
    @NamedQuery(name = "Magazin.findByIdStock", query = "SELECT e FROM Magazin e WHERE e.idStock = :id")})
public class Magazin implements Serializable {
  
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "idStock")
    private Long idStock;
    
    @Column(name = "Peremtion")
    @Temporal(TemporalType.DATE)
    private Date peremtion; 
    @Column(name = "quantite")
    private Long stock;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel materiel;

    public Magazin() {
    }

    public Magazin(Date peremtion, Long stock, Materiel materiel) {
        this.peremtion = peremtion;
        this.stock = stock;
        this.materiel = materiel;
    }

    public Long getIdStock() {
        return idStock;
    }

    public void setIdStock(Long idStock) {
        this.idStock = idStock;
    }

    public Date getPeremtion() {
        return peremtion;
    }

    public void setPeremtion(Date peremtion) {
        this.peremtion = peremtion;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    @Override
    public String toString() {
        return "Magazin{" + "idStock=" + idStock + ", peremtion=" + peremtion + ", stock=" + stock + ", materiel=" + materiel + '}';
    }

    
}
