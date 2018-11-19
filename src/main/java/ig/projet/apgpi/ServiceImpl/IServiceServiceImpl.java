/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IServiceDao;
import ig.projet.apgpi.Entities.Service;
import ig.projet.apgpi.Service.IServiceService;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceServiceImpl implements IServiceService{
    
    private IServiceDao iserviceDao;

    @Override
    public List<Service> findListeService() throws DataAccessException {
        return iserviceDao.findListeService();
    }

    @Override
    public Service findServiceByName(String service) throws DataAccessException {
        return iserviceDao.findServiceByName(service);
    }
    
    

    @Override
    public Service findById(Long id) throws DataAccessException {
        return iserviceDao.findById(id);
    }

    @Override
    public List<Service> findAll() throws DataAccessException {
       return iserviceDao.findAll();
    }

    @Override
    public Service createService(Service t) throws DataAccessException {
        return iserviceDao.create(t);
    }

    @Override
    public void deleteService(Long t) throws DataAccessException {
        Service se=iserviceDao.findById(t);
        iserviceDao.delete(se);
    }

    @Override
    public Service updateService(Service t) throws DataAccessException {
        return iserviceDao.update(t);
    }

    public IServiceDao getIserviceDao() {
        return iserviceDao;
    }

    public void setIserviceDao(IServiceDao iserviceDao) {
        this.iserviceDao = iserviceDao;
    }

    @Override
    public Service findServiceBySigle(String sigle) throws DataAccessException {
   return iserviceDao.findServiceBySigle(sigle);
   }
    
}
