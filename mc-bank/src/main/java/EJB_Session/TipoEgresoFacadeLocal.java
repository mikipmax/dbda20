/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.TipoEgreso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */

public interface TipoEgresoFacadeLocal {

    void create(TipoEgreso tipoEgreso);

    void edit(TipoEgreso tipoEgreso);

    void remove(TipoEgreso tipoEgreso);

    TipoEgreso find(Object id);

    List<TipoEgreso> findAll();

    List<TipoEgreso> findRange(int[] range);

    int count();
    
}
