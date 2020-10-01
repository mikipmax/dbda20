/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.ProcesoAsignacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mickmaxy
 */
@ApplicationScoped
public class ProcesoAsignacionFacade extends AbstractFacade<ProcesoAsignacion> implements ProcesoAsignacionFacadeLocal {

    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProcesoAsignacionFacade() {
        super(ProcesoAsignacion.class);
    }

    @Override
    public List<ProcesoAsignacion> validarCliente(String numCedula) {

        try {

            Query sql = em.createNamedQuery("ProcesoAsignacion.findByEjecutivo").setParameter("ejecut", numCedula);
            List<ProcesoAsignacion> listaProcesoAsign = sql.getResultList();
            System.out.println("*-*******************");
            for (ProcesoAsignacion procesoAsignacion : listaProcesoAsign) {
                System.out.println(procesoAsignacion.getDniEmpleado().getDniEmpleado().getDni());
            }
            return listaProcesoAsign;

        } catch (Exception e) {
            throw e;
        }

    }
    
       @Override
    public List<ProcesoAsignacion> listarPrCliente(String numCedula) {

        try {

            Query sql = em.createNamedQuery("ProcesoAsignacion.findByCliente").setParameter("ejecut", numCedula);
            List<ProcesoAsignacion> listaProcesoAsign = sql.getResultList();
            System.out.println("*-*******************");
            for (ProcesoAsignacion procesoAsignacion : listaProcesoAsign) {
                System.out.println(procesoAsignacion.getIdProcesoCredito().getIdProcesoCredito());
            }
            return listaProcesoAsign;

        } catch (Exception e) {
            throw e;
        }

    }
}
