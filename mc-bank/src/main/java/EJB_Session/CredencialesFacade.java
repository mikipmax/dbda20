/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.Credenciales;
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
public class CredencialesFacade extends AbstractFacade<Credenciales> implements CredencialesFacadeLocal {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CredencialesFacade() {
        super(Credenciales.class);
    }
    
  @Override
    public Credenciales iniciarSesion(Credenciales cli) {
        Credenciales cliente = null;
        try {
            Query sql = em.createNamedQuery("Credenciales.validarUsuario")
                    .setParameter("usuario", cli.getUsuario())
                    .setParameter("clave", cli.getClave());
            List<Credenciales> listaclientes = sql.getResultList();
            if (!listaclientes.isEmpty()) {
                cliente = listaclientes.get(0);
            }
        } catch (Exception e) {
            throw e;
        }

        return cliente;
    }
    
}
