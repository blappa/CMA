/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IMagazinDao;
import ig.projet.apgpi.Entities.Magazin;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class IMagazinDaoImpl extends GenericDao<Magazin, Long> implements IMagazinDao{

    @Override
    public List<Magazin> findListeMagazin()  {
        try {
            return getManager().createNamedQuery("Magazin.findAll").getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(IMagazinDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Magazin findMagazinById(Long id) throws DataAccessException  {
       return (Magazin)getManager().createNamedQuery("Magazin.findByIdStock").
               setParameter("id", id).getSingleResult();
    }
    
}
