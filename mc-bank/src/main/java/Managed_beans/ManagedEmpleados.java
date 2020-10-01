package Managed_beans;

import EJB_Entity.Cargo;
import EJB_Entity.Credenciales;
import EJB_Entity.Empleado;
import EJB_Entity.Persona;
import EJB_Session.CargoFacadeLocal;
import EJB_Session.CredencialesFacadeLocal;
import EJB_Session.EmpleadoFacadeLocal;
import EJB_Session.NivelAccesoFacadeLocal;
import EJB_Session.PersonaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;

@Named(  "ManagedEmpleado")
@SessionScoped
public class ManagedEmpleados implements Serializable {

    @Inject
    private CredencialesFacadeLocal manejadorCredenciales;
    @Inject
    private EmpleadoFacadeLocal manejadorEmpleado;
    @Inject
    private CargoFacadeLocal manejadorCargo;
    @Inject
    private NivelAccesoFacadeLocal manejadorNivelAcceso;
    private Persona persona;
    private Credenciales credenciales;
    private Empleado empleado;
    private Empleado empleadoAux;
    private Cargo cargo;
    private List<Cargo> listaCargos;
    private List<Empleado> listaEmpleados;
    private List<Empleado> listaEmpAux;
    private String usuario_comp;
    private static String obtRes;

    @PostConstruct
    public void init() {

        persona = new Persona();
        credenciales = new Credenciales();
        cargo = new Cargo();
        empleado = new Empleado();
        empleadoAux = new Empleado();
        recuperarTCargo();
        recuperarEmpleado();
        llenarAux();

    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Credenciales getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleadoAux() {
        return empleadoAux;
    }

    public void setEmpleadoAux(Empleado empleadoAux) {
        this.empleadoAux = empleadoAux;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public List<Empleado> getListaEmpAux() {
        return listaEmpAux;
    }

    public void setListaEmpAux(List<Empleado> listaEmpAux) {
        this.listaEmpAux = listaEmpAux;
    }

    public void grabarEmpleado() {
        try {

            this.credenciales.setDni(persona);

            this.credenciales.setIdNivelAcceso(manejadorNivelAcceso.find(cargo.getIdCargo() + 1));
            manejadorCredenciales.create(credenciales);
            empleado.setDniEmpleado(persona);
            empleado.setIdCredenciales(credenciales);
            empleado.setIdCargo(cargo);
            manejadorEmpleado.create(empleado);
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "DATOS GUARDADOS"));
        } catch (Exception e) {
        } finally {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "DNI O USUARIO DUPLICADO"));
            persona = new Persona();
            credenciales = new Credenciales();


            empleado = new Empleado();
            recuperarTCargo();
            recuperarEmpleado();
            llenarAux();
        }
    }

    public void recuperarEmpleado() {
        try {

            listaEmpleados = manejadorEmpleado.findAll();



        } catch (Exception e) {
        }

    }

    public void recuperarTCargo() {
        try {
            listaCargos = manejadorCargo.findAll();
        } catch (Exception e) {
        }

    }

    /**
     * Revisar error al no cambiar el usuario
     */
    public void editarEmpleado() {
        try {
            System.out.println("dssdf");

            this.empleado.setIdCargo(empleado.getIdCargo());

            manejadorEmpleado.edit(empleado);
            //siempre verificar q se este haciendo referencia a la tabla hija
            //para evitar q el edit se convierta en create
            this.credenciales.setIdCredenciales(empleado.getIdCredenciales().getIdCredenciales());
            this.credenciales.setDni(empleado.getDniEmpleado());
            this.credenciales.setUsuario(empleado.getIdCredenciales().getUsuario());
            this.credenciales.setClave(empleado.getIdCredenciales().getClave());
            this.credenciales.setIdNivelAcceso(manejadorNivelAcceso.find(empleado.getIdCargo().getIdCargo() + 1));
            this.credenciales.setBaneado(empleado.getIdCredenciales().getBaneado());
            manejadorCredenciales.edit(credenciales);


        } catch (Exception e) {
            e.getMessage();
        } finally {
            empleado = new Empleado();
            credenciales = new Credenciales();
            recuperarTCargo();
            recuperarEmpleado();

            llenarAux();
        }

    }

    public void leerFilaEmpleado(Empleado empleadoSeleccion) {



//este debe ir primero porq si no me sale en null el empleado seleccionado
        llenarAux();


        empleado = empleadoSeleccion;

        // System.out.println(empleado.getIdCredenciales().getDni().getDni());

        // usuario_comp = empleado.getIdCredenciales().getUsuario();



    }

    public void llenarAux() {
        try {
            listaEmpAux = new ArrayList<>();
            recuperarTCargo();

            for (int i = 0; i < listaCargos.size(); i++) {

                empleado = new Empleado();
                empleado.setIdCargo(listaCargos.get(i));
                listaEmpAux.add(empleado);
            }
        } catch (Exception e) {
        }


    }

    public void verificarUsuarioExistente() {

        try {

            obtRes = "";

            if (!credenciales.getUsuario().isEmpty()) {
                List<Credenciales> uss = manejadorCredenciales.findAll();
                for (Credenciales credenciales1 : uss) {
                    if (credenciales.getUsuario().equals(credenciales1.getUsuario())) {

                        obtRes = "Usuario ya existe";
                    }
                }
            }



        } catch (Exception e) {
        }
    }
//Método para enviar a un label el valor de "usuario ya existe"

    public String prueba() {

        return obtRes;
    }

    public void empSalida() {
        System.out.println("haha");
    }

    public void salir() {

        empleado = new Empleado();
        credenciales = new Credenciales();



    }

    public String us_habilitado() {

        String s = "No";
        if (empleado.getIdCredenciales().getBaneado()) {
            s = "Si";
        }
        return s;
    }
}
