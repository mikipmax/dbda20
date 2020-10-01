/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed_beans;

import EJB_Entity.DetalleEgreso;
import EJB_Entity.TipoEgreso;
import EJB_Session.DetalleEgresoFacadeLocal;
import EJB_Session.TipoEgresoFacadeLocal;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author stali
 */
@Named( "ManagedDetEgreso")
@SessionScoped
public class ManagedDetEgreso implements Serializable {

    @EJB
    private DetalleEgresoFacadeLocal manejadorDetEgreso;
    @EJB
    private TipoEgresoFacadeLocal manejadorTipoEgr;
    private DetalleEgreso detEgreso;
    private TipoEgreso tipoEgreso;
    private List<DetalleEgreso> listaDetEgreso;
    private List<TipoEgreso> listaTipoEgr;

    public DetalleEgreso getDetEgreso() {
        return detEgreso;
    }

    public void setDetEgreso(DetalleEgreso detEgreso) {
        this.detEgreso = detEgreso;
    }

    public List<DetalleEgreso> getListaDetEgreso() {
        return listaDetEgreso;
    }

    public void setListaDetEgreso(List<DetalleEgreso> listaDetEgreso) {
        this.listaDetEgreso = listaDetEgreso;
    }

    public TipoEgreso getTipoEgreso() {
        return tipoEgreso;
    }

    public void setTipoEgreso(TipoEgreso tipoEgreso) {
        this.tipoEgreso = tipoEgreso;
    }

    public List<TipoEgreso> getListaTipoEgr() {
        return listaTipoEgr;
    }

    public void setListaTipoEgr(List<TipoEgreso> listaTipoEgr) {
        this.listaTipoEgr = listaTipoEgr;
    }

    public void grabarDet() {
        try {

            listaTipoEgr = manejadorTipoEgr.findAll();

            for (int i = 1; i <= listaTipoEgr.size(); i++) {
                switch (i) {
                    case 1:
                        this.detEgreso.setValor(0.0);
                        break;
                    case 2:
                        this.detEgreso.setValor(0.0);
                        break;
                    case 3:
                        this.detEgreso.setValor(0.0);
                        break;
                    case 4:
                        this.detEgreso.setValor(0.0);
                        break;
                    case 5:
                        this.detEgreso.setValor(0.0);
                        break;
                }
                manejadorDetEgreso.create(detEgreso);
            }

        } catch (Exception e) {
        } finally {
        }
    }
}
