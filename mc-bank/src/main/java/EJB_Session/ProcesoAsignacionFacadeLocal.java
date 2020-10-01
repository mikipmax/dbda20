/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.ProcesoAsignacion;
import java.util.List;
import javax.ejb.Local;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Mickmaxy
 */

public interface ProcesoAsignacionFacadeLocal {

    void create(ProcesoAsignacion procesoAsignacion);

    void edit(ProcesoAsignacion procesoAsignacion);

    void remove(ProcesoAsignacion procesoAsignacion);

    ProcesoAsignacion find(Object id);

    List<ProcesoAsignacion> findAll();

    List<ProcesoAsignacion> findRange(int[] range);

    int count();

    List<ProcesoAsignacion> validarCliente(String numCedula);
    List<ProcesoAsignacion> listarPrCliente(String numCedula);
}
