/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed_beans;

import EJB_Entity.Credenciales;
import EJB_Entity.ProcesoAsignacion;
import EJB_Session.ProcesoAsignacionFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "plantillaController")
@SessionScoped
public class plantillaController implements Serializable {

    @Inject
    ProcesoAsignacionFacadeLocal manejadorProcesoAsign;
    private String ejec;
    private String cli;
    private List<ProcesoAsignacion> listaEjecutivoProceso;
    private List<ProcesoAsignacion> listaClienteProceso;
    private ProcesoAsignacion procesAsignacion;
    //cliente es de tipo 1
    //ejecutivo es de tipo 2
    //ejecutivo es de tipo 3
    @PostConstruct
    public void init() {
        procesAsignacion = new ProcesoAsignacion();
    }

    public List<ProcesoAsignacion> getListaEjecutivoProceso() {
        return listaEjecutivoProceso;
    }

    public String getCli() {
        return cli;
    }

    public ProcesoAsignacion getProcesAsignacion() {
        return procesAsignacion;
    }

    public void setProcesAsignacion(ProcesoAsignacion procesAsignacion) {
        this.procesAsignacion = procesAsignacion;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public List<ProcesoAsignacion> getListaClienteProceso() {
        return listaClienteProceso;
    }

    public void setListaClienteProceso(List<ProcesoAsignacion> listaClienteProceso) {
        this.listaClienteProceso = listaClienteProceso;
    }

    public void setListaEjecutivoProceso(List<ProcesoAsignacion> listaEjecutivoProceso) {
        this.listaEjecutivoProceso = listaEjecutivoProceso;
    }

    public String getEjec() {
        return ejec;
    }

    public void setEjec(String ejec) {
        this.ejec = ejec;
    }

    public void verificarSesionCliente() {
        verificarSesiones(2, 3);
        listaClienteProceso = manejadorProcesoAsign.listarPrCliente(cli);
    }

    public void verificarSesionEjec() {
        verificarSesiones(1, 3);
        listaEjecutivoProceso = manejadorProcesoAsign.validarCliente(ejec);

    }

    public void verificarSesionAdmin() {
        verificarSesiones(1, 2);
    }
//verifico q cada tipo de usuario solo vea su información respectiva 

    public void verificarSesiones(int a, int b) {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            Credenciales us = (Credenciales) context.getExternalContext().getSessionMap().get("usuario");


            if (us == null || us.getIdNivelAcceso().getIdNivelAcceso() == a || us.getIdNivelAcceso().getIdNivelAcceso() == b) {
                context.getExternalContext().redirect("signin.xhtml");
            } else if (us.getIdNivelAcceso().getIdNivelAcceso() == 2) {
                ejec = us.getDni().getDni();
            } else if (us.getIdNivelAcceso().getIdNivelAcceso() == 1) {
                cli = us.getDni().getDni();
            }
        } catch (Exception e) {
        }
    }

    public void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
     public void llerFilaPr(ProcesoAsignacion procesoSeleccion) {
     procesAsignacion=procesoSeleccion;
         System.out.println(procesAsignacion+"asfasfasdf");
     }
}