/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Panne;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IPanneDao extends IDao<Panne, Long>{
    
    public List<Panne> findListePanne() throws DataAccessException;
    
    public Panne findPanneByName(String nom) throws DataAccessException;
    
    public Panne findPanneByCode(String code) throws DataAccessException;
}
