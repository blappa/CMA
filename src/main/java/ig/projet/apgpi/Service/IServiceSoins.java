/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Soins;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceSoins {
    
    
    public Soins findSoinsByName(String soins ) throws DataAccessException;
    
    public Soins  findById(Long id) throws DataAccessException ;
    
    public List<Soins > findAll() throws DataAccessException;
    
    public Soins  createSoins (Soins  s) throws DataAccessException;
    
    public void deleteSoins (Long id) throws DataAccessException;
    
    public Soins  updateSoins (Soins  s) throws DataAccessException;
    
}
