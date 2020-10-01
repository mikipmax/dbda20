/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.Credenciales;
import java.util.List;
import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Mickmaxy
 */

public interface CredencialesFacadeLocal {

    void create(Credenciales credenciales);

    void edit(Credenciales credenciales);

    void remove(Credenciales credenciales);

    Credenciales find(Object id);

    List<Credenciales> findAll();

    List<Credenciales> findRange(int[] range);

    int count();
    Credenciales iniciarSesion(Credenciales cli);
}
