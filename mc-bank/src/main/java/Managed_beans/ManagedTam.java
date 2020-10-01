package Managed_beans;

import EJB_Entity.TipoAmortizacion;
import EJB_Session.TipoAmortizacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named( "ManagedTam")
@SessionScoped
public class ManagedTam implements Serializable {

    @Inject
    private TipoAmortizacionFacadeLocal manejadorTAmortizacion;
    private TipoAmortizacion tipoAmortizacion;
    private List<TipoAmortizacion> listaTAmortizacion;

    @PostConstruct
    public void init() {
        tipoAmortizacion = new TipoAmortizacion();
        recuperarTAmortizacion();

    }

    public TipoAmortizacion getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(TipoAmortizacion tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
    }

    public List<TipoAmortizacion> getListaTAmortizacion() {
        return listaTAmortizacion;
    }

    public void setListaTAmortizacion(List<TipoAmortizacion> listaTAmortizacion) {
        this.listaTAmortizacion = listaTAmortizacion;
    }

    public void grabarTAmortizacion() {
        try {

            manejadorTAmortizacion.create(tipoAmortizacion);

        } catch (Exception e) {
        } finally {
            tipoAmortizacion = new TipoAmortizacion();
            recuperarTAmortizacion();
        }

    }

    public void recuperarTAmortizacion() {
        try {
            listaTAmortizacion = manejadorTAmortizacion.findAll();
        } catch (Exception e) {
        }

    }

    public void editarTam() {
        try {
            manejadorTAmortizacion.edit(tipoAmortizacion);

        } catch (Exception e) {
        } finally {
            tipoAmortizacion = new TipoAmortizacion();
            recuperarTAmortizacion();
        }

    }

    public void leerFilaTam(TipoAmortizacion tAmSelccion) {
        tipoAmortizacion = tAmSelccion;

    }

    public void salir() {

        tipoAmortizacion = new TipoAmortizacion();
    }
}
