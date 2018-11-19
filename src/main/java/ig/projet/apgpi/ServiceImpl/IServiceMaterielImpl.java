/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IEvenementDao;
import ig.projet.apgpi.Dao.IMagazinDao;
import ig.projet.apgpi.Dao.IMaterielDao;
import ig.projet.apgpi.Dao.IPersonnelDao;
import ig.projet.apgpi.Entities.Evenement;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Service.IServiceMateriel;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceMaterielImpl implements IServiceMateriel{
    
    private IMaterielDao imaterielDao;
    private IPersonnelDao ipersonnelDao;
    private IMagazinDao imagazinDao;
    private IEvenementDao ievenementDao;
    
    @Override
    public List<Materiel> findListeMateriel() {
        return imaterielDao.findListeMateriel();
    }

    @Override
    public boolean affecterMateriel(Personnel p, Personnel p1, Materiel m) throws DataAccessException {
         
        Materiel m1= imaterielDao.findMaterielByNumSerie(m.getNumSerie());
        if(m1==null){
            return false;
        }
        else{
        if(m.getNumSerie().equals(m1.getNumSerie())){
        Personnel p2 = ipersonnelDao.findPersonnelByCNI(p.getCni());
        ipersonnelDao.create(p2);
        Personnel p3 = ipersonnelDao.findPersonnelByCNI(p1.getCni());
        ipersonnelDao.create(p3);  
        imaterielDao.create(m);
        Magazin mag1=imagazinDao.findMagazinById(m.getId());
        Magazin mag=new Magazin(mag1.getPeremtion(),mag1.getIdStock(),mag1.getMateriel());
        imagazinDao.update(mag);
        return true;
        }
        else{
        return false;
        }
    }     
 } 

    public boolean sortirMateriel(Materiel m, Evenement e) throws DataAccessException {
         Materiel m1= imaterielDao.findMaterielByNumSerie(m.getNumSerie());
         if(m1==null){
         return false;
         }
         else{
           if(m1.getNumSerie().equals(m.getNumSerie())){
           imaterielDao.create(m);
           ievenementDao.create(e);
           return true;
           }
           else{
           return false;
           }
         }
    }

    public Materiel findById(Long id) throws DataAccessException {
        return imaterielDao.findById(id);
    }

    public List<Materiel> findAll() throws DataAccessException {
        return imaterielDao.findAll();
    }

    public Materiel create(Materiel t) throws DataAccessException {
        return imaterielDao.create(t);
    }

    @Override
    public void delete(Materiel t) throws DataAccessException {
        Materiel m = imaterielDao.findById(t.getId());
        imaterielDao.delete(m);
    }

    @Override
    public Materiel update(Materiel t) throws DataAccessException {
       return imaterielDao.update(t);
    }

    @Override
    public Materiel findMaterielBySerie(String serie) throws DataAccessException {
        return imaterielDao.findMaterielByNumSerie(serie);
    }
    
    @Override
    public Materiel findMaterielByVersion(String version) throws DataAccessException {
        return imaterielDao.findMaterielByVersion(version) ;
    }

    public IMaterielDao getImaterielDao() {
        return imaterielDao;
    }

    public void setImaterielDao(IMaterielDao imaterielDao) {
        this.imaterielDao = imaterielDao;
    }

    public IPersonnelDao getIpersonnelDao() {
        return ipersonnelDao;
    }

    public void setIpersonnelDao(IPersonnelDao ipersonnelDao) {
        this.ipersonnelDao = ipersonnelDao;
    }

    public IMagazinDao getImagazinDao() {
        return imagazinDao;
    }

    public void setImagazinDao(IMagazinDao imagazinDao) {
        this.imagazinDao = imagazinDao;
    }

    public IEvenementDao getIevenementDao() {
        return ievenementDao;
    }

    public void setIevenementDao(IEvenementDao ievenementDao) {
        this.ievenementDao = ievenementDao;
    }

    @Override
    public Materiel enregistrerNouveauMateriel(Materiel m) throws DataAccessException {
        return  imaterielDao.create(m);
    }

    @Override
    public void annulerEnregistrerNouveauMateriel(Materiel m) throws DataAccessException {
        imaterielDao.delete(m);
    }

    @Override
    public Materiel getMaterielById(Long id) throws DataAccessException {
        return imaterielDao.findById(id);
    }

    @Override
    public List<Materiel> getAllMateriel() throws DataAccessException {
        return imaterielDao.findAll();
    }

    

}
