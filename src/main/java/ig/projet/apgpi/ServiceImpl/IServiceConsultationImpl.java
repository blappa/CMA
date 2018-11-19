/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IConsultationDao;
import ig.projet.apgpi.Entities.Consultation;
import ig.projet.apgpi.Service.IServiceConsultation;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceConsultationImpl implements IServiceConsultation{

    private IConsultationDao iconsultationDao;
   

    @Override
    public List<ig.projet.apgpi.Entities.Consultation> ListeConsultation() throws DataAccessException {
        return iconsultationDao.findAll();
    }

    @Override
    public Consultation modifierConsultation(ig.projet.apgpi.Entities.Consultation con) throws DataAccessException {
      return  iconsultationDao.update(con);
    }
    
     @Override
    public void delete(Long id) throws DataAccessException {
         ig.projet.apgpi.Entities.Consultation c=iconsultationDao.findById(id);
         iconsultationDao.delete(c);
    }
    public IConsultationDao getIconsultationDao() {
        return iconsultationDao;
    }

    public void setIconsultationDao(IConsultationDao iconsultationDao) {
        this.iconsultationDao = iconsultationDao;
    }

    @Override
    public void enregistrerConsultation(ig.projet.apgpi.Entities.Consultation cons) {
        try {
            iconsultationDao.create(cons);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceConsultationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Consultation findById(Long id) throws DataAccessException {
      return iconsultationDao.findById(id);
    }

}
