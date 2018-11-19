/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Magazin;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IMagazinDao extends IDao<Magazin, Long>{
    
    public List<Magazin> findListeMagazin() throws DataAccessException;
    
    public Magazin findMagazinById(Long id) throws DataAccessException;
    
}
