package Managed_beans;

import EJB_Entity.Empleado;
import EJB_Entity.EstadoCredito;
import EJB_Entity.ProcesoAsignacion;
import EJB_Entity.ProcesoCredito;
import EJB_Session.EmpleadoFacadeLocal;
import EJB_Session.EstadoCreditoFacade;
import EJB_Session.EstadoCreditoFacadeLocal;
import EJB_Session.ProcesoAsignacionFacadeLocal;
import EJB_Session.ProcesoCreditoFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "ManagedPrCredito")
@SessionScoped
public class ManagedPrCredito implements Serializable {

    @Inject
    private ProcesoCreditoFacadeLocal manejadorPrCredito;
    @Inject
    private EmpleadoFacadeLocal manejadorEmpleados;
    @Inject
    private EstadoCreditoFacadeLocal manejadorEstados;
    private EstadoCredito estadoCredito;
    List<Empleado> listaEmpleados;
    List<EstadoCredito> listaEstados;
    List<ProcesoCredito> listaProcesoCredito;
    private ProcesoCredito procesoCredito;

    @PostConstruct
    public void init() {
        procesoCredito = new ProcesoCredito();
        recuperarPrCredito();
    }

    public EstadoCredito getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(EstadoCredito estadoCredito) {
        this.estadoCredito = estadoCredito;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<EstadoCredito> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(List<EstadoCredito> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public List<ProcesoCredito> getListaProcesoCredito() {
        return listaProcesoCredito;
    }

    public void setListaProcesoCredito(List<ProcesoCredito> listaProcesoCredito) {
        this.listaProcesoCredito = listaProcesoCredito;
    }

    public ProcesoCredito getProcesoCredito() {
        return procesoCredito;
    }

    public void setProcesoCredito(ProcesoCredito procesoCredito) {
        this.procesoCredito = procesoCredito;
    }

    public void recuperarPrCredito() {
        try {
            listaProcesoCredito = manejadorPrCredito.findAll();
        } catch (Exception e) {
        }
    }

    public void recuperarEmp() {
        try {
            listaEmpleados = manejadorEmpleados.findAll();
        } catch (Exception e) {
        }
    }

    public void recuperarEstados() {
        try {
            listaEstados = manejadorEstados.findAll();
        } catch (Exception e) {
        }
    }

    public void llerFilaPrCre(ProcesoCredito procesoSeleccion) {
        /*llenarAux();
         llenarEstadosAux();*/
        procesoCredito = procesoSeleccion;
    }
}
