/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IReparationDao;
import ig.projet.apgpi.Entities.Reparation;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IReparationDaoImpl extends GenericDao<Reparation, Long> implements IReparationDao{

    @Override
    public List<Reparation> findListeReparation() throws DataAccessException {
        return getManager().createNamedQuery("Reparation.findAll").getResultList();
    }

    @Override
    public Reparation findReparationByIdReparation(Integer id) throws DataAccessException {
        return (Reparation)getManager().createNamedQuery("Reparation.findById").
                setParameter("idReparation", id).getSingleResult();
    }

    @Override
    public Reparation saveReparation(Reparation r) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
