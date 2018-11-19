package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lappa
 */
public interface IPersonnelDao extends IDao<Personnel, Long>{
    
    public List<Personnel> findListPersonnel() throws DataAccessException;
    
    public Personnel findPersonnelByName(String nom) throws DataAccessException;
    
    public Personnel findPersonnelById(Long id) throws DataAccessException;

    public Personnel findPersonnelByCNI(String cni) throws DataAccessException;
    
    public Personnel findBySpecialite(String Specialite) throws DataAccessException;
}

