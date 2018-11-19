/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Affectation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IAffectationDao extends IDao<Affectation, Long>{
    
    
    public List<Affectation> FindAllAffectation() throws DataAccessException;

    public Affectation findAffectationById(Long id) throws DataAccessException;
}
