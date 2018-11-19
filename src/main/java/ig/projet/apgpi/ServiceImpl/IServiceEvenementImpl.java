/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IEvenementDao;
import ig.projet.apgpi.Entities.Evenement;
import ig.projet.apgpi.Service.IServiceEvenement;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceEvenementImpl implements IServiceEvenement{
    
    private IEvenementDao ievenementDao;

    @Override
    public List<Evenement> findListeEvenement() throws DataAccessException {
        return ievenementDao.findListeEvenement();
    }

    @Override
    public Evenement findEvenementByName(String nom) throws DataAccessException {
        return ievenementDao.findEvenementByName(nom);
    }

    @Override
    public Evenement findById(Long id) throws DataAccessException {
       return ievenementDao.findById(id);
    }

    @Override
    public List<Evenement> findAll() throws DataAccessException {
       return ievenementDao.findAll();
    }

    @Override
    public Evenement create(Evenement t) throws DataAccessException {
        return ievenementDao.create(t);
    }

    @Override
    public void delete(Evenement t) throws DataAccessException {
       ievenementDao.delete(t);
    }

    @Override
    public Evenement update(Evenement t) throws DataAccessException {
        return ievenementDao.update(t);
    }

    public IEvenementDao getIevenementDao() {
        return ievenementDao;
    }

    public void setIevenementDao(IEvenementDao ievenementDao) {
        this.ievenementDao = ievenementDao;
    }
    
    
}
