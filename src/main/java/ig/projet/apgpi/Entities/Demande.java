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
import javax.persistence.TemporalType;

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Demande")
@NamedQueries({
    @NamedQuery(name = "Demande.findAll", query = "SELECT d FROM Demande d"),
    @NamedQuery(name = "Demande.findById", query = "SELECT d FROM Demande d WHERE d.id = :id"),
    @NamedQuery(name = "Demande.findByEspece", query = "SELECT d FROM Demande d WHERE d.espece = :espece"),
    @NamedQuery(name = "Demande.findByQte", query = "SELECT d FROM Demande d WHERE d.qte = :qte"),
    @NamedQuery(name = "Demande.findByServies", query = "SELECT d FROM Demande d WHERE d.servies = :servies"),
    @NamedQuery(name = "Demande.findByObservation", query = "SELECT d FROM Demande d WHERE d.observation = :observation")})
public class Demande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "Espece")
    private String espece;
    @Column(name = "Qte")
    private Long qte;
    @Column(name = "Servies")
    private Long servies;
    @Column(name = "Observation")
    private String observation;
     @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date dateDemande;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel personnel;
    
    @JoinColumn(nullable = true)
    @OneToOne
    private Affectation affectation;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel materiel;

    public Demande() {
    }

    public Demande(String espece, Long qte, Long servies, String observation, Date dateDemande, Personnel personnel, Materiel materiel) {
        this.espece = espece;
        this.qte = qte;
        this.servies = servies;
        this.observation = observation;
        this.dateDemande = dateDemande;
        this.personnel = personnel;
        this.materiel = materiel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
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
    
    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public Long getQte() {
        return qte;
    }

    public void setQte(Long qte) {
        this.qte = qte;
    }

    public Long getServies() {
        return servies;
    }

    public void setServies(Long servies) {
        this.servies = servies;
    }
    
    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
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
        if (!(object instanceof Demande)) {
            return false;
        }
        Demande other = (Demande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ig.projet.apgpi.Entities.Demande[ id=" + id + " ]";
    }
    
}
