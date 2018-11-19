/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.beans;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Service.IServiceAutorisation;
import ig.projet.apgpi.Service.IServicePersonnel;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "admin")
@RequestScoped
public class Authentification implements Serializable {
    
    @ManagedProperty(value = "#{serviceAdmin}")
    private IServiceAutorisation administration;
    @ManagedProperty(value = "#{servicePersonnel}")
    private IServicePersonnel servicePer;
    
    private Autorisation auto;
    private Personnel currentUser;
    
    private List<Personnel> superUtilisateurList;
    private List<Autorisation> loginList;
    private List<Personnel> personnelList;
    private int counter;

    public Authentification() {
        auto=new Autorisation();
        currentUser = new Personnel();
    }

    public List<Personnel> getAllPersonnel() {
        try {
            return administration.getAllPersonnel();
        } catch (DataAccessException ex) {
            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public IServiceAutorisation getAdministration() {
        return administration;
    }

    public void setAdministration(IServiceAutorisation administration) {
        this.administration = administration;
    }

//    public List<Personnel> getSuperUtilisateurList() {
//        try {
//            List<Personnel> cc;
//            cc = administration.getAllPersonnel();
//            superUtilisateurList = new ArrayList<Personnel>();
//            for (Personnel personne : cc) {
//                if (personne.getSpecialite().equals("SUPER USER")) {
//                    superUtilisateurList.add(personne);
//                }
//                if (personne.getSpecialite().equals("COMPTABLE MATIERE")) {
//                    superUtilisateurList.add(personne);
//                }
//                if (personne.getSpecialite().equals("CHARGER MAINTENANCE")) {
//                    superUtilisateurList.add(personne);
//                }
//                if (personne.getSpecialite().equals("PERSONNEL CNDT")) {
//                    superUtilisateurList.add(personne);
//                }
//            }
//            return superUtilisateurList;
//        } catch (DataAccessException ex) {
//            Logger.getLogger(Personnel.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    public void setSuperUtilisateurList(List<Personnel> superUtilisateurList) {
        this.superUtilisateurList = superUtilisateurList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    public List<Personnel> getPersonnelList() throws DataAccessException {
        personnelList = administration.getAllPersonnel();
        return personnelList;
    }

//    public String login() throws DataAccessException {
//
//        loginList = administration.getAutorisation();
//
//        personnelList = administration.getAllPersonnel();//findBySpecialite(auto.getLogin());
//        for (Personnel personnel : superUtilisateurList) {
//            if (personnel.getSpecialite().equals(auto.getLogin())) {
//                //for (Autorisation l : loginList) {
//                    if (personnel.getiDAutorisation().getPwd().equals(auto.getPwd())) {
//                        if (personnel.getSpecialite().equals("SUPER USER")){
//                            return "superUser";
//                        }
//                        if (personnel.getSpecialite().equals("COMPTABLE MATIERE")) {
//                            return "comptableMatiere";
//                        }
//                        if (personnel.getSpecialite().equals("CHARGER MAINTENANCE")) {
//                            return "chargerMaintenance";
//                        }
//                        if (personnel.getSpecialite().equals("PERSONNEL")) {
//                            return "personnel";
//                        }
//                    }
//                    else{return "echec";}
//                }
//            //} 
////            else {
////                return "echec";
////            }
//        }
//        return null;
//    }
//
//    public String nomPer() throws DataAccessException {
//        if(auto!=null) {
//            //Autorisation au = administration.getAutorisationByPwd(auto.getPwd());
//            System.out.println("\n"+auto);
//           // Personnel per = servicePer.findPersonnelById(au.getIdLogin());
//           //System.out.println("\n"+per);
//            return null;//per.getNom() + "  " + per.getPrenom();
//        }
//        else return null;
//    }

    public void count() {
        RequestContext rc = RequestContext.getCurrentInstance();
        rc.update("count");
        counter = counter + 1;
        System.out.println("counter= " + counter);
    }

    public List<Autorisation> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Autorisation> loginList) {
        this.loginList = loginList;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Autorisation getAuto() {
        return auto;
    }

    public void setAuto(Autorisation auto) {
        this.auto = auto;
    }

    public Personnel getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Personnel currentUser) {
        this.currentUser = currentUser;
    }

    public IServicePersonnel getServicePer() {
        return servicePer;
    }

    public void setServicePer(IServicePersonnel servicePer) {
        this.servicePer = servicePer;
    }
}
