/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import ig.projet.apgpi.Entities.Autorisation;

/**
 *
 * @author lappa
 */
public interface IAutorisationDao extends IDao<Autorisation, Long> {

    public boolean Identification(String Login) throws DataAccessException;

    public Autorisation findByLogin(String login) throws DataAccessException;
    
     public Autorisation findByPwd(String pwd) throws DataAccessException;
}
