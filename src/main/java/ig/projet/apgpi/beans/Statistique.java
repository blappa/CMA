/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.beans;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Service.IServiceDemande;
import ig.projet.apgpi.Service.IServiceMagazin;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "stat")
@RequestScoped
public class Statistique implements Serializable {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
    private IServiceMagazin iServiceMagazin = (IServiceMagazin) ctx.getBean("serviceMagazin");
    private IServiceDemande serviceDeman = (IServiceDemande) ctx.getBean("serviceDemande");
//    
    private CartesianChartModel categoryModel1;
    private CartesianChartModel categoryModel2;
    private List<Demande> demandeList;
    private List<Magazin> magazinList;

    public Statistique() {
        createCategoryModel1();
        createCategoryModel2();
    }

    public CartesianChartModel getCategoryModel1() {
        return categoryModel1;
    }

    private void createCategoryModel1() {
        categoryModel1 = new CartesianChartModel();
        ChartSeries materiels = new ChartSeries();
        String tm1 = null;
        Long st = 0L;
        try {
            materiels.setLabel("STOCK");
            magazinList = iServiceMagazin.findListeMagazin();
            for (Magazin magazin : magazinList) {
                SimpleDateFormat tmp = new SimpleDateFormat("dd/MM/yyyy");
                String s = tmp.format(magazin.getMateriel().getDateDebutGarantie());
                String tm = s.substring(6, 10);
                if (tm1 == null || tm.equals(tm1)) {
                    st = st + magazin.getStock();
                    tm1 = tm;
                } else {
                    materiels.set(tm1, st);
                    st = magazin.getStock();
                    tm1 = tm;
                }
            }
            materiels.set(tm1, st);
            categoryModel1.addSeries(materiels);
        } catch (DataAccessException ex) {
            Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void createCategoryModel2() {
        categoryModel2 = new CartesianChartModel();
        ChartSeries demandes = new ChartSeries();
        String tm2 = null;
        Long st2 = 0L;
        try {  
            demandes.setLabel("DEMANDE");
            demandeList = serviceDeman.FindListDemane();
            for (Demande demande : demandeList) {
                SimpleDateFormat tmp = new SimpleDateFormat("dd/MM/yyyy");
                String s = tmp.format(demande.getMateriel().getDateDebutGarantie());
                String tm = s.substring(6, 10);
                if (tm2 == null || tm.equals(tm2)) {
                    st2 = st2 + demande.getQte();
                    tm2 = tm;
                } else {
                    demandes.set(tm2, st2);
                    st2 = demande.getQte();
                    tm2 = tm;
                }
            }
            demandes.set(tm2, st2);
            categoryModel2.addSeries(demandes);
        } catch (DataAccessException ex) {
            Logger.getLogger(Statistique.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public IServiceMagazin getiServiceMagazin() {
        return iServiceMagazin;
    }

    public void setiServiceMagazin(IServiceMagazin iServiceMagazin) {
        this.iServiceMagazin = iServiceMagazin;
    }

    public IServiceDemande getServiceDeman() {
        return serviceDeman;
    }

    public void setServiceDeman(IServiceDemande serviceDeman) {
        this.serviceDeman = serviceDeman;
    }

    public ApplicationContext getCtx() {
        return ctx;
    }

    public void setCtx(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public List<Magazin> getMagazinList() {
        return magazinList;
    }

    public void setMagazinList(List<Magazin> magazinList) {
        this.magazinList = magazinList;
    }

    public CartesianChartModel getCategoryModel2() {
        return categoryModel2;
    }
    
}
