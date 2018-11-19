/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;

/**
 *
 * @author lappa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Materiel.findAll", query = "SELECT m FROM Materiel m"),
    @NamedQuery(name = "Materiel.findById", query = "SELECT m FROM Materiel m WHERE m.id = :id"),
    @NamedQuery(name = "Materiel.findByNomMateriel", query = "SELECT m FROM Materiel m WHERE m.nomMateriel = :nomMateriel"),
    @NamedQuery(name = "Materiel.findByMarquee", query = "SELECT m FROM Materiel m WHERE m.marquee = :marquee"),
    @NamedQuery(name = "Materiel.findByNumSerie", query = "SELECT m FROM Materiel m WHERE m.numSerie = :serie"),
    @NamedQuery(name = "Materiel.findByVersion", query = "SELECT m FROM Materiel m WHERE m.version = :version")
})
public class Materiel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nomMateriel")
    private String nomMateriel;
    @Column(name = "nomLogiciel")
    private String nomLogiciel;
    @Column(name = "nomFournisseur")
    private String nomFournisseur;
    @Column(name = "marquee")
    private String marquee;
    @Column(name = "type")
    private String type;
    @Column(name = "enStock")
    private String enStock;
    @Column(name = "AdresseIP")
    private String adresseIP;
    @Column(name = "numSerie")
    private String numSerie;
    @Column(name = "DateDebutGarantie")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutGarantie;
    @Column(name="DureeGarantie")
    private String dureeGarantie;
// champ pour le logiciel
    @Column(name="Licence")
    private String licence;
    @Column(name="Version")
    private String version;
    @Column(name="Editeur")
    private String editeur;
    @Column(name = "DateInstallation")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateInstallation;
    
    @OneToMany(mappedBy = "materiel")
    private List<Evenement> evenementList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiel")
     private List<Soins> soinses;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDMateriel")
     private List<Consultation> consultations;
    
    @OneToMany( mappedBy = "materiel")
     private List<Magazin> magazins;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDMateriel")
     private List<Panne> pannes;
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "materiel")
    private List<Reparation> reparationList;
    
     
    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Service service;
    
    @OneToMany(mappedBy = "iDMateriel", cascade = CascadeType.ALL)
    private List<Affectation> affectations;

    @JoinColumn(nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Personnel personnel;
    
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "materiel")
    private List<Demande> demandeList;

    public Materiel() {
    }

    public Materiel(String nomMateriel, String nomLogiciel, String nomFournisseur, String marquee, String type, String enStock, String adresseIP, String numSerie, Date dateDebutGarantie, String dureeGarantie, String licence, String version, String editeur, Date dateInstallation, Personnel personnel) {
        
        this.nomMateriel = nomMateriel;
        this.nomLogiciel = nomLogiciel;
        this.nomFournisseur = nomFournisseur;
        this.marquee = marquee;
        this.type = type;
        this.enStock = enStock;
        this.adresseIP = adresseIP;
        this.numSerie = numSerie;
        this.dateDebutGarantie = dateDebutGarantie;
        this.dureeGarantie = dureeGarantie;
        this.licence = licence;
        this.version = version;
        this.editeur = editeur;
        this.dateInstallation = dateInstallation;
        this.personnel = personnel;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdresseIP() {
        return adresseIP;
    }

    public void setAdresseIP(String adresseIP) {
        this.adresseIP = adresseIP;
    }

    public String getEnStock() {
        return enStock;
    }

    public void setEnStock(String enStock) {
        this.enStock = enStock;
    }

    public String getNomLogiciel() {
        return nomLogiciel;
    }

    public void setNomLogiciel(String nomLogiciel) {
        this.nomLogiciel = nomLogiciel;
    }
    
  
    public Date getDateDebutGarantie() {
        return dateDebutGarantie;
    }

    public void setDateDebutGarantie(Date dateDebutGarantie) {
        this.dateDebutGarantie = dateDebutGarantie;
    }

    public String getDureeGarantie() {
        return dureeGarantie;
    }

    public void setDureeGarantie(String dureeGarantie) {
        this.dureeGarantie = dureeGarantie;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

   
    public String getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel = nomMateriel;
    }

    public String getMarquee() {
        return marquee;
    }

    public void setMarquee(String marquee) {
        this.marquee = marquee;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public List<Soins> getSoinses() {
        return soinses;
    }

    public void setSoinses(List<Soins> soinses) {
        this.soinses = soinses;
    }

    public List<Magazin> getMagazins() {
        return magazins;
    }

    public List<Panne> getPannes() {
        return pannes;
    }

    public void setPannes(List<Panne> pannes) {
        this.pannes = pannes;
    }

    public List<Affectation> getAffectations() {
        return affectations;
    }

    public void setAffectations(List<Affectation> affectations) {
        this.affectations = affectations;
    }
    

    public void setMagazins(List<Magazin> magazins) {
        this.magazins = magazins;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
    
    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public List<Evenement> getEvenementList() {
        return evenementList;
    }

    public void setEvenementList(List<Evenement> evenementList) {
        this.evenementList = evenementList;
    }

    public List<Reparation> getReparationList() {
        return reparationList;
    }

    public void setReparationList(List<Reparation> reparationList) {
        this.reparationList = reparationList;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

   
    @Override
    public String toString() {
        return nomMateriel+" "+ marquee+" "+numSerie;
    }
    
}
