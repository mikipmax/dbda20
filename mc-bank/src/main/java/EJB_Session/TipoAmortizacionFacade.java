/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.TipoAmortizacion;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mickmaxy
 */
@ApplicationScoped
public class TipoAmortizacionFacade extends AbstractFacade<TipoAmortizacion> implements TipoAmortizacionFacadeLocal {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAmortizacionFacade() {
        super(TipoAmortizacion.class);
    }
    
}
