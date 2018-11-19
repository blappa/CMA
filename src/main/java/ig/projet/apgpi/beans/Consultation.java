/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.beans;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Affectation;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Evenement;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Panne;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Entities.Reparation;
import ig.projet.apgpi.Entities.Soins;
import ig.projet.apgpi.Service.IServiceAffectation;
import ig.projet.apgpi.Service.IServiceAutorisation;
import ig.projet.apgpi.Service.IServiceConsultation;
import ig.projet.apgpi.Service.IServiceEvenement;
import ig.projet.apgpi.Service.IServiceMagazin;
import ig.projet.apgpi.Service.IServiceMateriel;
import ig.projet.apgpi.Service.IServicePanne;
import ig.projet.apgpi.Service.IServicePersonnel;
import ig.projet.apgpi.Service.IServiceReparation;
import ig.projet.apgpi.Service.IServiceSoins;
import java.io.Serializable;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "mat")
@RequestScoped
public class Consultation implements Serializable {

    @ManagedProperty(value = "#{serviceConsultation}")
    private IServiceConsultation serviceCon;
    @ManagedProperty(value = "#{serviceAdmin}")
    private IServiceAutorisation servicead;
    @ManagedProperty(value = "#{serviceMateriel}")
    private IServiceMateriel serviceMat;
    @ManagedProperty(value = "#{servicePersonnel}")
    private IServicePersonnel personnelSer;
    @ManagedProperty(value = "#{serviceSoins}")
    private IServiceSoins serviceSoins;
    @ManagedProperty(value = "#{servicePanne}")
    private IServicePanne servicePan;
    @ManagedProperty(value = "#{serviceEven}")
    private IServiceEvenement serviceEven;
    @ManagedProperty(value = "#{serviceAffectation}")
    private IServiceAffectation serviceDemandeAffectation;
    @ManagedProperty(value = "#{serviceMagazin}")
    private IServiceMagazin serviceStock;
    @ManagedProperty(value = "#{serviceReparation}")
    private IServiceReparation serviceReparation;
    private ig.projet.apgpi.Entities.Consultation cons;
    private Affectation affectationdemand;
    private Materiel materiel;
    private Materiel logiciel;
    private Autorisation login;
    private Panne panne;
    private Reparation reparation;
    private Soins soins;
    private Evenement even;
    private Personnel personnel;
    private Magazin magazin;
    private Long idReparation;
    private Long idEven;
    private Long idSoins;
    private Long idPanne;
    private Long idMateriel;
    private Long idPer;
    private Long idStoc;
    private String cniPer;
    private List<Materiel> materielList;
    private List<Materiel> logicielList;
    private List<Soins> soinsList;
    private List<Reparation> reparationList;
    private List<Magazin> magazinList;
    private List<Evenement> evenementList;
    private List<ig.projet.apgpi.Entities.Consultation> consultationList;
    private List<Affectation> affectationdemandList;
    private List<Panne> panneList;
    private List<SelectItem> name;
    private String note;
    private int n = 0;
    private int qte;

    public Consultation() {
        cons = new ig.projet.apgpi.Entities.Consultation();
        affectationdemand = new Affectation();
        materiel = new Materiel();
        logiciel = new Materiel();
        login = new Autorisation();
        panne = new Panne();
        reparation = new Reparation();
        soins = new Soins();
        even = new Evenement();
        personnel = new Personnel();
        magazin = new Magazin();
    }

    public IServiceAutorisation getServicead() {
        return servicead;
    }

    public void setServicead(IServiceAutorisation servicead) {
        this.servicead = servicead;
    }

    public ig.projet.apgpi.Entities.Consultation getCons() {
        return cons;
    }

    public void setCons(ig.projet.apgpi.Entities.Consultation cons) {
        this.cons = cons;
    }

    public String savePanne(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        panne.setIDMateriel(m);
        servicePan.create(panne);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Panne enregistrement avec succés", ""));
        return "panne";
    }
    //

    public String updatePanne(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        Panne p = servicePan.findById(panne.getId());
        panne.setId(p.getId());
        panne.setIDMateriel(m);
        servicePan.update(panne);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour realisée avec succés", ""));
        return "panne";
    }

    public String validePanne(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        panne.setIDMateriel(m);
        servicePan.create(panne);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Panne validée avec succés\"", ""));
        return "panne";
    }

    public String deletePanne(ActionEvent actionEven) throws DataAccessException {
        Panne p = servicePan.findById(panne.getId());
        servicePan.deletePanne(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Panne supprimée avec succés", ""));
        return "panne";
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public Long getIdReparation() {
        return idReparation;
    }

    public void setIdReparation(Long idReparation) {
        this.idReparation = idReparation;
    }

    public Long getIdEven() {
        return idEven;
    }

    public void setIdEven(Long idEven) {
        this.idEven = idEven;
    }

    public Long getIdSoins() {
        return idSoins;
    }

    public void setIdSoins(Long idSoins) {
        this.idSoins = idSoins;
    }

    public Long getIdPanne() {
        return idPanne;
    }

    public void setIdPanne(Long idPanne) {
        this.idPanne = idPanne;
    }

    public Long getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Long idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Long getIdStoc() {
        return idStoc;
    }

    public void setIdStoc(Long idStoc) {
        this.idStoc = idStoc;
    }

    public IServicePersonnel getPersonnelSer() {
        return personnelSer;
    }

    public void setPersonnelSer(IServicePersonnel personnelSer) {
        this.personnelSer = personnelSer;
    }

    public Panne getPanne() throws DataAccessException {
        return panne;
    }

    public String getCniPer() {
        return cniPer;
    }

    public void setCniPer(String cniPer) {
        this.cniPer = cniPer;
    }

    public List<SelectItem> getName() {
        return name;
    }

    public void setName(List<SelectItem> name) {
        this.name = name;
    }

    public void setPanne(Panne panne) {
        this.panne = panne;
    }

    public IServicePanne getServicePan() {
        return servicePan;
    }

    public void setServicePan(IServicePanne servicePan) {
        this.servicePan = servicePan;
    }

    public List<Panne> getPanneList() {
        try {
            panneList = servicePan.findListePanne();
        } catch (DataAccessException ex) {
            Logger.getLogger(Materiel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return panneList;
    }

    public void setPanneList(List<Panne> panneList) {
        this.panneList = panneList;
    }

    public Soins getSoins() {
        return soins;
    }

    public void setSoins(Soins soins) {
        this.soins = soins;
    }

    public Long getIdPer() {
        return idPer;
    }

    public void setIdPer(Long idPer) {
        this.idPer = idPer;
    }

    public List<Soins> getSoinsList() {
        try {
            soinsList = serviceSoins.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(Materiel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return soinsList;
    }

    public void saveSoins(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Autorisation a = servicead.getAutorisationByLogin(name);
        soins.setPersonnel(a.getPersonnel());
        soins.setMateriel(m);
        soins = serviceSoins.createSoins(soins);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        // return "saveSoins";
    }

    public String updateSoins(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Autorisation a = servicead.getAutorisationByLogin(name);
        Soins s = serviceSoins.findById(soins.getIdSoins());
        soins.setPersonnel(a.getPersonnel());
        soins.setMateriel(m);
        soins.setIdSoins(s.getIdSoins());
        serviceSoins.updateSoins(soins);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour avec succés", ""));
        return "chargerMaintenance";
    }

    public String valideSoins(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Autorisation a = servicead.getAutorisationByLogin(name);
        soins.setPersonnel(a.getPersonnel());
        soins.setMateriel(m);
        serviceSoins.createSoins(soins);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "soins";
    }

    public String deleteSoins(ActionEvent actionEven) throws DataAccessException {
        Soins s = serviceSoins.findById(soins.getIdSoins());
        serviceSoins.deleteSoins(s.getIdSoins());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression realisée avec succés", ""));
        return "soins";
    }

    public IServiceSoins getServiceSoins() {
        return serviceSoins;
    }

    public void setServiceSoins(IServiceSoins serviceSoins) {
        this.serviceSoins = serviceSoins;
    }

    public void setSoinsList(List<Soins> soinsList) {
        this.soinsList = soinsList;
    }

    public List<ig.projet.apgpi.Entities.Consultation> getConsultationList() {
        try {
            consultationList = serviceCon.ListeConsultation();
        } catch (DataAccessException ex) {
            Logger.getLogger(Materiel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return consultationList;
    }

    public void setConsultationList(List<ig.projet.apgpi.Entities.Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    public void setServiceCon(IServiceConsultation serviceCon) {
        this.serviceCon = serviceCon;
    }

    public IServiceMateriel getServiceMat() {
        return serviceMat;
    }

    public void setServiceMat(IServiceMateriel serviceMat) {
        this.serviceMat = serviceMat;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Materiel getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(Materiel logiciel) {
        this.logiciel = logiciel;
    }

    public List<Materiel> getMaterielList() throws DataAccessException {

        List<Materiel> mats = new ArrayList<Materiel>();
        materielList = serviceMat.getAllMateriel();
        for (Materiel materiel1 : materielList) {
            if (!"NULL".equals(materiel1.getNomMateriel())) {
                mats.add(materiel1);
            }
        }
        return mats;
    }

    public List<Materiel> getLogicielList() throws DataAccessException {
        List<Materiel> logs = new ArrayList<Materiel>();
        logicielList = serviceMat.getAllMateriel();
        for (Materiel materiel1 : logicielList) {
            if (materiel1.getNomLogiciel() != null) {
                logs.add(materiel1);
            }
        }
        return logs;
    }

    public void setLogicielList(List<Materiel> logicielList) {
        this.logicielList = logicielList;
    }

    public void setMaterielList(List<Materiel> materielList) {
        this.materielList = materielList;
    }

    public IServiceEvenement getServiceEven() {
        return serviceEven;
    }

    public void setServiceEven(IServiceEvenement serviceEven) {
        this.serviceEven = serviceEven;
    }

    public Evenement getEven() {
        return even;
    }

    public void setEven(Evenement even) {
        this.even = even;
    }

    public List<Evenement> getEvenementList() throws DataAccessException {
        evenementList = serviceEven.findListeEvenement();
        return evenementList;
    }

    public void setEvenementList(List<Evenement> evenementList) {
        this.evenementList = evenementList;
    }

    public String saveEvenement(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        even.setMateriel(m);
        serviceEven.create(even);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "saveEvenement";
    }

    public String updateEvenement(ActionEvent actionEven) throws DataAccessException {
        Evenement e = serviceEven.findById(even.getId());
        serviceEven.update(e);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour effectuée", ""));
        return "chargerMaintenance";
    }

    public String valideEvenement(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        even.setMateriel(m);
        serviceEven.create(even);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "saveEvenement";
    }

    public String deleteEvenement(ActionEvent actionEven) throws DataAccessException {
        Evenement li = serviceEven.findById(idEven);
        serviceEven.delete(li);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression réalisée!", ""));
        return "deleteEvenement";
    }

    public Autorisation getLogin() {
        return login;
    }

    public void setLogin(Autorisation login) {
        this.login = login;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public IServiceAffectation getServiceDemandeAffectation() {
        return serviceDemandeAffectation;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public void setServiceDemandeAffectation(IServiceAffectation serviceDemandeAffectation) {
        this.serviceDemandeAffectation = serviceDemandeAffectation;
    }

    public Affectation getAffectationdemand() {
        return affectationdemand;
    }

    public void setAffectationdemand(Affectation affectationdemand) {
        this.affectationdemand = affectationdemand;
    }

    public List<Affectation> getAffectationdemandList() throws DataAccessException {
        try {
            affectationdemandList = serviceDemandeAffectation.FindAllAffectation();
        } catch (DataAccessException ex) {
            Logger.getLogger(Affectation.class.getName()).log(Level.SEVERE, null, ex);
            return affectationdemandList;
        }
        return affectationdemandList;
    }

    public void setAffectationdemandList(List<Affectation> affectationdemandList) {
        this.affectationdemandList = affectationdemandList;
    }

    public String saveConsultation() throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        cons.setIDMateriel(m);
        serviceCon.enregistrerConsultation(cons);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return null;
    }

    public String updateConsultation() throws DataAccessException {
        ig.projet.apgpi.Entities.Consultation c = serviceCon.findById(cons.getIdConsultation());
        Materiel m = serviceMat.getMaterielById(idMateriel);
        cons.setIDMateriel(m);
        cons.setIdConsultation(c.getIdConsultation());
        serviceCon.modifierConsultation(cons);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "mise à jour avec succées", ""));
        return null;
    }

    public String deleteConsultation() throws DataAccessException {
        ig.projet.apgpi.Entities.Consultation c = serviceCon.findById(cons.getIdConsultation());
        serviceCon.delete(c.getIdConsultation());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suppression avec succées", ""));
        return null;
    }

    public IServiceConsultation getServiceCon() {
        return serviceCon;
    }

    public List<ig.projet.apgpi.Entities.Consultation> ListeConsultation() throws DataAccessException {
        return serviceCon.ListeConsultation();
    }

    public String saveNewMateriel(ActionEvent actionEven) throws DataAccessException {

        List<Materiel> m = serviceMat.findListeMateriel();
        for (Materiel materiel1 : m) {
            if (materiel1.getNomMateriel().equals(materiel.getNomMateriel()) && materiel1.getNumSerie().equals(materiel.getNumSerie())) {      
                materiel.setId(materiel1.getId());
                serviceMat.update(materiel);
                magazin.setIdStock(materiel1.getId());
                magazin.setMateriel(materiel);
                serviceStock.update(magazin);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour avec succés", ""));
                return "saveMateriel";
            }
        }
        serviceMat.enregistrerNouveauMateriel(materiel);
        if (materiel.getEnStock().equals("OUI")) {
            magazin.setMateriel(materiel);
            serviceStock.create(magazin);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
            return "saveMateriel";
        }
        return null;
    }

    public String saveNewLogiciel(ActionEvent actionEven) throws DataAccessException {
        logiciel.setNomMateriel("NULL");
        serviceMat.enregistrerNouveauMateriel(logiciel);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));

        return "saveLogiciel";
    }

    public String updateMateriel(ActionEvent actionEven) throws DataAccessException {
        
        if (materiel.getNomMateriel() != null) {
            Materiel m = serviceMat.getMaterielById(materiel.getId());
            if (m != null) {
                materiel.setId(m.getId());
                Materiel ma = serviceMat.getMaterielById(materiel.getId());
                materiel.setId(ma.getId());
                serviceMat.update(materiel);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du materiel réalisée", ""));
                if (materiel.getEnStock().equals("OUI")) {
                    magazin.setIdStock(ma.getId());
                    magazin.setMateriel(materiel);
                    serviceStock.update(magazin);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour du stock réalisée", ""));
                }

            } else {
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matériel non modifié", ""));
            }
        } else {
            Materiel m = serviceMat.getMaterielById(logiciel.getId());
            if (m != null) {
                logiciel.setId(m.getId());
                //System.out.println("\n"+logiciel.getId()+"\n"+logiciel.getNomMateriel()+"\n"+logiciel.getDateDebutGarantie());
                serviceMat.update(logiciel);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logiciel mise à jour avec succés", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", ""));
            }
        }
        return null;
    }

    public String deleteMateriel(ActionEvent actionEven) throws DataAccessException {
        if (materiel.getNomMateriel() != null) {
            Materiel m = serviceMat.getMaterielById(materiel.getId());
            Magazin ma = serviceStock.findByMagazinId(m.getId());
            serviceStock.deletem(ma.getIdStock());
            serviceMat.delete(m);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression du matériel avec succés", ""));
            return "materiel";
        } else {
            Materiel l = serviceMat.getMaterielById(logiciel.getId());
            serviceMat.delete(l);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression du logiciel avec succés", ""));
            return "logiciel";
        }
    }

    public IServiceMagazin getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(IServiceMagazin serviceStock) {
        this.serviceStock = serviceStock;
    }

    public Magazin getMagazin() {
        return magazin;
    }

    public void setMagazin(Magazin magazin) {
        this.magazin = magazin;
    }

    public List<Magazin> getMagazinList() {
        try {
            magazinList = serviceStock.findListeMagazin();


        } catch (DataAccessException ex) {
            Logger.getLogger(Magazin.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        return magazinList;
    }

    public String saveNewStock(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        magazin.setMateriel(m);
        serviceStock.create(magazin);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "stock";
    }

    public String updateStock(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        magazin.setMateriel(m);
        Magazin mag = serviceStock.findByMagazinId(magazin.getIdStock());
        magazin.setIdStock(mag.getIdStock());
        serviceStock.update(magazin);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour réalisée", ""));
        return "stock";
    }

    public String deleteStock(ActionEvent actionEven) throws DataAccessException {
        Magazin m = serviceStock.findByMagazinId(magazin.getIdStock());
        serviceStock.deletem(m.getIdStock());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression réussit", ""));
        return "stock";

    }

    public void setMagazinList(List<Magazin> magazinList) {
        this.magazinList = magazinList;
    }

    public IServiceReparation getServiceReparation() {
        return serviceReparation;
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setServiceReparation(IServiceReparation serviceReparation) {
        this.serviceReparation = serviceReparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public void setReparationList(List<Reparation> reparationList) {
        this.reparationList = reparationList;
    }

    public List<Reparation> getReparationList() {
        try {
            reparationList = serviceReparation.findListeReparation();


        } catch (DataAccessException ex) {
            Logger.getLogger(Reparation.class
                    .getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        return reparationList;
    }

    public String saveNewReparation(ActionEvent actionEven) throws DataAccessException {
        Materiel m = serviceMat.getMaterielById(idMateriel);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Autorisation a = servicead.getAutorisationByLogin(name);
        reparation.setMateriel(m);
        reparation.setPersonnel(a.getPersonnel());
        serviceReparation.create(reparation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "chargerMaintenance";
    }

    public String updateReparation(ActionEvent actionEven) throws DataAccessException {
        Reparation r = serviceReparation.findById(reparation.getId());
        Materiel m = serviceMat.getMaterielById(idMateriel);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        Autorisation a = servicead.getAutorisationByLogin(name);
        reparation.setMateriel(m);
        reparation.setId(r.getId());
        serviceReparation.update(reparation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour réussit", ""));
        return "chargerMaintenance";
    }

    public String valideReparation(ActionEvent actionEven) throws DataAccessException {
        serviceReparation.create(reparation);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "saveReparation";
    }

    public String deleteReparation(ActionEvent actionEven) throws DataAccessException {
        Reparation re = serviceReparation.findById(reparation.getId());
        serviceReparation.delete(re);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Suppression avec succés", ""));
        return "deleteReparation";

    }

    public void deleteMaterielId(Materiel m, ActionEvent actionEven) {
        try {
            serviceMat.annulerEnregistrerNouveauMateriel(m);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        } catch (DataAccessException ex) {
            Logger.getLogger(Adminisration.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAffectation(ActionEvent actionEven) {
        try {
            serviceDemandeAffectation.DeleteAffectation(affectationdemand.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suppression avec succées", ""));
        } catch (DataAccessException ex) {
            Logger.getLogger(Adminisration.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteAllAffectation(ActionEvent actionEven) {
        try {
            affectationdemandList = serviceDemandeAffectation.FindAllAffectation();
            for (Affectation a : affectationdemandList) {
                serviceDemandeAffectation.DeleteAffectation(a.getId());
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "tout les affectations ont étè supprimées", ""));
        } catch (DataAccessException ex) {
            Logger.getLogger(Adminisration.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
