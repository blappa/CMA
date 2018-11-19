/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.ISoinsDao;
import ig.projet.apgpi.Entities.Soins;
import java.util.List;

/**
 *
 * @author lappa
 */
public class ISoinsDaoImpl extends GenericDao<Soins, Long> implements ISoinsDao{

    @Override
    public Soins getSoinsByDesignation(String designation) throws DataAccessException {
         return (Soins) getManager().createNamedQuery("Soins.findByDesignation").setParameter("designation", designation).getResultList();
    }

    @Override
    public Soins getSoinsByIdTypeSoins(Long id) throws DataAccessException {
        return (Soins)getManager().createNamedQuery("Soins.findByIdSoins").setParameter("idSoins", id).getResultList();
    }

    @Override
    public List<Soins> getAllSoins() throws DataAccessException {
         return getManager().createNamedQuery("Soins.findAll").getResultList();
    }
    
}
