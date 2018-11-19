/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IMagazinDao;
import ig.projet.apgpi.Entities.Magazin;
import ig.projet.apgpi.Service.IServiceMagazin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceMagazinImpl implements IServiceMagazin{

    private IMagazinDao imagazinDao;
    
    public List<Magazin> findListeMagazin() {
        try {
            return imagazinDao.findListeMagazin();
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMagazinImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Magazin findByMagazinId(Long id){
        try {
            return imagazinDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(IServiceMagazinImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Magazin> findAll() throws DataAccessException {
        return imagazinDao.findAll();
    }

    @Override
    public Magazin create(Magazin t) throws DataAccessException {
        return imagazinDao.create(t);
    }

    @Override
    public void deletem(Long id) throws DataAccessException {
        Magazin m=imagazinDao.findById(id);
       imagazinDao.delete(m);
    }

    public Magazin update(Magazin t) throws DataAccessException {
        return imagazinDao.update(t);
    }

    public IMagazinDao getImagazinDao() {
        return imagazinDao;
    }

    public void setImagazinDao(IMagazinDao imagazinDao) {
        this.imagazinDao = imagazinDao;
    }
    
}
