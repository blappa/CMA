/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IReparationDao;
import ig.projet.apgpi.Entities.Reparation;
import java.util.List;


/**
 *
 * @author lappa
 */
public interface IServiceReparation {
    
    public List<Reparation> findListeReparation() throws DataAccessException ;

    public IReparationDao getIreparationDao()throws DataAccessException ;

    public void setIreparationDao(IReparationDao ireparationDao) throws DataAccessException ;

    public Reparation findById(Long id) throws DataAccessException;

    public List<Reparation> findAll() throws DataAccessException;

    public Reparation create(Reparation t) throws DataAccessException;

    public void delete(Reparation t) throws DataAccessException ;
    
    public Reparation update(Reparation t) throws DataAccessException ;
}
