/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name = "Panne")
@NamedQueries({
    @NamedQuery(name = "Panne.findAll", query = "SELECT p FROM Panne p"),
    @NamedQuery(name = "Panne.findById", query = "SELECT p FROM Panne p WHERE p.id = :id"),
    @NamedQuery(name = "Panne.findByNomPanne", query = "SELECT p FROM Panne p WHERE p.nomPanne = :nomPanne"),
    @NamedQuery(name = "Panne.findByCode", query = "SELECT p FROM Panne p WHERE p.code = :code"),
    @NamedQuery(name = "Panne.findByDescription", query = "SELECT p FROM Panne p WHERE p.description = :description"),
    @NamedQuery(name = "Panne.findByDatePanne", query = "SELECT p FROM Panne p WHERE p.datePanne = :datePanne")})
public class Panne implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "NomPanne")
    private String nomPanne;
    @Column(name = "Description")
    private String description;
    @Column(name = "DatePanne")
    @Temporal(TemporalType.DATE)
    private Date datePanne;
    @Column(name = "Code")
    private String code;
    
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Materiel iDMateriel;

    public Panne() {
    }

    public Panne(String nomPanne, String description, Date datePanne, String code) {
        this.nomPanne = nomPanne;
        this.description = description;
        this.datePanne = datePanne;
        this.code = code;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNomPanne() {
        return nomPanne;
    }

    public void setNomPanne(String nomPanne) {
        this.nomPanne = nomPanne;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePanne() {
        return datePanne;
    }

    public void setDatePanne(Date datePanne) {
        this.datePanne = datePanne;
    }

    public Materiel getiDMateriel() {
        return iDMateriel;
    }

    public void setiDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Materiel getIDMateriel() {
        return iDMateriel;
    }

    public void setIDMateriel(Materiel iDMateriel) {
        this.iDMateriel = iDMateriel;
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
        if (!(object instanceof Panne)) {
            return false;
        }
        Panne other = (Panne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.df.Panne[ id=" + id + " ]";
    }
    
}
