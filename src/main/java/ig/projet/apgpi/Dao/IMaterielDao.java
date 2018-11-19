/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Evenement;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IMaterielDao extends IDao<Materiel, Long> {

    public List<Materiel> findListeMateriel();

    public boolean affecterMateriel(Personnel p, Personnel p1, Materiel m) throws DataAccessException;

    public boolean sortirMateriel(Materiel m, Evenement e) throws DataAccessException;

    public Materiel findMaterielByNumSerie(String serie) throws DataAccessException;
    
    public Materiel findMaterielByVersion(String version) throws DataAccessException;

    Materiel getMedicamentByIdMateriel(Long id) throws DataAccessException;

}
