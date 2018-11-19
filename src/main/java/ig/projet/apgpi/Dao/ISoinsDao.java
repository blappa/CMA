/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Soins;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface ISoinsDao extends IDao<Soins, Long> {
    
    public List<Soins> getAllSoins() throws DataAccessException;

    public Soins getSoinsByDesignation(String designation) throws DataAccessException;

    public Soins getSoinsByIdTypeSoins(Long id) throws DataAccessException;
}
