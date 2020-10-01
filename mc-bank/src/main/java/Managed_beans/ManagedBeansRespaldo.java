package Managed_beans;

//verificar q cada vez q se crea un empleado con su respectivo cargo , se empareje con nivel de acceso, por ejemplo
//si ingreso cargo 1 deberia darme nivel de acceso 2 pero esta dando nivel de acceso 1 revisar eso
//verificar tmb que cuando edito un cargo se sincronice con su nivel de acceso
import EJB_Entity.Cargo;
import EJB_Entity.Cliente;
import EJB_Entity.Credenciales;
import EJB_Entity.Empleado;
import EJB_Entity.NivelAcceso;
import EJB_Entity.Persona;
import EJB_Entity.ProcesoAsignacion;
import EJB_Entity.TipoAmortizacion;
import EJB_Entity.TipoCredito;
import EJB_Session.CargoFacadeLocal;
import EJB_Session.ClienteFacadeLocal;
import EJB_Session.CredencialesFacadeLocal;
import EJB_Session.EmpleadoFacadeLocal;
import EJB_Session.NivelAccesoFacade;
import EJB_Session.NivelAccesoFacadeLocal;
import EJB_Session.PersonaFacade;
import EJB_Session.PersonaFacadeLocal;
import EJB_Session.ProcesoAsignacionFacadeLocal;
import EJB_Session.TipoAmortizacionFacadeLocal;
import EJB_Session.TipoCreditoFacadeLocal;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "ManagedBeans1")
@SessionScoped
public class ManagedBeansRespaldo implements Serializable {

    /*Manejador de las entidades*/
    @Inject
    private CredencialesFacadeLocal manejadorCredenciales;
    @Inject
    private CargoFacadeLocal manejadorCargos;
    @Inject
    private EmpleadoFacadeLocal manejadorEmpleados;
    @Inject
    ClienteFacadeLocal manejadorClientes;
    @Inject
    PersonaFacadeLocal manejadorPersonas;
    @Inject
    ProcesoAsignacionFacadeLocal manejadorProcesoAsign;
    private List<ProcesoAsignacion> listaEjecutivoProceso;
    private Credenciales credenciales;
    private Cargo cargo;
    private Persona persona;
    private Empleado empleado;
    private TipoAmortizacion tipoAmort;
    private Cliente cliente;
    private TipoCredito tipoCredito;
    private ProcesoAsignacion prAs;
    private NivelAcceso nivelAcceso;
    private String dniAdmin;
    private String nombreAdmin;
    private String apeAdmin;
    private String teleAdmin;
    private char generoAdmin;
    private String emailAdmin;
    private String celAdmin;
    private String dniEjec;
    private String nombreEjec;
    private String apeEjec;
    private String teleEjec;
    private char generoEjec;
    private String emailEjec;
    private String celEjec;
    private String dniCliente;
    private String nombreCliente;
    private String apeCliente;
    private String teleCliente;
    private char generoCliente;
    private String emailCliente;
    private String celCliente;
    private String cargoAdmin;
    private String cargoEjec;
    private int idcargoAdmin;
    private int idcargoEjec;
    private String usuarioAdmin;
    private String claveAdmin;
    private String usuarioEjec;
    private String claveEjec;
    private String usuarioCliente;
    private String claveCliente;
    private int idCredAdmin;
    private int idCredEjec;
    private int idCredCliente;
    private boolean baneadoAdmin;
    private int nivelAdmin;
    private boolean baneadoEjec;
    private int nivelEjec;
    private boolean baneadoCliente;
    private int nivelCliente;

    @PostConstruct
    public void init() {
        cargo = new Cargo();
        persona = new Persona();
        credenciales = new Credenciales();
        empleado = new Empleado();
        cliente = new Cliente();
        tipoAmort = new TipoAmortizacion();
        credenciales = new Credenciales();
        tipoCredito = new TipoCredito();
        prAs = new ProcesoAsignacion();
        nivelAcceso = new NivelAcceso();


    }

    public String getDniAdmin() {
        return dniAdmin;
    }

    public List<ProcesoAsignacion> getListaEjecutivoProceso() {
        return listaEjecutivoProceso;
    }

    public void setListaEjecutivoProceso(List<ProcesoAsignacion> listaEjecutivoProceso) {
        this.listaEjecutivoProceso = listaEjecutivoProceso;
    }

    public void setDniAdmin(String dniAdmin) {
        this.dniAdmin = dniAdmin;
    }

    public String getNombreAdmin() {
        return nombreAdmin;
    }

    public void setNombreAdmin(String nombreAdmin) {
        this.nombreAdmin = nombreAdmin;
    }

    public String getApeAdmin() {
        return apeAdmin;
    }

    public void setApeAdmin(String apeAdmin) {
        this.apeAdmin = apeAdmin;
    }

    public String getTeleAdmin() {
        return teleAdmin;
    }

    public void setTeleAdmin(String teleAdmin) {
        this.teleAdmin = teleAdmin;
    }

    public char getGeneroAdmin() {
        return generoAdmin;
    }

    public void setGeneroAdmin(char generoAdmin) {
        this.generoAdmin = generoAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getCelAdmin() {
        return celAdmin;
    }

    public void setCelAdmin(String celAdmin) {
        this.celAdmin = celAdmin;
    }

    public String getDniEjec() {
        return dniEjec;
    }

    public void setDniEjec(String dniEjec) {
        this.dniEjec = dniEjec;
    }

    public String getNombreEjec() {
        return nombreEjec;
    }

    public void setNombreEjec(String nombreEjec) {
        this.nombreEjec = nombreEjec;
    }

    public String getApeEjec() {
        return apeEjec;
    }

    public void setApeEjec(String apeEjec) {
        this.apeEjec = apeEjec;
    }

    public String getTeleEjec() {
        return teleEjec;
    }

    public void setTeleEjec(String teleEjec) {
        this.teleEjec = teleEjec;
    }

    public char getGeneroEjec() {
        return generoEjec;
    }

    public void setGeneroEjec(char generoEjec) {
        this.generoEjec = generoEjec;
    }

    public String getEmailEjec() {
        return emailEjec;
    }

    public void setEmailEjec(String emailEjec) {
        this.emailEjec = emailEjec;
    }

    public String getCelEjec() {
        return celEjec;
    }

    public void setCelEjec(String celEjec) {
        this.celEjec = celEjec;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }

    public String getTeleCliente() {
        return teleCliente;
    }

    public void setTeleCliente(String teleCliente) {
        this.teleCliente = teleCliente;
    }

    public char getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(char generoCliente) {
        this.generoCliente = generoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getCelCliente() {
        return celCliente;
    }

    public void setCelCliente(String celCliente) {
        this.celCliente = celCliente;
    }

    public String getCargoAdmin() {
        return cargoAdmin;
    }

    public void setCargoAdmin(String cargoAdmin) {
        this.cargoAdmin = cargoAdmin;
    }

    public String getCargoEjec() {
        return cargoEjec;
    }

    public void setCargoEjec(String cargoEjec) {
        this.cargoEjec = cargoEjec;
    }

    public int getIdcargoAdmin() {
        return idcargoAdmin;
    }

    public void setIdcargoAdmin(int idcargoAdmin) {
        this.idcargoAdmin = idcargoAdmin;
    }

    public int getIdcargoEjec() {
        return idcargoEjec;
    }

    public void setIdcargoEjec(int idcargoEjec) {
        this.idcargoEjec = idcargoEjec;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public void setUsuarioAdmin(String usuarioAdmin) {
        this.usuarioAdmin = usuarioAdmin;
    }

    public String getClaveAdmin() {
        return claveAdmin;
    }

    public void setClaveAdmin(String claveAdmin) {
        this.claveAdmin = claveAdmin;
    }

    public String getUsuarioEjec() {
        return usuarioEjec;
    }

    public void setUsuarioEjec(String usuarioEjec) {
        this.usuarioEjec = usuarioEjec;
    }

    public String getClaveEjec() {
        return claveEjec;
    }

    public void setClaveEjec(String claveEjec) {
        this.claveEjec = claveEjec;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(String claveCliente) {
        this.claveCliente = claveCliente;
    }

    public int getIdCredAdmin() {
        return idCredAdmin;
    }

    public void setIdCredAdmin(int idCredAdmin) {
        this.idCredAdmin = idCredAdmin;
    }

    public int getIdCredEjec() {
        return idCredEjec;
    }

    public void setIdCredEjec(int idCredEjec) {
        this.idCredEjec = idCredEjec;
    }

    public int getIdCredCliente() {
        return idCredCliente;
    }

    public void setIdCredCliente(int idCredCliente) {
        this.idCredCliente = idCredCliente;
    }

    public boolean isBaneadoAdmin() {
        return baneadoAdmin;
    }

    public void setBaneadoAdmin(boolean baneadoAdmin) {
        this.baneadoAdmin = baneadoAdmin;
    }

    public int getNivelAdmin() {
        return nivelAdmin;
    }

    public void setNivelAdmin(int nivelAdmin) {
        this.nivelAdmin = nivelAdmin;
    }

    public boolean isBaneadoEjec() {
        return baneadoEjec;
    }

    public void setBaneadoEjec(boolean baneadoEjec) {
        this.baneadoEjec = baneadoEjec;
    }

    public int getNivelEjec() {
        return nivelEjec;
    }

    public void setNivelEjec(int nivelEjec) {
        this.nivelEjec = nivelEjec;
    }

    public boolean isBaneadoCliente() {
        return baneadoCliente;
    }

    public void setBaneadoCliente(boolean baneadoCliente) {
        this.baneadoCliente = baneadoCliente;
    }

    public int getNivelCliente() {
        return nivelCliente;
    }

    public void setNivelCliente(int nivelCliente) {
        this.nivelCliente = nivelCliente;
    }

    public String getEmpleadoAuxiliar() {
        return dniAdmin;
    }

    public void setEmpleadoAuxiliar(String empleadoAuxiliar) {
        this.dniAdmin = empleadoAuxiliar;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoAmortizacion getTipoAmort() {
        return tipoAmort;
    }

    public void setTipoAmort(TipoAmortizacion tipoAmort) {
        this.tipoAmort = tipoAmort;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCredito getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(TipoCredito tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public ProcesoAsignacion getPrAs() {
        return prAs;
    }

    public void setPrAs(ProcesoAsignacion prAs) {
        this.prAs = prAs;
    }

    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /*Respectivos getters y setters para cada Entidad */
    public Credenciales getCredenciales() {
        return credenciales;
    }

    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    public void editarAdmin() {

        try {



            persona = manejadorPersonas.find(dniAdmin);


            this.persona.setTelefono(teleAdmin);
            this.persona.setEmail(emailAdmin);
            this.persona.setCelular(celAdmin);

            manejadorPersonas.edit(persona);

            //siempre verificar q se este haciendo referencia a la tabla hija
            //para evitar q el edit se convierta en create
            empleado = manejadorEmpleados.find(dniAdmin);
            credenciales = manejadorCredenciales.find(empleado.getIdCredenciales().getIdCredenciales());
            System.out.println(credenciales.getIdCredenciales());

            this.credenciales.setUsuario(usuarioAdmin);
            this.credenciales.setClave(claveAdmin);


            manejadorCredenciales.edit(credenciales);
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "DATOS GUARDADOS CORRECTAMENTE"));


        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "Usuario ya existe"));
            empleado = manejadorEmpleados.find(dniAdmin);
            credenciales = manejadorCredenciales.find(empleado.getIdCredenciales().getIdCredenciales());
            usuarioAdmin = credenciales.getUsuario();
            e.getMessage();
        } finally {
        }

    }

    public void editarCliente() {

        try {



            persona = manejadorPersonas.find(dniAdmin);


            this.persona.setTelefono(teleAdmin);
            this.persona.setEmail(emailAdmin);
            this.persona.setCelular(celAdmin);

            manejadorPersonas.edit(persona);

            //siempre verificar q se este haciendo referencia a la tabla hija
            //para evitar q el edit se convierta en create
            cliente = manejadorClientes.find(dniAdmin);
            credenciales = manejadorCredenciales.find(cliente.getIdCredenciales().getIdCredenciales());
            System.out.println(credenciales.getIdCredenciales());

            this.credenciales.setUsuario(usuarioAdmin);
            this.credenciales.setClave(claveAdmin);


            manejadorCredenciales.edit(credenciales);
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "DATOS GUARDADOS CORRECTAMENTE"));


        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "Usuario ya existe"));
            cliente = manejadorClientes.find(dniAdmin);
            credenciales = manejadorCredenciales.find(cliente.getIdCredenciales().getIdCredenciales());
            usuarioAdmin = credenciales.getUsuario();
            e.getMessage();
        } finally {
        }

    }
    /*Método del logging*/

    public String iniciarSesion() {

        Credenciales cli;
        String redireccion = null;

        try {

            cli = manejadorCredenciales.iniciarSesion(credenciales);
            if (cli != null) {
                //almacenar en la sesión de JSF
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", cli);
//                if (cli.getIdNivelAcceso().getIdNivelAcceso() == 3) {
//                  
//                }





                System.out.println(cli.getIdNivelAcceso().getIdNivelAcceso() + "-----------------------------------------------");
                switch (cli.getIdNivelAcceso().getIdNivelAcceso()) {
                    case 1:
                        dniAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getDni();
                        nombreAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getNombre();
                        apeAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getApellido();
                        teleAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getTelefono();
                        celAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getCelular();
                        generoAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getGenero();
                        emailAdmin = manejadorClientes.find(cli.getDni().getDni()).getDniCliente().getEmail();

                        usuarioAdmin = manejadorClientes.find(cli.getDni().getDni()).getIdCredenciales().getUsuario();
                        claveAdmin = manejadorClientes.find(cli.getDni().getDni()).getIdCredenciales().getClave();
                        redireccion = "/Cliente?faces-redirect=true";
                        break;
                    case 2:
                        dniAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getDni();
                        nombreAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getNombre();
                        apeAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getApellido();
                        teleAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getTelefono();
                        celAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getCelular();
                        generoAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getGenero();
                        emailAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getEmail();
                        cargoAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCargo().getCargo();
                        usuarioAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCredenciales().getUsuario();
                        claveAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCredenciales().getClave();
                        redireccion = "/Ejecutivo?faces-redirect=true";
                        break;
                    case 3:

                        dniAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getDni();
                        nombreAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getNombre();
                        apeAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getApellido();
                        teleAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getTelefono();
                        celAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getCelular();
                        generoAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getGenero();
                        emailAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getDniEmpleado().getEmail();
                        cargoAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCargo().getCargo();
                        usuarioAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCredenciales().getUsuario();
                        System.out.println(usuarioAdmin);
                        claveAdmin = manejadorEmpleados.find(cli.getDni().getDni()).getIdCredenciales().getClave();
                        redireccion = "/Administrador?faces-redirect=true";
                        break;

                }


                //  this.recuperarClientes();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error ..."));
            e.printStackTrace();
        }
        return redireccion;
    }

    public void recuperarListaEjecutivoProceso() {
    }
}
