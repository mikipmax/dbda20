package Managed_beans;

import EJB_Entity.TipoCredito;
import EJB_Session.TipoCreditoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named( "ManagedTCredito")
@SessionScoped
public class ManagedTCredito implements Serializable {

    @Inject
    private TipoCreditoFacadeLocal manejadorTCredito;
    private TipoCredito tipoCredito;
    private List<TipoCredito> listaTcredito;

    @PostConstruct
    public void init() {
        tipoCredito = new TipoCredito();
        recuperarTCredito();
    }

    public TipoCredito getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(TipoCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public List<TipoCredito> getListaTcredito() {
        return listaTcredito;
    }

    public void setListaTcredito(List<TipoCredito> listaTcredito) {
        this.listaTcredito = listaTcredito;
    }

    public void grabarTCredito() {
        try {

            manejadorTCredito.create(tipoCredito);


        } catch (Exception e) {
        } finally {
            tipoCredito = new TipoCredito();
            recuperarTCredito();
        }
    }

    public void recuperarTCredito() {
        try {
            listaTcredito = manejadorTCredito.findAll();
        } catch (Exception e) {
        }

    }

    public void editarTcredito() {
        try {
            manejadorTCredito.edit(tipoCredito);

        } catch (Exception e) {
        } finally {
            tipoCredito = new TipoCredito();
            recuperarTCredito();
        }

    }

    public void leerFilaTcredito(TipoCredito tCreditoSeleccion) {
        tipoCredito = tCreditoSeleccion;
    }

    public void credS() {
        try {
            tipoCredito = new TipoCredito();
        } catch (Exception e) {
        }

    }
}
