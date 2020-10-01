/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.EstadoCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */
public interface EstadoCreditoFacadeLocal {

    void create(EstadoCredito estadoCredito);

    void edit(EstadoCredito estadoCredito);

    void remove(EstadoCredito estadoCredito);

    EstadoCredito find(Object id);

    List<EstadoCredito> findAll();

    List<EstadoCredito> findRange(int[] range);

    int count();
    
}
