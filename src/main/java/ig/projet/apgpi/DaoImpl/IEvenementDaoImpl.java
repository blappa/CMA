/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IEvenementDao;
import ig.projet.apgpi.Entities.Evenement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class IEvenementDaoImpl extends GenericDao<Evenement, Long> implements IEvenementDao{

    public List<Evenement> findListeEvenement() throws DataAccessException{
        try {
            return getManager().createNamedQuery("Evenement.findAll")
                   .getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(IEvenementDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Evenement findEvenementByName(String nom) throws DataAccessException {
        try {
            return (Evenement)getManager().createNamedQuery("Evenement.findByNomEven").
                    setParameter("nom", nom).getSingleResult();
        } catch (DataAccessException ex) {
            Logger.getLogger(IEvenementDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
   
}
