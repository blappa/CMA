/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author lappa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findById", query = "SELECT p FROM Personnel p WHERE p.id = :id"),
    @NamedQuery(name = "Personnel.findBySpecialite", query = "SELECT p FROM Personnel p WHERE p.specialite = :specialite"),
    @NamedQuery(name = "Personnel.findByNom", query = "SELECT p FROM Personnel p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnel.findByPrenom", query = "SELECT p FROM Personnel p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personnel.findByCni", query = "SELECT p FROM Personnel p WHERE p.cni = :cni")})
public class Personnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "CNI")
    private String cni;
    @Column(name = "Specialite")
    private String specialite;
    @Column(name = "Email")
    private String email;
//    @Column(name = "DatePriseService")
//    @Temporal(TemporalType.DATE)
//    private Date datePriseService;
   
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;
    
    
    @OneToOne(mappedBy="personnel")
    private Autorisation iDAutorisation;
    
    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private List<Materiel> materielList;
    
    @OneToMany(mappedBy = "personnel")
    private List<Demande> demandeList;

    @OneToMany(mappedBy = "iDPersonnel", cascade = CascadeType.ALL)
    private List<Consultation> consultations;
    
    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private List<Soins> soinses;
    
    @OneToMany(mappedBy = "iDPersonnel", cascade = CascadeType.ALL)
    private List<Affectation> affectations;
    
    @OneToMany(mappedBy = "personnel", cascade = CascadeType.ALL)
    private List<Reparation> reparations;
    
    public Personnel() {
    }

    

    public Personnel (String nom, String prenom, String cni, String specialite, Service service, String email){//, Date datePriseService) {
//        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cni = cni;
        this.specialite = specialite;
        this.service = service;
        this.email = email;
//        this.datePriseService = datePriseService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public Date getDatePriseService() {
//        return datePriseService;
//    }
//
//    public void setDatePriseService(Date datePriseService) {
//        this.datePriseService = datePriseService;
//    }

    public Autorisation getiDAutorisation() {
        return iDAutorisation;
    }

    public void setiDAutorisation(Autorisation iDAutorisation) {
        this.iDAutorisation = iDAutorisation;
    }

    public List<Materiel> getMaterielList() {
        return materielList;
    }

    public void setMaterielList(List<Materiel> materielList) {
        this.materielList = materielList;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Soins> getSoinses() {
        return soinses;
    }

    public void setSoinses(List<Soins> soinses) {
        this.soinses = soinses;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }

    public List<Reparation> getReparations() {
        return reparations;
    }

    public void setReparations(List<Reparation> reparations) {
        this.reparations = reparations;
    }

  
    @Override
    public String toString() {
        return nom+" "+prenom;
    }
    
}
