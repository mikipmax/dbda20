/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed_beans;

import EJB_Entity.ProcesoCredito;
import EJB_Entity.TipoAmortizacion;
import EJB_Entity.TipoCredito;
import EJB_Session.ProcesoCreditoFacadeLocal;
import EJB_Session.TipoAmortizacionFacadeLocal;
import EJB_Session.TipoCreditoFacadeLocal;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Mickmaxy
 */
@Named(  "ManagedSolCred")
@SessionScoped
public class ManagedSolCred implements Serializable {

    @Inject
    private ProcesoCreditoFacadeLocal manejadorProcesoCredito;
    @Inject
    private TipoCreditoFacadeLocal manejadorTipoCredito;
    @Inject
    private TipoAmortizacionFacadeLocal manejadorTam;
    private ProcesoCredito procesoCredito;
    private TipoCredito tipoCredito;
    private TipoAmortizacion tipoAmortizacion;
    List<ProcesoCredito> listaProcesoCredito;
    List<TipoCredito> listaTipoCredito;
    List<TipoAmortizacion> listaTam;

    @PostConstruct
    public void init() {
        procesoCredito = new ProcesoCredito();
        tipoCredito = new TipoCredito();
        tipoAmortizacion = new TipoAmortizacion();
        listarTc();
        listarTA();
    }

    public ProcesoCredito getProcesoCredito() {
        return procesoCredito;
    }

    public TipoCredito getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(TipoCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public TipoAmortizacion getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(TipoAmortizacion tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
    }

    public List<TipoCredito> getListaTipoCredito() {
        return listaTipoCredito;
    }

    public void setListaTipoCredito(List<TipoCredito> listaTipoCredito) {
        this.listaTipoCredito = listaTipoCredito;
    }

    public List<TipoAmortizacion> getListaTam() {
        return listaTam;
    }

    public void setListaTam(List<TipoAmortizacion> listaTam) {
        this.listaTam = listaTam;
    }

    public void setProcesoCredito(ProcesoCredito procesoCredito) {
        this.procesoCredito = procesoCredito;
    }

    public List<ProcesoCredito> getListaProcesoCredito() {
        return listaProcesoCredito;
    }

    public void setListaProcesoCredito(List<ProcesoCredito> listaProcesoCredito) {
        this.listaProcesoCredito = listaProcesoCredito;
    }

    public void insertarProCre() {
        try {

            int contador = Collections.max(manejadorProcesoCredito.findAll(), new Comparator<ProcesoCredito>() {
                @Override
                public int compare(ProcesoCredito o1, ProcesoCredito o2) {
                    return new Integer(o1.getIdProcesoCredito()).compareTo(o2.getIdProcesoCredito());

                }
            }).getIdProcesoCredito() + 1;
            System.out.println(contador);
            this.procesoCredito.setIdProcesoCredito(contador);

            this.procesoCredito.setIdTipoCredito(tipoCredito);
            this.procesoCredito.setIdTipoAmortizacion(tipoAmortizacion);
            manejadorProcesoCredito.create(procesoCredito);

        } catch (Exception e) {
        } finally {
            procesoCredito = new ProcesoCredito();
            tipoCredito = new TipoCredito();
            tipoAmortizacion = new TipoAmortizacion();
            listarTc();
            listarTA();
        }

    }

    public void listarTc() {
        listaTipoCredito = manejadorTipoCredito.findAll();
    }

    public void listarTA() {
        listaTam = manejadorTam.findAll();
    }
}
