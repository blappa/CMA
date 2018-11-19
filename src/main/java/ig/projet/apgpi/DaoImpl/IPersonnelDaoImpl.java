/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IPersonnelDao;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IPersonnelDaoImpl extends GenericDao<Personnel, Long> implements IPersonnelDao{

    @Override
    public List<Personnel> findListPersonnel() throws DataAccessException {
       return getManager().createNamedQuery("Personnel.findAll").
                getResultList();
    }
    
    @Override
    public Personnel findPersonnelByName(String nom) throws DataAccessException{
    
        return (Personnel)getManager().createNamedQuery("Personnel.findByNom").
                setParameter("nom", nom).getSingleResult(); 
    }
    
    @Override
    public Personnel findPersonnelByCNI(String cni) throws DataAccessException{
     
        return (Personnel)getManager().createNamedQuery("Personnel.findByCni")
                .setParameter("cni", cni).getSingleResult();
    
    }

    @Override
    public Personnel findBySpecialite(String specialite) throws DataAccessException {
        return (Personnel)getManager().createNamedQuery("Personnel.findBySpecialite")
                .setParameter("specialite", specialite).getSingleResult();
    }

    @Override
    public Personnel findPersonnelById(Long id) throws DataAccessException {
       return (Personnel)getManager().createNamedQuery("Personnel.findById")
                .setParameter("id", id).getSingleResult();
    }
}
