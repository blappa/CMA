/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IAffectationDao;
import ig.projet.apgpi.Entities.Affectation;
import ig.projet.apgpi.Service.IServiceAffectation;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceAffectationImpl implements IServiceAffectation{
    
    private IAffectationDao iaffectationDao;

    @Override
    public List<Affectation> FindAllAffectation() throws DataAccessException {
        return iaffectationDao.FindAllAffectation();
    }

    @Override
    public Affectation findAffectationById(Long id) throws DataAccessException {
        return iaffectationDao.findAffectationById(id);
    }

    @Override
    public Affectation SaveAffectation(Affectation a) throws DataAccessException {
       return iaffectationDao.create(a);
    }

    @Override
    public void DeleteAffectation(Long t) throws DataAccessException {
        Affectation aff=iaffectationDao.findAffectationById(t);
        iaffectationDao.delete(aff);
    }

    public IAffectationDao getIaffectationDao() {
        return iaffectationDao;
    }

    public void setIaffectationDao(IAffectationDao iaffectationDao) {
        this.iaffectationDao = iaffectationDao;
    }

    public void updateAffectation(Affectation a) throws DataAccessException {
        iaffectationDao.update(a);
    }
    
    
    
}
