/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IDemandeDao;
import ig.projet.apgpi.Dao.IMaterielDao;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Service.IServiceDemande;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceDemandeImpl implements IServiceDemande {

    private IDemandeDao idemandeDao;

    @Override
    public Demande ValideDemande(Demande d) throws DataAccessException {
        Demande d1 = idemandeDao.FindById(d.getId());
        d1.setId(d.getId());
        d1.setMateriel(d.getMateriel());
//         d1.setEspece(d.getEspece());
//         d1.setQte(d.getQte());
        d1.setServies(d.getServies());
        d1.setPersonnel(d.getPersonnel());
        d1.setObservation(d.getObservation());
        return idemandeDao.update(d1);
    }

    @Override
    public Demande SaveDemande(Demande d) throws DataAccessException {
        return idemandeDao.create(d);
    }

    @Override
    public Demande FindById(Long id) throws DataAccessException {
        return idemandeDao.FindById(id);
    }

    @Override
    public void deleteDemande(Demande d) throws DataAccessException {
        Demande dd = idemandeDao.FindById(d.getId());
        idemandeDao.delete(dd);
    }

    @Override
    public void updateDemande(Demande d) throws DataAccessException {
        idemandeDao.update(d);
    }


    @Override
    public List<Demande> FindListDemane() throws DataAccessException {
        return idemandeDao.FindListDemande();
    }

    public IDemandeDao getIdemandeDao() {
        return idemandeDao;
    }

    public void setIdemandeDao(IDemandeDao idemandeDao) {
        this.idemandeDao = idemandeDao;
    }

}
