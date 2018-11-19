/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Service;
import java.util.List;



/**
 *
 * @author lappa
 */
public interface IServiceService {
    
    public List<Service> findListeService() throws DataAccessException;
    
    public Service findServiceByName(String service) throws DataAccessException;
    
    public Service findById(Long id) throws DataAccessException ;
    
    public List<Service> findAll() throws DataAccessException;
    
    public Service createService(Service t) throws DataAccessException;
    
    public void deleteService(Long t) throws DataAccessException;
    
    public Service updateService(Service t) throws DataAccessException;
    
    public Service findServiceBySigle(String sigle) throws DataAccessException;
    
}
