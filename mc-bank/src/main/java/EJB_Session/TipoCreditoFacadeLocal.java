/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Session;

import EJB_Entity.TipoCredito;
import java.util.List;

import javax.ejb.Local;




public interface TipoCreditoFacadeLocal {

    void create(TipoCredito tipoCredito);

    void edit(TipoCredito tipoCredito);

    void remove(TipoCredito tipoCredito);

    TipoCredito find(Object id);

    List<TipoCredito> findAll();

    List<TipoCredito> findRange(int[] range);

    int count();
    
}
