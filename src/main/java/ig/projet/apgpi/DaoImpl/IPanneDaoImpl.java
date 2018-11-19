/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IPanneDao;
import ig.projet.apgpi.Entities.Panne;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IPanneDaoImpl extends GenericDao<Panne, Long> implements IPanneDao{

    @Override
    public List<Panne> findListePanne() throws DataAccessException {
        return getManager().createNamedQuery("Panne.findAll").getResultList();
    }

    @Override
    public Panne findPanneByName(String nom) throws DataAccessException {
        return (Panne)getManager().createNamedQuery("Panne.findByNomPanne").
                setParameter("nomPanne", nom).getSingleResult();
    }

    @Override
    public Panne findPanneByCode(String code) throws DataAccessException {
        return (Panne)getManager().createNamedQuery("Panne.findByCode").
                setParameter("code", code).getSingleResult();
                }
    
    
}
