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
import javax.validation.constraints.Size;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Soins")
@NamedQueries({
    @NamedQuery(name = "Soins.findAll", query = "SELECT s FROM Soins s"),
    @NamedQuery(name = "Soins.findByIdSoins", query = "SELECT s FROM Soins s WHERE s.idSoins = :idSoins"),
    @NamedQuery(name = "Soins.findByDateDuJour", query = "SELECT s FROM Soins s WHERE s.dateDuJour = :dateDuJour"),
    @NamedQuery(name = "Soins.findByDesignation", query = "SELECT s FROM Soins s WHERE s.designation = :designation"),
    @NamedQuery(name = "Soins.findByTypeSoin", query = "SELECT s FROM Soins s WHERE s.typeSoin = :typeSoin")})
public class Soins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "IdSoins")
    private Long idSoins;
    @Column(name = "DateDuJour")
    @Temporal(TemporalType.DATE)
    private Date dateDuJour;
    @Size(max = 255)
    @Column(name = "Designation")
    private String designation;
    @Size(max = 255)
    @Column(name = "TypeSoin")
    private String typeSoin;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel materiel;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel personnel;

    public Soins() {
    }

    public Long getIdSoins() {
        return idSoins;
    }

    public void setIdSoins(Long idSoins) {
        this.idSoins = idSoins;
    }

    public Soins(Date dateDuJour, String designation, String typeSoin, Materiel materiel, Personnel personnel) {
        this.dateDuJour = dateDuJour;
        this.designation = designation;
        this.typeSoin = typeSoin;
        this.materiel = materiel;
        this.personnel = personnel;
    }


    public Date getDateDuJour() {
        return dateDuJour;
    }

    public void setDateDuJour(Date dateDuJour) {
        this.dateDuJour = dateDuJour;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getTypeSoin() {
        return typeSoin;
    }

    public void setTypeSoin(String typeSoin) {
        this.typeSoin = typeSoin;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSoins != null ? idSoins.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Soins)) {
            return false;
        }
        Soins other = (Soins) object;
        if ((this.idSoins == null && other.idSoins != null) || (this.idSoins != null && !this.idSoins.equals(other.idSoins))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ig.projet.apgpi.entities.Soins[ idSoins=" + idSoins + " ]";
    }
    
}
