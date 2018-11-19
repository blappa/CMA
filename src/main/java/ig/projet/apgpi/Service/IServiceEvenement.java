/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ig.projet.apgpi.Service;

import com.douwe.generic.dao.DataAccessException;
import ig.projet.apgpi.Entities.Evenement;
import java.util.List;

/**
 *
 * @author lappa
 */
public interface IServiceEvenement {

    public List<Evenement> findListeEvenement() throws DataAccessException;

    public Evenement findEvenementByName(String nom) throws DataAccessException;

    public Evenement findById(Long id) throws DataAccessException;

    public List<Evenement> findAll() throws DataAccessException;

    public Evenement create(Evenement t) throws DataAccessException;

    public void delete(Evenement t) throws DataAccessException;

    public Evenement update(Evenement t) throws DataAccessException;
}
