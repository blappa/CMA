/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IDemandeDao;
import ig.projet.apgpi.Entities.Demande;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lappa
 */
public class IDemandeDaoImpl extends GenericDao<Demande, Long> implements IDemandeDao{

    public Demande FindById(Long id) throws DataAccessException {
       return (Demande)getManager().createNamedQuery("Demande.findById").
                    setParameter("id", id).getSingleResult();
    }

    public List<Demande> FindListDemande() {
        try {
            return getManager().createNamedQuery("Demande.findAll")
                       .getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(IDemandeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
