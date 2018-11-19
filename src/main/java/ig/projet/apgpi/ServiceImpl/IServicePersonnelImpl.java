/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IPersonnelDao;
import ig.projet.apgpi.Entities.Demande;
import ig.projet.apgpi.Entities.Materiel;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Service.IServicePersonnel;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServicePersonnelImpl implements IServicePersonnel {

    private IPersonnelDao ipersonnelDao;

    @Override
    public List<Personnel> findListPersonnel() throws DataAccessException {
        return ipersonnelDao.findListPersonnel();
    }

    @Override
    public Personnel findPersonnelByName(String nom) throws DataAccessException {
        return ipersonnelDao.findPersonnelByName(nom);
    }

    @Override
    public Personnel findPersonnelByCNI(String cni) throws DataAccessException {
        return ipersonnelDao.findPersonnelByCNI(cni);
    }

    @Override
    public Personnel findBySpecialite(String Specialite) throws DataAccessException {
        return ipersonnelDao.findBySpecialite(Specialite);
    }

    @Override
    public Demande DemandeMateriel(Materiel m) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void SavePersonnel(Personnel p) throws DataAccessException {
        ipersonnelDao.create(p);
    }
    
    @Override
    public void UpdatePersonnel(Personnel p) throws DataAccessException {
        ipersonnelDao.update(p);
    }
    
    @Override
    public Personnel findPersonnelById(Long id) throws DataAccessException {
        return ipersonnelDao.findPersonnelById(id);
    }

    public IPersonnelDao getIpersonnelDao() {
        return ipersonnelDao;
    }

    public void setIpersonnelDao(IPersonnelDao ipersonnelDao) {
        this.ipersonnelDao = ipersonnelDao;
    }

    
}
