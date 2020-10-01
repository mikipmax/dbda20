/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.TipoAmortizacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */

public interface TipoAmortizacionFacadeLocal {

    void create(TipoAmortizacion tipoAmortizacion);

    void edit(TipoAmortizacion tipoAmortizacion);

    void remove(TipoAmortizacion tipoAmortizacion);

    TipoAmortizacion find(Object id);

    List<TipoAmortizacion> findAll();

    List<TipoAmortizacion> findRange(int[] range);

    int count();
    
}
