/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Affectation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceAffectation {
    
    public Affectation SaveAffectation(Affectation a) throws DataAccessException;
    
    public List<Affectation> FindAllAffectation() throws DataAccessException ;

   
    public Affectation findAffectationById(Long id) throws DataAccessException ;
   
    public void DeleteAffectation(Long t)throws DataAccessException;
    
    public void updateAffectation(Affectation a)throws DataAccessException;
}
