/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Mickmaxy
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
    	getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
    	getEntityManager().getTransaction().commit();
    }

    public void edit(T entity) {
    	getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
    	getEntityManager().getTransaction().commit();
    }

    public void remove(T entity) {
    	getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
    	getEntityManager().getTransaction().commit();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
   
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
