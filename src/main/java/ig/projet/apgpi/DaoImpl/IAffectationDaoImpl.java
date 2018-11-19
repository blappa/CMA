/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IAffectationDao;
import ig.projet.apgpi.Entities.Affectation;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IAffectationDaoImpl extends GenericDao<Affectation, Long> implements IAffectationDao{

    @Override
    public List<Affectation> FindAllAffectation() throws DataAccessException {
        return getManager().createNamedQuery("Affectation.findAll").getResultList();
    }

    @Override
    public Affectation findAffectationById(Long id) throws DataAccessException {
        return (Affectation)getManager().createNamedQuery("Affectation.findById").
               setParameter("id", id).getSingleResult();
    }

    
}
