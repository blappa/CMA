/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Consultation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceConsultation {

    public Consultation modifierConsultation(Consultation con) throws DataAccessException;

    public List<ig.projet.apgpi.Entities.Consultation> ListeConsultation() throws DataAccessException;

    public ig.projet.apgpi.Entities.Consultation findById(Long id) throws DataAccessException;
    
    public void enregistrerConsultation(ig.projet.apgpi.Entities.Consultation cons);
    
    public void delete(Long id) throws DataAccessException ;
}
