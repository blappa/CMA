/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.ServiceImpl;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Dao.IAffectationDao;
import ig.projet.apgpi.Dao.IAutorisationDao;
import ig.projet.apgpi.Dao.IConsultationDao;
import ig.projet.apgpi.Dao.IMaterielDao;
import ig.projet.apgpi.Dao.IPersonnelDao;
import ig.projet.apgpi.Entities.Affectation;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Personnel;
import ig.projet.apgpi.Service.IServiceAutorisation;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lappa
 */
@Transactional
public class IServiceAutorisationImpl implements IServiceAutorisation {
    
    private IPersonnelDao personnelDao;
    private IAutorisationDao autorisationDao;
    private IConsultationDao consultationDao;
    private IMaterielDao materielDao; 
    private IAutorisationDao loginDao;
    private IAffectationDao iaffectationDao;

    @Override
    public Personnel enregistrerNouveauPersonnel(Personnel p) throws DataAccessException {
                Personnel pp = personnelDao.findById(p.getId());
                if(pp!=null) {
                    return (Personnel) personnelDao.update(pp);
                }
                else {
                    return (Personnel) personnelDao.create(p);
                }
            } 
    
    
     @Override
    public Autorisation enregistrerNouveauLogin(Autorisation p) throws DataAccessException{
       return autorisationDao.create(p);
     }
     
    @Override
    public void annulerEnregistrementPersonnel(Personnel p) throws DataAccessException {
        Personnel pp = personnelDao.findById(p.getId());
        personnelDao.delete(pp);
    }

    @Override
    public boolean identifierLogin(String login) throws DataAccessException {
        return autorisationDao.Identification(login);
    }

   
    @Override
    public List<Personnel> getAllPersonnel() throws DataAccessException {
        return personnelDao.findAll();
    }


    public Personnel getPersonneLike(String nom) throws DataAccessException {
        return personnelDao.findPersonnelByName(nom);
    }

    @Override
    public Personnel getPersonnelById(Long id) throws DataAccessException {
        return personnelDao.findById(id);
    }

  
    @Override
    public void annulerEnregistrementLogin(Autorisation p) throws DataAccessException {
        Autorisation pp = loginDao.findById(p.getIdLogin());
        loginDao.delete(pp);
    }
    

    public IPersonnelDao getPersonnelDao() {
        return personnelDao;
    }

    public void setPersonnelDao(IPersonnelDao personnelDao) {
        this.personnelDao = personnelDao;
    }

    @Override
    public List<Affectation> FindAllAffectation() throws DataAccessException {
        return iaffectationDao.FindAllAffectation();
    }
    
    public Autorisation getAutorisationByPwd(String pwd) throws DataAccessException{
    return loginDao.findByPwd(pwd);
    }
    
    @Override
    public Autorisation update(Autorisation p) throws DataAccessException {
        return autorisationDao.update(p);
    }
    
    @Override
    public Affectation enregistrerAffectation(Affectation e) throws DataAccessException {
       
            Affectation ex = iaffectationDao.findAffectationById(e.getId());
       
            return iaffectationDao.create(ex);
    }
        
    public IAutorisationDao getAutorisationDao() {
        return autorisationDao;
    }

    public void setAutorisationDao(IAutorisationDao autorisationDao) {
        this.autorisationDao = autorisationDao;
    }
    
     public Personnel getPersonnelLikeNomPrenom(String nom, String prenom) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public IConsultationDao getConsultationDao() {
        return consultationDao;
    }

    public void setConsultationDao(IConsultationDao consultationDao) {
        this.consultationDao = consultationDao;
    }

    public IMaterielDao getMaterielDao() {
        return materielDao;
    }

    public void setMaterielDao(IMaterielDao materielDao) {
        this.materielDao = materielDao;
    }

    public IAffectationDao getIaffectationDao() {
        return iaffectationDao;
    }

    public void setIaffectationDao(IAffectationDao iaffectationDao) {
        this.iaffectationDao = iaffectationDao;
    }

    public IAutorisationDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(IAutorisationDao loginDao) {
        this.loginDao = loginDao;
    }

    
    @Override
    public Autorisation getAutorisationById(Long id) throws DataAccessException {
        return autorisationDao.findById(id);
    }

    @Override
    public Autorisation getAutorisationByLogin(String login) throws DataAccessException {
        return autorisationDao.findByLogin(login);
    }

    @Override
    public List<Autorisation> getAutorisation() throws DataAccessException {
        return autorisationDao.findAll();
    }

    public Autorisation findByLogin(String login) throws DataAccessException {
        return autorisationDao.findByLogin(login);
    }

    public Autorisation findById(Integer id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Autorisation> findAll() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Autorisation create(Autorisation t) throws DataAccessException {
        return autorisationDao.create(t);
    }

    public void delete(Autorisation t) throws DataAccessException {
        autorisationDao.delete(t);
    }

}
