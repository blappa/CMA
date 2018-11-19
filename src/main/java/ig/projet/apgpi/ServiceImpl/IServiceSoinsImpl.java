/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.ISoinsDao;
import ig.projet.apgpi.Entities.Soins;
import ig.projet.apgpi.Service.IServiceSoins;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceSoinsImpl implements IServiceSoins{

    private ISoinsDao isoinsDao;
    
    @Override
    public Soins findSoinsByName(String soins) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Soins findById(Long id) throws DataAccessException {
       return isoinsDao.findById(id);
    }

    @Override
    public List<Soins> findAll() throws DataAccessException {
        return isoinsDao.findAll();
    }

    @Override
    public Soins createSoins(Soins s) throws DataAccessException {
       return isoinsDao.create(s);
    }

    @Override
    public void deleteSoins(Long id) throws DataAccessException {
        Soins s=isoinsDao.findById(id);
        isoinsDao.delete(s);
    }

    @Override
    public Soins updateSoins(Soins s) throws DataAccessException {
       return isoinsDao.update(s);
    }

    public ISoinsDao getIsoinsDao() {
        return isoinsDao;
    }

    public void setIsoinsDao(ISoinsDao isoinsDao) {
        this.isoinsDao = isoinsDao;
    }
}
