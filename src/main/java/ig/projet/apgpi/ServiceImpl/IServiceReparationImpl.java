/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IReparationDao;
import ig.projet.apgpi.Entities.Reparation;
import ig.projet.apgpi.Service.IServiceReparation;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceReparationImpl implements IServiceReparation{
    
    private IReparationDao ireparationDao;

    @Override
    public List<Reparation> findListeReparation() throws DataAccessException {
        return ireparationDao.findListeReparation();
    }

    @Override
    public IReparationDao getIreparationDao() {
        return ireparationDao;
    }

    @Override
    public void setIreparationDao(IReparationDao ireparationDao) {
        this.ireparationDao = ireparationDao;
    }
    
    

    @Override
    public Reparation findById(Long id) throws DataAccessException {
        return ireparationDao.findById(id);
    }

    @Override
    public List<Reparation> findAll() throws DataAccessException {
       return ireparationDao.findAll();
    }

    @Override
    public Reparation create(Reparation t) throws DataAccessException {
        return ireparationDao.create(t);
    }

    @Override
    public void delete(Reparation t) throws DataAccessException {
        Reparation t1 = ireparationDao.findById(t.getId());
        ireparationDao.delete(t1);
    }

    public Reparation update(Reparation t) throws DataAccessException {
       return ireparationDao.update(t);
    }

    public IReparationDao getIreparrationDao() {
        return ireparationDao;
    }

    public void setIreparrationDao(IReparationDao ireparrationDao) {
        this.ireparationDao = ireparrationDao;
    }
    
}
