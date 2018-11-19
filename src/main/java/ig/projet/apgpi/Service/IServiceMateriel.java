/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceMateriel {

    public Materiel enregistrerNouveauMateriel(Materiel m) throws DataAccessException;

    public void annulerEnregistrerNouveauMateriel(Materiel m) throws DataAccessException;

    public boolean affecterMateriel(Personnel p, Personnel p1, Materiel m) throws DataAccessException;
    
    public Materiel getMaterielById(Long id) throws DataAccessException;

     public Materiel update(Materiel t) throws DataAccessException;
             
    public List<Materiel> getAllMateriel() throws DataAccessException;
    
     public List<Materiel> findListeMateriel();
    
    public void delete(Materiel t) throws DataAccessException;
    
    public Materiel findMaterielBySerie(String serie) throws DataAccessException;
    
    public Materiel findMaterielByVersion(String version) throws DataAccessException;
    
}
