/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Evenement;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IEvenementDao extends IDao<Evenement, Long>{
    
    public List<Evenement> findListeEvenement() throws DataAccessException;
    
    public Evenement findEvenementByName(String nom) throws DataAccessException;
    
}
