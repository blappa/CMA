/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IPanneDao;
import ig.projet.apgpi.Entities.Panne;
import ig.projet.apgpi.Service.IServicePanne;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServicePanneImpl implements IServicePanne{
    
    private IPanneDao ipanneDao;

    @Override
    public List<Panne> findListePanne() throws DataAccessException {
        return ipanneDao.findListePanne();
    }

    @Override
    public Panne findPanneByName(String nom) throws DataAccessException {
       return ipanneDao.findPanneByName(nom);
    }

    @Override
    public Panne findById(Long id) throws DataAccessException {
        return ipanneDao.findById(id);
    }

    @Override
    public List<Panne> findAll() throws DataAccessException {
       return ipanneDao.findAll();
    }

    @Override
    public Panne create(Panne t) throws DataAccessException {
       return ipanneDao.create(t);
    }

    @Override
    public void deletePanne(Panne t) throws DataAccessException {
        Panne p1 =ipanneDao.findById(t.getId());
        ipanneDao.delete(p1);
    }

    @Override
    public Panne update(Panne t) throws DataAccessException {
        return ipanneDao.update(t);
    }

    public IPanneDao getIpanneDao() {
        return ipanneDao;
    }

    public void setIpanneDao(IPanneDao ipanneDao) {
        this.ipanneDao = ipanneDao;
    }

    @Override
    public Panne findPanneByCode(String code) throws DataAccessException {
    return ipanneDao.findPanneByCode(code);
            }
    
}
