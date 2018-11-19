/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Autorisation;
import ig.projet.apgpi.Entities.Consultation;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IConsultationDao extends IDao<Consultation, Long> {

    public  Consultation getModifierConsultation(Consultation con) throws DataAccessException;

    public List<Consultation> getConsultationByDiagnostic(String diagnostic) throws DataAccessException;

    public Long getIdChargerMaintenanceByLogin(Autorisation login) throws DataAccessException;
}
