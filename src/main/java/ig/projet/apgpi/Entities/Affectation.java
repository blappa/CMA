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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Affectation")
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a"),
    @NamedQuery(name = "Affectation.findById", query = "SELECT a FROM Affectation a WHERE a.id = :id")})
public class Affectation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name="DateAffect")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date DateAffec;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel iDPersonnel;
    
    @JoinColumn(nullable = true)
    @OneToOne
    private Demande demande;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel iDMateriel;

    public Affectation() {
    }

    public Affectation(Long id, Date DateAffec, Personnel iDPersonnel, Materiel iDMateriel, Demande demande) {
        this.id = id;
        this.DateAffec = DateAffec;
        this.iDPersonnel = iDPersonnel;
        this.iDMateriel = iDMateriel;
        this.demande=demande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personnel getiDPersonnel() {
        return iDPersonnel;
    }

    public void setiDPersonnel(Personnel iDPersonnel) {
        this.iDPersonnel = iDPersonnel;
    }

    public Materiel getiDMateriel() {
        return iDMateriel;
    }

    public void setiDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
    }
  
    public Personnel getIDPersonnel() {
        return iDPersonnel;
    }

    public void setIDPersonnel(Personnel iDPersonnel) {
        this.iDPersonnel = iDPersonnel;
    }

    public Materiel getIDMateriel() {
        return iDMateriel;
    }

    public void setIDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
    }

    public Date getDateAffec() {
        return DateAffec;
    }

    public void setDateAffec(Date DateAffec) {
        this.DateAffec = DateAffec;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
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
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.p.Affectation[ id=" + id + " ]";
    }
    
}
