/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Reparation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IReparationDao extends IDao<Reparation, Long>{
   
    public List<Reparation> findListeReparation() throws DataAccessException;
    
    public Reparation findReparationByIdReparation(Integer id) throws DataAccessException;
    
    public Reparation saveReparation(Reparation r) throws DataAccessException;
}
