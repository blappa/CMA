/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.beans;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Panne;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Service.IServiceDemande;
import ig.projet.apgpi.Service.IServiceMagazin;
import ig.projet.apgpi.Service.IServiceMateriel;
import ig.projet.apgpi.Service.IServicePanne;
import ig.projet.apgpi.Service.IServicePersonnel;
import java.io.File;
import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author lappa
 */
@ManagedBean(name = "print")
@RequestScoped
public class Impresion  implements Serializable{

    JasperPrint jasperPrint;
    
    
    private  ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    public  String path = servletContext.getRealPath("") + File.separator+"print";
    
    @ManagedProperty(value = "#{serviceMateriel}")
    private IServiceMateriel serviceMat;
    @ManagedProperty(value = "#{serviceMagazin}")
    private IServiceMagazin serviceStock;
    @ManagedProperty(value = "#{servicePersonnel}")
    private IServicePersonnel servicePer;
    @ManagedProperty(value = "#{serviceDemande}")
    private IServiceDemande serviceDeman;
     @ManagedProperty(value = "#{servicePanne}")
    private IServicePanne servicePanne;
    
    private List<Demande> demandeList;
    private List<Materiel> materielList;
    private List<Magazin> magazinList;
    private List<Personnel> personnelList;
    private List<Panne> panneList;

    public Impresion() {
    }
    
    

    public void pdfMateriel(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        materielList = serviceMat.findListeMateriel();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(materielList);
        jasperPrint = JasperFillManager.fillReport(path+File.separator+"materiel"+File.separator+"rmateriel.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=materiel.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }
    
    public void pdfPanne(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        panneList = servicePanne.findListePanne();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(panneList);
        jasperPrint = JasperFillManager.fillReport(path+File.separator+"panne"+File.separator+"rpanne.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=panne.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfStock(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        magazinList = serviceStock.findAll();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(magazinList);
        jasperPrint = JasperFillManager.fillReport(path+File.separator+"stock"+File.separator+"rstock.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=stock.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfDemande(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        demandeList = serviceDeman.FindListDemane();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(demandeList);
        jasperPrint = JasperFillManager.fillReport(path+File.separator+"demande"+File.separator+"rdemande.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=demande.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void pdfPersonnel(ActionEvent actionEven) throws JRException, DataAccessException, IOException {
        personnelList = servicePer.findListPersonnel();
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(personnelList);
        jasperPrint = JasperFillManager.fillReport(path+File.separator+"personnel"+File.separator+"rpersonnel.jasper", new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment; filename=personnel.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
    }

   
    public IServiceMagazin getServiceStock() {
        return serviceStock;
    }

    public void setServiceStock(IServiceMagazin serviceStock) {
        this.serviceStock = serviceStock;
    }

    public IServiceMateriel getServiceMat() {
        return serviceMat;
    }

    public void setServiceMat(IServiceMateriel serviceMat) {
        this.serviceMat = serviceMat;
    }

    public List<Materiel> getMaterielList() throws DataAccessException {
        return materielList;
    }

    public void setMaterielList(List<Materiel> materielList) {
        this.materielList = materielList;
    }

    public List<Magazin> getMagazinList(){
        return magazinList;
    }

    public void setMagazinList(List<Magazin> magazinList) {
        this.magazinList = magazinList;
    }

    public List<Personnel> getPersonnelList() {
        return personnelList;
    }

    public void setPersonnelList(List<Personnel> personnelList) {
        this.personnelList = personnelList;
    }

    public IServicePersonnel getServicePer() {
        return servicePer;
    }

    public void setServicePer(IServicePersonnel servicePer) {
        this.servicePer = servicePer;
    }

    public IServiceDemande getServiceDeman() {
        return serviceDeman;
    }

    public void setServiceDeman(IServiceDemande serviceDeman) {
        this.serviceDeman = serviceDeman;
    }

    public List<Demande> getDemandeList() {
        return demandeList;
    }

    public void setDemandeList(List<Demande> demandeList) {
        this.demandeList = demandeList;
    }

    public IServicePanne getServicePanne() {
        return servicePanne;
    }

    public void setServicePanne(IServicePanne servicePanne) {
        this.servicePanne = servicePanne;
    }

    public List<Panne> getPanneList() {
        return panneList;
    }

    public void setPanneList(List<Panne> panneList) {
        this.panneList = panneList;
    }
    
    
    
}
