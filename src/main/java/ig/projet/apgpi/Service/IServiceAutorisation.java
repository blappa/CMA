/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Affectation;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author lappa
 */
public interface IServiceAutorisation{

    public Personnel enregistrerNouveauPersonnel(Personnel p) throws DataAccessException, NoResultException;

    public Autorisation enregistrerNouveauLogin(Autorisation au) throws DataAccessException, NoResultException;

    public void annulerEnregistrementPersonnel(Personnel p) throws DataAccessException;

    public Personnel getPersonnelById(Long id) throws DataAccessException;

    public void annulerEnregistrementLogin(Autorisation au) throws DataAccessException;

    public boolean identifierLogin(String login) throws DataAccessException;
    
    public Autorisation update(Autorisation p) throws DataAccessException;
    
    public List<Personnel> getAllPersonnel() throws DataAccessException;
    
    public Autorisation getAutorisationById(Long id) throws DataAccessException;
    
    public Autorisation getAutorisationByLogin(String login) throws DataAccessException;
    
     public Autorisation getAutorisationByPwd(String pwd) throws DataAccessException;
     
    public List<Autorisation> getAutorisation() throws DataAccessException;
    
     public Affectation enregistrerAffectation(Affectation e) throws DataAccessException;
     
     public List<Affectation> FindAllAffectation() throws DataAccessException ;
    
   
}
