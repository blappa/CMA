/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "Reparation")
@NamedQueries({
    @NamedQuery(name = "Reparation.findAll", query = "SELECT r FROM Reparation r"),
    @NamedQuery(name = "Reparation.findById", query = "SELECT r FROM Reparation r WHERE r.id = :id"),
    @NamedQuery(name = "Reparation.findByDescription", query = "SELECT r FROM Reparation r WHERE r.description = :description"),
    @NamedQuery(name = "Reparation.findByDate", query = "SELECT r FROM Reparation r WHERE r.dateReparation = :date")})
public class Reparation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "DateReparation")
    @Temporal(TemporalType.DATE)
    private Date dateReparation;
  
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel materiel;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel personnel;
   
    public Reparation() {
    }

    public Reparation(String description, Date dateReparation, Materiel materiel, Personnel personnel) {
        this.description = description;
        this.dateReparation = dateReparation;
        this.materiel = materiel;
        this.personnel = personnel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateReparation() {
        return dateReparation;
    }

    public void setDateReparation(Date dateReparation) {
        this.dateReparation = dateReparation;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

   

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reparation)) {
            return false;
        }
        Reparation other = (Reparation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ig.projet.apgpi.Entities.Reparation[ id=" + id + " ]";
    }
    
}
