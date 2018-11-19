/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Panne;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServicePanne{
    
    public List<Panne> findListePanne() throws DataAccessException;
    
    public Panne findPanneByName(String nom) throws DataAccessException;
    
    public Panne findPanneByCode(String code) throws DataAccessException;
    
    public Panne findById(Long id) throws DataAccessException;
    
    public List<Panne> findAll() throws DataAccessException ;
    
    public Panne create(Panne t) throws DataAccessException;
    
    public void deletePanne(Panne t) throws DataAccessException ;
    
     public Panne update(Panne t) throws DataAccessException;
    
}
