/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.DetalleEgreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */

public interface DetalleEgresoFacadeLocal {

    void create(DetalleEgreso detalleEgreso);

    void edit(DetalleEgreso detalleEgreso);

    void remove(DetalleEgreso detalleEgreso);

    DetalleEgreso find(Object id);

    List<DetalleEgreso> findAll();

    List<DetalleEgreso> findRange(int[] range);

    int count();
    
    List<DetalleEgreso> findByDni(String dni);
    
}
