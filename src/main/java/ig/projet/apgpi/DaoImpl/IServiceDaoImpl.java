/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IServiceDao;
import ig.projet.apgpi.Entities.Service;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IServiceDaoImpl extends GenericDao<Service, Long> implements IServiceDao{

    @Override
    public List<Service> findListeService() throws DataAccessException {
        return getManager().createNamedQuery("Service.findAll").getResultList();
    }

    @Override
    public Service findServiceByName(String service) throws DataAccessException {
        return (Service)getManager().createNamedQuery("Service.findByNomService").
                setParameter("nomService", service).getSingleResult();
    }

    @Override
    public Service findServiceBySigle(String sigle) throws DataAccessException {
        return (Service)getManager().createNamedQuery("Service.findBySigle").
                setParameter("sigle", sigle).getSingleResult();
    }
    
}
