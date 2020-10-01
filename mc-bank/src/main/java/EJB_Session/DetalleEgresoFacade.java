/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.DetalleEgreso;
import java.util.ArrayList;
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
public class DetalleEgresoFacade extends AbstractFacade<DetalleEgreso> implements DetalleEgresoFacadeLocal {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleEgresoFacade() {
        super(DetalleEgreso.class);
    }

    @Override
    public List<DetalleEgreso> findByDni(String dni) {
        
        List<DetalleEgreso> lista;
        lista = new ArrayList();

        Query sql = em.createNamedQuery("DetalleEgreso.findByDniCliente").setParameter("dniCliente", dni);
        lista = sql.getResultList();

        return lista;
        
    }
    
}
