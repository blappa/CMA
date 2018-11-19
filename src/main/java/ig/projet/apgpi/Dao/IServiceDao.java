/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Service;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceDao extends IDao<Service, Long>{
    
    public List<Service> findListeService() throws DataAccessException;
    
    public Service findServiceByName(String service) throws DataAccessException;
    
    public Service findServiceBySigle(String sigle) throws DataAccessException;
    
}
