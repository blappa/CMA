/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.DaoImpl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import ig.projet.apgpi.Dao.IConsultationDao;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Consultation;
import java.util.List;

/**
 *
 * @author lappa
 */
public class IConsultationDaoImpl extends GenericDao<Consultation, Long> implements IConsultationDao {

 
    @Override
    public List<Consultation> getConsultationByDiagnostic(String diagnostic) throws DataAccessException {
        return getManager().createNamedQuery("Consultation.findByDiagnostic").
                setParameter("diagnostic", diagnostic).getResultList();
    }

    @Override
    public Long getIdChargerMaintenanceByLogin(Autorisation login) throws DataAccessException {
        return login.getIdLogin();
    }

    @Override
    public Consultation getModifierConsultation(Consultation con) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
}

