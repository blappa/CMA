/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IMaterielDao;
import ig.projet.apgpi.Entities.Evenement;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;


/**
 *
 * @author lappa
 */
public class IMaterielDaoImpl extends GenericDao<Materiel, Long> implements IMaterielDao{

    @Override
    public List<Materiel> findListeMateriel() {
        try {
            return getManager().createNamedQuery("Materiel.findAll").
                    getResultList();
        } catch (DataAccessException ex) {
            Logger.getLogger(IMaterielDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean affecterMateriel(Personnel p, Personnel p1, Materiel m) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean sortirMateriel(Materiel m, Evenement e) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Materiel findMaterielByNumSerie(String serie) throws DataAccessException {
        return (Materiel)getManager().createNamedQuery("SELECT m FROM Materiel m WHERE m.numSerie= :serie").
                setParameter("serie", serie).getSingleResult();
    }
    
    public Materiel findMaterielByVersion(String version) throws DataAccessException{
    return (Materiel)getManager().createNamedQuery("Materiel.findByVersion").
                setParameter("version", version).getSingleResult();
    }

    @Override
    public Materiel getMedicamentByIdMateriel(Long id) throws DataAccessException {
        return (Materiel)getManager().createNamedQuery("Materiel.findById").
                setParameter("id", id).getSingleResult();
    }

    public boolean isLongerSave(Materiel m) throws DataAccessException {
         try{
            Materiel mm=getMaterielByNumeroOrdre(m.getId());
            return true; 
        }catch(NoResultException ex){
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Materiel getMaterielByNumeroOrdre(Long numeroOrdre) throws DataAccessException {
        return (Materiel)getManager().createNamedQuery("Materiel.findByNumeroOrdre").
                setParameter("numeroOrdre", numeroOrdre).getSingleResult();
    }
    
}
