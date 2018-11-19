/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
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

/**
 *
 * @author lappa
 */
@Entity
@Table(name = "Evenement")
@NamedQueries({
    @NamedQuery(name = "Evenement.findAll", query = "SELECT e FROM Evenement e"),
    @NamedQuery(name = "Evenement.findById", query = "SELECT e FROM Evenement e WHERE e.id = :id"),
    @NamedQuery(name = "Evenement.findByNomEven", query = "SELECT e FROM Evenement e WHERE e.nomEven = :nomEven"),
    @NamedQuery(name = "Evenement.findByDateEven", query = "SELECT e FROM Evenement e WHERE e.dateEven = :dateEven"),
    @NamedQuery(name = "Evenement.findByNbreJour", query = "SELECT e FROM Evenement e WHERE e.nbreJour = :nbreJour")})
public class Evenement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Nom_Even")
    private String nomEven;
    @Column(name = "Date_Even")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEven;
    @Column(name = "Nbre_Jour")
    private Integer nbreJour;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel materiel;

    public Evenement() {
    }

    public Evenement(String nomEven, Date dateEven, Integer nbreJour, Materiel materiel) {
        this.nomEven = nomEven;
        this.dateEven = dateEven;
        this.nbreJour = nbreJour;
        this.materiel = materiel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getNomEven() {
        return nomEven;
    }

    public void setNomEven(String nomEven) {
        this.nomEven = nomEven;
    }

    public Date getDateEven() {
        return dateEven;
    }

    public void setDateEven(Date dateEven) {
        this.dateEven = dateEven;
    }

    public Integer getNbreJour() {
        return nbreJour;
    }

    public void setNbreJour(Integer nbreJour) {
        this.nbreJour = nbreJour;
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
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.df.Evenement[ id=" + id + " ]";
    }
    
}
