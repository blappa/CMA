/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.beans;

import com.douwe.generic.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import ig.projet.apgpi.Entities.Affectation;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Entities.Service;
import ig.projet.apgpi.Service.IServiceAffectation;
import ig.projet.apgpi.Service.IServiceAutorisation;
import ig.projet.apgpi.Service.IServiceDemande;
import ig.projet.apgpi.Service.IServiceMagazin;
import ig.projet.apgpi.Service.IServiceMateriel;
import ig.projet.apgpi.Service.IServicePersonnel;
import ig.projet.apgpi.Service.IServiceService;
import java.io.File;
import java.io.Serializable;
import javax.faces.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "root")
@RequestScoped
@Controller
public class Adminisration implements Serializable {

    @ManagedProperty(value = "#{serviceAdmin}")
    private IServiceAutorisation administration;
    @ManagedProperty(value = "#{servicePersonnel}")
    private IServicePersonnel personnelSer;
    @ManagedProperty(value = "#{serviceMateriel}")
    private IServiceMateriel serviceMat;
    @ManagedProperty(value = "#{serviceAffectation}")
    private IServiceAffectation affectationSelect;
    @ManagedProperty(value = "#{serviceAffectation}")
    private IServiceAffectation serviceDemandeAffectation;
    @ManagedProperty(value = "#{serviceService}")
    private IServiceService serviceSer;
    @ManagedProperty(value = "#{serviceDemande}")
    private IServiceDemande serviceDeman;
    @ManagedProperty(value = "#{serviceMagazin}")
    private IServiceMagazin serviceStock;
    private Affectation affectation;
    private Autorisation nlogin;
    private Autorisation per;
    private Personnel personnel;
    private Materiel materiel;
    private Service ser;
    private Demande dem;
    private Demande demande;
    private Affectation affectationdemand;
    private List<SelectItem> personnelListItems;
    private List<Personnel> personnelList;
    private List<Service> serviceList;
    private List<Demande> demandeList;
    private List<Demande> demandeTotal;
    
    private List<Affectation> affectationList;
    private List<Personnel> personnelSelect = new ArrayList<Personnel>();
    private List<Materiel> materielList;
    private List<Autorisation> listAutorisations;
    private String pwd;
    private String username;
    private String username_n;
    private String groupe;
    private String status;
    private Long idPersonnel;
    private Long idDem;
    private Long idService;
    private Long idMateriel;
    private String sigleService;
    private String cniPer;
    private SelectItem[] lisServ;
    private Long qte;
    private Long qteMin = 1L;
    ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    private File file = new File(servletContext.getRealPath("") + File.separator + "personnel" + File.separator + "images" + File.separator + "tmp.png");

    public Adminisration() {
        affectation = new Affectation();
        per = new Autorisation();
        personnel = new Personnel();
        nlogin = new Autorisation();
        ser = new Service();
        dem = new Demande();
        demande = new Demande();
        materiel = new Materiel();
        affectationdemand = new Affectation();
    }

    public String init(ActionEvent actionEvent) throws DataAccessException {
        personnelList = personnelSer.findListPersonnel();
        if (personnelList.isEmpty()) {
            Service se = new Service("informatique", "INFO");
            serviceSer.createService(se);
            Personnel p = new Personnel("super", "user", null, null, se, null);
            personnelSer.SavePersonnel(p);
            Autorisation a = new Autorisation(p, "admin", "admin", "ROLE_ADMIN", true);
            administration.enregistrerNouveauLogin(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Un compte par defaut s'est crée avec: \n\t\t LOGIN : admin \n\t\t MOT DE PASSE: admin", ""));
            return "compte";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Un compte existe déja", ""));
            return "compte";
        }
    }

    public IServiceAutorisation getAdministration() {
        return administration;
    }

    public void setAdministration(IServiceAutorisation administration) {
        this.administration = administration;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public IServiceAffectation getAffectationSelect() {
        return affectationSelect;
    }

    public void setAffectationSelect(IServiceAffectation affectationSelect) {
        this.affectationSelect = affectationSelect;
    }

    public String newPersonnel(ActionEvent actionEven) throws DataAccessException {
        Service se = serviceSer.findServiceBySigle(sigleService);
        personnel.setService(se);
        personnelSer.SavePersonnel(personnel);
        nlogin = new Autorisation(personnel, pwd, username, groupe, true);
        administration.enregistrerNouveauLogin(nlogin);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
        return "savePersonnel";
    }

    public String updatePersonnel(ActionEvent actionEven) throws DataAccessException {
        Service se = serviceSer.findServiceBySigle(sigleService);
        Personnel pe = personnelSer.findPersonnelById(personnel.getId());
        personnel.setService(se);
        personnel.setId(pe.getId());
        personnelSer.UpdatePersonnel(personnel);
        Autorisation a = administration.getAutorisationById(personnel.getId());
        nlogin = new Autorisation(personnel, pwd, username, groupe, true);
        nlogin.setIdLogin(a.getIdLogin());
        administration.update(nlogin);
//          if (file != null) {
//            File filedest = new File(servletContext.getRealPath("") + File.separator + "photos" + File.separator + personnel.getId() + ".png");
//            file.renameTo(filedest);
//        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, personnel.getNom() + " " + personnel.getPrenom() + " mise à jour avec succées", ""));
        return "savePersonnel";
    }

    public String newAffectation(ActionEvent actionEven) throws DataAccessException {
        try {
            affectationSelect.SaveAffectation(affectation);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Materiel affecté avec succés", ""));
        } catch (DataAccessException ex) {
            return "newAffectationECHEC";
            //Logger.getLogger(Adminisration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "saveAffectation";
    }

    public String newService(ActionEvent actionEven) throws DataAccessException {
//        try {
        serviceSer.createService(ser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Enregistrement du service avec succés", ""));
        return "saveService";
    }

    public String updateService(ActionEvent actionEven) throws DataAccessException {
//      
        Service se = serviceSer.findById(ser.getId());
        ser.setId(se.getId());
        serviceSer.updateService(ser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mise à jour avec succés", ""));
        return "saveService";
    }

    public String valideService(ActionEvent actionEven) throws DataAccessException {
        serviceSer.createService(ser);
        return "saveService";
    }

    public String deleteService(ActionEvent actionEven) {
        Service se;
        try {
            se = serviceSer.findById(ser.getId());
            serviceSer.deleteService(se.getId());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, se.getNomService() + " Service supprimé", ""));
        } catch (DataAccessException ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Service non supprimé", "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        return "deleteService";

    }

    public String newDemande(ActionEvent actionEven) throws DataAccessException {
        try {
            Date d=new Date();
            Materiel m = serviceMat.getMaterielById(idMateriel);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            username = user.getUsername();
            Autorisation au = administration.getAutorisationByLogin(username);
            cniPer = au.getPersonnel().getCni();
            Personnel p = personnelSer.findPersonnelByCNI(cniPer);
            demande.setMateriel(m);
            demande.setPersonnel(p);
            List<Demande> demandes = serviceDeman.FindListDemane();

            for (Demande demande1 : demandes) {
                if (demande1.getMateriel().getNumSerie().equals(m.getNumSerie())) {
                    serviceDeman.updateDemande(demande);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Demande effectuée avec succés \n\n date: "+d, ""));
                    return "saveDemande";
                }
            }
            serviceDeman.SaveDemande(demande);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Demande effectuée avec succés", ""));
        } catch (DataAccessException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Echec demande", ""));
            return "newDemandeEchec";
        }
        return "saveDemande";
    }

    public String updateDemande(ActionEvent actionEven) throws DataAccessException {
        try {
            Materiel m = serviceMat.getMaterielById(idMateriel);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            username = user.getUsername();
            Autorisation au = administration.getAutorisationByLogin(username);
            cniPer = au.getPersonnel().getCni();
            Personnel p = personnelSer.findPersonnelByCNI(cniPer);
            Demande d = serviceDeman.FindById(demande.getId());
            demande.setMateriel(m);
            demande.setPersonnel(p);
            demande.setId(d.getId());
            demande.setServies(d.getServies());
            serviceDeman.updateDemande(demande);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Demande modifiée avec succés", ""));
        } catch (DataAccessException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Modification non effectuée", ""));
            return "newDemandeEchec";
        }
        return null;//"saveDemande";
    }

    public String valideDemande(ActionEvent actionEven) throws DataAccessException {
        Demande d = serviceDeman.FindById(demande.getId());
        int tm = 0;
        d.setServies(demande.getServies());

        List<Magazin> m = serviceStock.findListeMagazin();

        for (Magazin magazin : m) {
            if (magazin.getIdStock().equals(d.getMateriel().getId())) {
                if (demande.getServies() <= magazin.getStock()) {
                    qte = magazin.getStock() - demande.getServies();
                    magazin.setStock(qte);
                    magazin.setIdStock(magazin.getIdStock());
                    magazin.setMateriel(d.getMateriel());
//            if(qte>qteMin){
                    serviceStock.update(magazin);
                    serviceDeman.updateDemande(d);
                    Materiel m1 = serviceMat.getMaterielById(d.getMateriel().getId());
                    Personnel p = personnelSer.findPersonnelById(d.getPersonnel().getId());
                    affectationdemand.setDemande(d);
                    affectationdemand.setIDMateriel(m1);
                    affectationdemand.setIDPersonnel(p);
                    List<Affectation> lista = serviceDemandeAffectation.FindAllAffectation();
                    for (Affectation affectation1 : lista) {
                        if (affectation1.getDemande().getId().equals(demande.getId())) {
                            tm = 1;
                        }
                    }
                    if (tm == 0) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "enregistrement avec succées", ""));
                        affectationdemand = serviceDemandeAffectation.SaveAffectation(affectationdemand);
                    } else {
                        serviceDemandeAffectation.updateAffectation(affectationdemand);
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Quantité validé", ""));
                    }
                    return "superUser";
//            }
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "quantité non valide, le stock ne permet pas!", ""));
                    return "superUser";
                }
            }
        }
//            affectationdemand.setDateAffec(null);
//            affectationdemand.setId(serviceDemandeAffectation.FindAllAffectation().size() + 1);
//            affectationdemand = serviceDemandeAffectation.SaveAffectation(affectationdemand);
        return "superUser";
    }

    public int estProche(Demande v) {
        Calendar c = Calendar.getInstance();
        c.setTime(v.getDateDemande());
        c.add(Calendar.DATE, 7);
        Calendar today = Calendar.getInstance();
        if (today.after(c)) {
            return 2;
        } else {
            today.add(Calendar.DATE, 5);
            if (today.after(c)) {
                return 1;
            }
            return 0;
        }
    }

    public String couleur(Demande v) {
        if (estProche(v) == 1) {
            return "couleur1";
        }
        if (estProche(v) == 2) {
            return "couleur2";
        }
        return null;
    }

    public Affectation getAffectationdemand() {
        return affectationdemand;
    }

    public void setAffectationdemand(Affectation affectationdemand) {
        this.affectationdemand = affectationdemand;
    }

    public IServiceAffectation getServiceDemandeAffectation() {
        return serviceDemandeAffectation;
    }

    public void setServiceDemandeAffectation(IServiceAffectation serviceDemandeAffectation) {
        this.serviceDemandeAffectation = serviceDemandeAffectation;
    }

    public IServiceMagazin getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(IServiceMagazin serviceStock) {
        this.serviceStock = serviceStock;
    }

    public String alerte() throws DataAccessException {

        demandeList = serviceDeman.FindListDemane();
        if (!demandeList.isEmpty()) {
            return "alerte";
        }
        return null;
    }

    public IServicePersonnel getPersonnelSer() {
        return personnelSer;
    }

    public void setPersonnelSer(IServicePersonnel personnelSer) {
        this.personnelSer = personnelSer;
    }

    public IServiceDemande getServiceDeman() {
        return serviceDeman;
    }

    public void setServiceDeman(IServiceDemande serviceDeman) {
        this.serviceDeman = serviceDeman;
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Demande getDem() {
        return dem;
    }

    public void setDem(Demande dem) {
        this.dem = dem;
    }

    public IServiceService getServiceSer() {
        return serviceSer;
    }

    public void setServiceSer(IServiceService serviceSer) {
        this.serviceSer = serviceSer;
    }

    public Service getSer() {
        return ser;
    }

    public void setSer(Service ser) {
        this.ser = ser;
    }

    public String getSigleService() {
        return sigleService;
    }

    public void setSigleService(String sigleService) {
        this.sigleService = sigleService;
    }

    public String changeLogin(ActionEvent actionEven) {
        try {
            nlogin = administration.getAutorisationByLogin(username_n);
            nlogin.setUsername(username);
            nlogin.setPassword(pwd);
            administration.update(nlogin);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, username + " votre login à étè modifié avec succés", ""));
        } catch (DataAccessException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Erreur modification de login", ""));
            return "changeLoginEchec";
        }
        return "changeLoginOK";
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public Long getIdDem() {
        return idDem;
    }

    public void setIdDem(Long idDem) {
        this.idDem = idDem;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public Long getQte() {
        return qte;
    }

    public void setQte(Long qte) {
        this.qte = qte;
    }

    public Long getQteMin() {
        return qteMin;
    }

    public void setQteMin(Long qteMin) {
        this.qteMin = qteMin;
    }

    public Autorisation getNlogin() {
        return nlogin;
    }

    public void setNlogin(Autorisation nlogin) {
        this.nlogin = nlogin;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SelectItem[] getLisServ() {
        return lisServ;
    }

    public void setLisServ(SelectItem[] lisServ) {
        this.lisServ = lisServ;
    }

    public Long getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(Long idMateriel) {
        this.idMateriel = idMateriel;
    }

    public String getCniPer() {
        return cniPer;
    }

    public void setCniPer(String cniPer) {
        this.cniPer = cniPer;
    }

    public List<Personnel> getPersonnelSelect() {
        return personnelSelect;
    }

    public void setPersonnelSelect(List<Personnel> personnelSelect) {
        this.personnelSelect = personnelSelect;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername_n() {
        return username_n;
    }

    public void setUsername_n(String username_n) {
        this.username_n = username_n;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Demande> getDemandeTotal() throws DataAccessException{
        int t = 0;
        demandeTotal = serviceDeman.FindListDemane();
        affectationList = serviceDemandeAffectation.FindAllAffectation();
        List<Demande> list = new ArrayList<Demande>();
        for (Demande demande1 : demandeTotal) {
            for (Affectation affectat : affectationList) {
                if (affectat.getiDMateriel().getId().equals(demande1.getMateriel().getId()) && affectat.getDemande().getId().equals(demande1.getId())) {
                    t = 1;
                }
            }
            if (t == 0) {
                 list.add(demande1);
            }
            t = 0;
        }
        return  list;
    }

    public void setDemandeTotal(List<Demande> demandeTotal) {
        this.demandeTotal = demandeTotal;
    }
    
    public List<Personnel> getPersonnelList() throws DataAccessException {

        personnelList = this.administration.getAllPersonnel();

//            serviceList = serviceSer.findListeService();
//             
        for (Personnel perso : personnelList) {
//                for (Service serv : serviceList) {
//                    if (perso.getService().equals(serv)) {
//                        System.out.println("\n\nbon\n\n");
//                    }
//                }
            //  System.out.println("\n"+perso.getService().getNomService());
        }
//            

        return personnelList;
    }

    public List<Autorisation> getListAutorisations() throws DataAccessException {
        listAutorisations = administration.getAutorisation();
        return listAutorisations;
    }

    public List<Service> getServiceList() throws DataAccessException {
        try {
            serviceList = serviceSer.findListeService();
        } catch (DataAccessException ex) {
            return null;
        }
        return serviceList;
    }

    public List<Demande> getDemandeList() throws DataAccessException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        username = user.getUsername();
        Autorisation au = administration.getAutorisationByLogin(username);
        cniPer = au.getPersonnel().getCni();
        demandeList = serviceDeman.FindListDemane();
        List<Demande> list = new ArrayList<Demande>();
        for (Demande demande1 : demandeList) {
            if (demande1.getPersonnel().getCni().equals(cniPer)) {
                list.add(demande1);
            }
        }
        return list;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    public List<SelectItem> getpersonnelListItems() {
        try {
            personnelList = administration.getAllPersonnel();
            personnelListItems = new ArrayList<SelectItem>();
            for (Personnel p : personnelList) {
                personnelListItems.add(new SelectItem(p, p.getNom()));

            }
            return personnelListItems;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public void setPersonnelListItems(List<SelectItem> personnelListItems) {
        this.personnelListItems = personnelListItems;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    public List<Personnel> allPersonnel() {
        try {
            return administration.getAllPersonnel();
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public String deletePersonnelId(ActionEvent actionEven) throws DataAccessException {
        Personnel p = administration.getPersonnelById(personnel.getId());
        administration.annulerEnregistrementPersonnel(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suppression realisée avec succés", ""));
        return "deletePersonnel";
    }

    public String addTypeAffectation(ActionEvent actionEven) {
        try {
            administration.enregistrerAffectation(affectation);
            affectation = new Affectation();
        } catch (DataAccessException ex) {
            Logger.getLogger(Adminisration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setAffectationList(List<Affectation> affectationList) {
        this.affectationList = affectationList;
    }

    public List<Affectation> getAffectationList() {
        try {
            affectationList = new ArrayList<Affectation>();
            affectationList = administration.FindAllAffectation();
        } catch (DataAccessException ex) {
            Logger.getLogger(Adminisration.class.getName()).log(Level.SEVERE, null, ex);

        }
        return affectationList;
    }

    public List<Materiel> getMaterielList() throws DataAccessException {
        try {
            materielList = serviceMat.getAllMateriel();
        } catch (DataAccessException ex) {
            Logger.getLogger(Materiel.class.getName()).log(Level.SEVERE, null, ex);
            return materielList;
        }
        return materielList;
    }

    public IServiceMateriel getServiceMat() {
        return serviceMat;
    }

    public void setServiceMat(IServiceMateriel serviceMat) {
        this.serviceMat = serviceMat;
    }

    public Autorisation getPer() {
        return per;
    }

    public void setPer(Autorisation per) {
        this.per = per;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String deleteDemande(ActionEvent actionEven) {
        try {
            Demande d = serviceDeman.FindById(demande.getId());
            serviceDeman.deleteDemande(d);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "suppression avec succés", ""));
        } catch (DataAccessException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Erreur de la suppression", ""));
            return "saveDemande";
        }
        return "saveDemande";
    }

    public List<String> allNom() {
        try {
            List<String> result = new ArrayList<String>();
            List<Personnel> p = administration.getAllPersonnel();
            for (Personnel per : p) {
                if (!result.contains(per.getNom())) {
                    result.add(per.getNom());
                }
            }
            return result;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public List<String> allPrenom() {
        try {
            List<String> result = new ArrayList<String>();
            List<Personnel> p = administration.getAllPersonnel();
            for (Personnel per : p) {
                if (!result.contains(per.getPrenom())) {
                    result.add(per.getPrenom());
                }
            }
            return result;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    public Boolean statusCompte(String v) {
        if ("1".equals(v)) {
            return true;
        } else {
            return false;
        }
    }

    public String modifierCompte(ActionEvent actionEven) throws DataAccessException {
        try {
            Autorisation a = administration.getAutorisationById(nlogin.getIdLogin());
            a.setAnabled(statusCompte(status));
            administration.update(a);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Compte  modifié avec succés", ""));
        } catch (DataIntegrityViolationException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la modification du compte", ""));
            return "newLoginEchec";
        }
        return "newLoginOK";
    }
}
