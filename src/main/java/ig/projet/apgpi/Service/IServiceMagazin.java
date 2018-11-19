/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Magazin;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceMagazin {
    
    public List<Magazin> findListeMagazin() throws DataAccessException ;
    
    public Magazin findByMagazinId(Long id) throws DataAccessException;
    
    public List<Magazin> findAll() throws DataAccessException;

    public Magazin create(Magazin t) throws DataAccessException;

    public void deletem(Long id) throws DataAccessException ;

    public Magazin update(Magazin t) throws DataAccessException;
}
