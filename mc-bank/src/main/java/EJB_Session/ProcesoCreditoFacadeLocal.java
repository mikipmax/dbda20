/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.ProcesoCredito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */
public interface ProcesoCreditoFacadeLocal {

    void create(ProcesoCredito procesoCredito);

    void edit(ProcesoCredito procesoCredito);

    void remove(ProcesoCredito procesoCredito);

    ProcesoCredito find(Object id);

    List<ProcesoCredito> findAll();

    List<ProcesoCredito> findRange(int[] range);

    int count();
    
}
