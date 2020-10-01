/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.NivelAcceso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mickmaxy
 */
public interface NivelAccesoFacadeLocal {

    void create(NivelAcceso nivelAcceso);

    void edit(NivelAcceso nivelAcceso);

    void remove(NivelAcceso nivelAcceso);

    NivelAcceso find(Object id);

    List<NivelAcceso> findAll();

    List<NivelAcceso> findRange(int[] range);

    int count();
    
}
