/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Demande;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceDemande {
    
    public Demande ValideDemande(Demande d ) throws DataAccessException;
    
    public Demande SaveDemande(Demande d) throws DataAccessException;
    
    public Demande FindById(Long id) throws DataAccessException;
    
    public List<Demande> FindListDemane() throws DataAccessException;
    
    public void deleteDemande(Demande d) throws DataAccessException;
    
    public void updateDemande(Demande d) throws DataAccessException;
    
}
