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
@Table(name = "Consultation")
@NamedQueries({
    @NamedQuery(name = "Consultation.findAll", query = "SELECT c FROM Consultation c"),
    @NamedQuery(name = "Consultation.findByIdConsultation", query = "SELECT c FROM Consultation c WHERE c.idConsultation = :idConsultation"),
    @NamedQuery(name = "Consultation.findByDate", query = "SELECT c FROM Consultation c WHERE c.date = :date"),
    @NamedQuery(name = "Consultation.findByDiagnostic", query = "SELECT c FROM Consultation c WHERE c.diagnostic = :diagnostic"),
    @NamedQuery(name = "Consultation.findByPrix", query = "SELECT c FROM Consultation c WHERE c.prix = :prix"),
    @NamedQuery(name = "Consultation.findByTraitement", query = "SELECT c FROM Consultation c WHERE c.traitement = :traitement")})
public class Consultation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdConsultation")
    private Long idConsultation;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "Diagnostic")
    private String diagnostic;
    @Column(name = "Prix")
    private Integer prix;
    @Column(name = "Traitement")
    private String traitement;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel iDMateriel;
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel iDPersonnel;

    public Consultation() {
    }

    public Consultation(Date date, String diagnostic, Integer prix, String traitement, Materiel iDMateriel, Personnel iDPersonnel) {
        this.date = date;
        this.diagnostic = diagnostic;
        this.prix = prix;
        this.traitement = traitement;
        this.iDMateriel = iDMateriel;
        this.iDPersonnel = iDPersonnel;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public Materiel getIDMateriel() {
        return iDMateriel;
    }

    public void setIDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
    }

    public Personnel getIDPersonnel() {
        return iDPersonnel;
    }

    public void setIDPersonnel(Personnel iDPersonnel) {
        this.iDPersonnel = iDPersonnel;
    }

    public Materiel getiDMateriel() {
        return iDMateriel;
    }

    public void setiDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
    }

    public Personnel getiDPersonnel() {
        return iDPersonnel;
    }

    public void setiDPersonnel(Personnel iDPersonnel) {
        this.iDPersonnel = iDPersonnel;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultation != null ? idConsultation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultation)) {
            return false;
        }
        Consultation other = (Consultation) object;
        if ((this.idConsultation == null && other.idConsultation != null) || (this.idConsultation != null && !this.idConsultation.equals(other.idConsultation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ig.projet.apgpi.Entities.Consultation[ idConsultation=" + idConsultation + " ]";
    }
    
}
