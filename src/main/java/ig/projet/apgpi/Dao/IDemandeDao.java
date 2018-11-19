/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Demande;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IDemandeDao extends IDao<Demande, Long>{
    
    public Demande FindById(Long id) throws DataAccessException;
   
    
    public List<Demande> FindListDemande() ;
    
}
