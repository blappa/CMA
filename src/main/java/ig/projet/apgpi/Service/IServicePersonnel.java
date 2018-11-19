/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServicePersonnel {

    public Demande DemandeMateriel(Materiel m) throws DataAccessException;

    public Personnel findBySpecialite(String Specialite) throws DataAccessException;

    public List<Personnel> findListPersonnel() throws DataAccessException;

    public Personnel findPersonnelByName(String nom) throws DataAccessException;

    public Personnel findPersonnelByCNI(String cni) throws DataAccessException;
    
    public Personnel findPersonnelById(Long id) throws DataAccessException;

    public void SavePersonnel(Personnel p) throws DataAccessException;
    
    public void UpdatePersonnel(Personnel p) throws DataAccessException;
}
