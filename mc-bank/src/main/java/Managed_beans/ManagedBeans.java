package Managed_beans;

//verificar q cada vez q se crea un empleado con su respectivo cargo , se empareje con nivel de acceso, por ejemplo
//si ingreso cargo 1 deberia darme nivel de acceso 2 pero esta dando nivel de acceso 1 revisar eso
//verificar tmb que cuando edito un cargo se sincronice con su nivel de acceso
import EJB_Entity.Cargo;
import EJB_Entity.Cliente;
import EJB_Entity.Credenciales;
import EJB_Entity.DetalleEgreso;
import EJB_Entity.Empleado;
import EJB_Entity.NivelAcceso;
import EJB_Entity.Persona;
import EJB_Entity.ProcesoAsignacion;
import EJB_Entity.ProcesoCredito;
import EJB_Entity.TipoAmortizacion;
import EJB_Entity.TipoCredito;
import EJB_Session.CargoFacadeLocal;
import EJB_Session.ClienteFacadeLocal;
import EJB_Session.CredencialesFacadeLocal;
import EJB_Session.DetalleEgresoFacadeLocal;
import EJB_Session.EmpleadoFacadeLocal;
import EJB_Session.EstadoCreditoFacadeLocal;
import EJB_Session.NivelAccesoFacade;
import EJB_Session.NivelAccesoFacadeLocal;
import EJB_Session.PersonaFacade;
import EJB_Session.PersonaFacadeLocal;
import EJB_Session.ProcesoAsignacionFacadeLocal;
import EJB_Session.ProcesoCreditoFacadeLocal;
import EJB_Session.TipoAmortizacionFacadeLocal;
import EJB_Session.TipoCreditoFacadeLocal;
import static Utilitarios.Controlador.variarFecha;
import Utilitarios.TablaAmortizacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Named(value ="ManagedBeans")
@SessionScoped
public class ManagedBeans implements Serializable {

  
	private static final long serialVersionUID = 1L;
	/*Manejador de las entidades*/
    @Inject
    private CredencialesFacadeLocal manejadorCredenciales;
    @Inject
    private CargoFacadeLocal manejadorCargos;
    @Inject
    private EmpleadoFacadeLocal manejadorEmpleados;
    @Inject
    private ClienteFacadeLocal manejadorClientes;
    @Inject
    private PersonaFacadeLocal manejadorPersonas;
    @Inject
    private ProcesoAsignacionFacadeLocal manejadorProcesoAsign;
    @Inject
    private TipoCreditoFacadeLocal manejadorTipoCredito;
    @Inject
    private TipoAmortizacionFacadeLocal manejadorTam;
    @Inject
    private ProcesoCreditoFacadeLocal manejadorProcesoCredito;
    @Inject
    private EstadoCreditoFacadeLocal manejadorEstadoCredito;
    @Inject
    private DetalleEgresoFacadeLocal manejadorDetEgreso;
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
    private static Date fechaInit;
    private static Date fechaC;
    //Variables y todo para Datos Financieros del Cliente
    private Double ingreso;
    private Double egreso;
    private Double capPago;
    private Double egrAlim;
    private Double egrSB;
    private Double egrTrans;
    private Double egrCoutaOC;
    private Double egrPagoTC;
    private DetalleEgreso detEgreso;
    private List<DetalleEgreso> detPorCliente;
    private static double pCuota;
    /**
     * variables y listas para la inserciciÃ³n de un proceso de crÃ©dito
     *
     */
    private ProcesoCredito procesoCredito;
    private TipoCredito tipoCredito2;
    private TipoAmortizacion tipoAmortizacion;
    private List<ProcesoCredito> listaProcesoCredito;
    private List<TipoCredito> listaTipoCredito;
    private List<TipoAmortizacion> listaTam;
    //------------------------------------------------------------------
//---------------------------------------------------------------------
    //Para insertar proceso de credito con tabla de amortizaciÃ³n
    private TablaAmortizacion tb;
    private List<TablaAmortizacion> tbAmortizacion;
    private Integer indiceTA;
    private Integer npagos;
    private double tasa;
    private double capital;

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
        procesoCredito = new ProcesoCredito();
        tipoCredito2 = new TipoCredito();
        tipoAmortizacion = new TipoAmortizacion();
        listarTc();
        listarTA();


    }

    public Double getIngreso() {
        return ingreso;
    }

    public void setIngreso(Double ingreso) {
        this.ingreso = ingreso;
    }

    public Double getEgreso() {
        return egreso;
    }

    public void setEgreso(Double egreso) {
        this.egreso = egreso;
    }

    public Double getCapPago() {
        return capPago;
    }

    public void setCapPago(Double capPago) {
        this.capPago = capPago;
    }

    public Double getEgrAlim() {
        return egrAlim;
    }

    public void setEgrAlim(Double egrAlim) {
        this.egrAlim = egrAlim;
    }

    public Double getEgrSB() {
        return egrSB;
    }

    public void setEgrSB(Double egrSB) {
        this.egrSB = egrSB;
    }

    public Double getEgrTrans() {
        return egrTrans;
    }

    public void setEgrTrans(Double egrTrans) {
        this.egrTrans = egrTrans;
    }

    public Double getEgrCoutaOC() {
        return egrCoutaOC;
    }

    public void setEgrCoutaOC(Double egrCoutaOC) {
        this.egrCoutaOC = egrCoutaOC;
    }

    public Double getEgrPagoTC() {
        return egrPagoTC;
    }

    public void setEgrPagoTC(Double egrPagoTC) {
        this.egrPagoTC = egrPagoTC;
    }

    public String getDniAdmin() {
        return dniAdmin;
    }

    public List<ProcesoAsignacion> getListaEjecutivoProceso() {
        return listaEjecutivoProceso;
    }

    public ProcesoCredito getProcesoCredito() {
        return procesoCredito;
    }

    public void setProcesoCredito(ProcesoCredito procesoCredito) {
        this.procesoCredito = procesoCredito;
    }

    public TipoCredito getTipoCredito2() {
        return tipoCredito2;
    }

    public void setTipoCredito2(TipoCredito tipoCredito2) {
        this.tipoCredito2 = tipoCredito2;
    }

    public TipoAmortizacion getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(TipoAmortizacion tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
    }

    public List<ProcesoCredito> getListaProcesoCredito() {
        return listaProcesoCredito;
    }

    public void setListaProcesoCredito(List<ProcesoCredito> listaProcesoCredito) {
        this.listaProcesoCredito = listaProcesoCredito;
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

    //MÃ‰TODO PARA LOS DATOS FINANCIEROS DEL CLIENTE
    public void editarClienteDF() {

        try {
           
            cliente = manejadorClientes.find(dniAdmin);
            this.egreso = this.egrAlim + this.egrSB + this.egrTrans + this.egrCoutaOC + this.egrPagoTC;
            this.capPago = this.ingreso - this.egreso;
            this.cliente.setValorIngreso(ingreso);
            this.cliente.setValorEgreso(egreso);
            this.cliente.setCapacidadPago(capPago);

            manejadorClientes.edit(cliente);
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "DATOS GUARDADOS CORRECTAMENTE"));

        } catch (Exception e) {
            e.getMessage();
        } finally {
        }

    }

    public void editarDetalleEgreso() {
        try {
           
            detPorCliente = manejadorDetEgreso.findByDni(dniAdmin);
            for (int i = 0; i < detPorCliente.size(); i++) {
                detEgreso = manejadorDetEgreso.find(detPorCliente.get(i).getIdDetalleEgreso());
                switch (detPorCliente.get(i).getIdTipoEgreso().getIdTipoEgreso()) {
                    case 1:
                        this.detEgreso.setValor(egrAlim);
                        break;
                    case 2:
                        this.detEgreso.setValor(egrSB);
                        break;
                    case 3:
                        this.detEgreso.setValor(egrTrans);
                        break;
                    case 4:
                        this.detEgreso.setValor(egrCoutaOC);
                        break;
                    case 5:
                        this.detEgreso.setValor(egrPagoTC);
                        break;
                }
                manejadorDetEgreso.edit(detEgreso);
            }
            editarClienteDF();
        } catch (Exception e) {
            e.getMessage();
        } finally {
        }
    }
    /*MÃ©todo del logging*/

    public String iniciarSesion() {

        Credenciales cli;
        String redireccion = null;

        try {

            cli = manejadorCredenciales.iniciarSesion(credenciales);
            if (cli != null) {
                //almacenar en la sesiÃ³n de JSF
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

                        asignaDet(cli);

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

    //MÃ©todo para asignar los valores en la pantalla del cliente
    public void asignaDet(Credenciales cli) {
        detPorCliente = manejadorDetEgreso.findByDni(cli.getDni().getDni());
        if (!detPorCliente.isEmpty()) {
            ingreso = manejadorClientes.find(cli.getDni().getDni()).getValorIngreso();
            egreso = manejadorClientes.find(cli.getDni().getDni()).getValorEgreso();
            capPago = manejadorClientes.find(cli.getDni().getDni()).getCapacidadPago();
            egrAlim = detPorCliente.get(0).getValor();
            egrSB = detPorCliente.get(1).getValor();
            egrTrans = detPorCliente.get(2).getValor();
            egrCoutaOC = detPorCliente.get(3).getValor();
            egrPagoTC = detPorCliente.get(4).getValor();
        } else {
            egrAlim = 0.0;
            egrSB = 0.0;
            egrTrans = 0.0;
            egrCoutaOC = 0.0;
            egrPagoTC = 0.0;
        }
    }

    public void insertarProCre() {
        try {
    
            if (manejadorClientes.find(dniAdmin).getCapacidadPago()>pCuota) {
                   
           int contador = Collections.max(manejadorProcesoCredito.findAll(), new Comparator<ProcesoCredito>() {
                @Override
                public int compare(ProcesoCredito o1, ProcesoCredito o2) {
                    return new Integer(o1.getIdProcesoCredito()).compareTo(o2.getIdProcesoCredito());

                }
            }).getIdProcesoCredito() + 1;
            System.out.println(contador);
            this.procesoCredito.setIdProcesoCredito(contador);
            System.out.println(capital);
            this.procesoCredito.setIdTipoCredito(tipoCredito2);
            this.procesoCredito.setIdTipoAmortizacion(manejadorTam.find(indiceTA));
            this.procesoCredito.setPlazo(npagos);
            this.procesoCredito.setMonto(capital);
            this.procesoCredito.setDniCliente(manejadorClientes.find(dniAdmin));
            this.procesoCredito.setFechaInicio(fechaInit);
            this.procesoCredito.setFechaCierre(fechaC);

            manejadorProcesoCredito.create(procesoCredito);
            this.prAs.setIdProcesoCredito(procesoCredito);
            this.prAs.setIdEstado(manejadorEstadoCredito.find(1));
            this.prAs.setDniEmpleado(manejadorEmpleados.find("4"));
            manejadorProcesoAsign.create(prAs);
//                   FacesContext context = FacesContext.getCurrentInstance();
//
//            context.addMessage(null, new FacesMessage("Aviso", "CrÃ©dito solicitado con Ã©Xito"));
            }else {
                 FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Aviso", "No es sujeto de crÃ©dito. Su capacidad de pago es menor a la cuota"));
            }
         

        } catch (Exception e) {
        } finally {
            procesoCredito = new ProcesoCredito();
            tipoCredito2 = new TipoCredito();
            tipoAmortizacion = new TipoAmortizacion();
            listarTc();
            listarTA();
        }

    }

    public void listarTc() {
        listaTipoCredito = manejadorTipoCredito.findAll();
        System.out.println(listaTipoCredito.get(0).getTipoCredito());
    
    }

    public void listarTA() {
        listaTam = manejadorTam.findAll();
    }

    public TablaAmortizacion getTb() {
        return tb;
    }

    public void setTb(TablaAmortizacion tb) {
        this.tb = tb;
    }

    public Integer getNpagos() {
        return npagos;
    }

    public void setNpagos(Integer npagos) {
        this.npagos = npagos;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Integer getIndiceTA() {
        return indiceTA;
    }

    public void setIndiceTA(Integer indiceTA) {
        this.indiceTA = indiceTA;
    }

    public List<TablaAmortizacion> getTbAmortizacion() {
        return tbAmortizacion;
    }

    public void setTbAmortizacion(List<TablaAmortizacion> tbAmortizacion) {
        this.tbAmortizacion = tbAmortizacion;
    }

    //</editor-fold>
    /**
     * MÃ©todo para cuotaFija la tabla de amortizaciÃ³n
     */
    //<editor-fold defaultstate="collapsed" desc="CUOTA FIJA Y DECRECIENTE">
    public void calcularCF() {
        Date fechaInicio = new Date();
        Date fechaAux;
        this.tbAmortizacion = new ArrayList();
        double totalInt = 0;
        double taT = manejadorTipoCredito.find(tipoCredito2.getIdTipoCredito()).getInteresBase() / 100;//Covertimos el valor a 0.xx
        ///AJUSTE DE TASA A 12 MESES
        double ta = taT / 12;

        /////CÃ�LCULO DE PAGO
        double p = capital * (ta / (1 - (Math.pow((1 + ta), (-npagos)))));
        //TOTAL DEL PAGO
        double totalPago = p * this.getNpagos();
        double cap = capital;
        //INTERÃ‰S, AMORTIZACIÃ“N, CAPITAL
        for (int i = 0; i < this.getNpagos(); i++) {
            TablaAmortizacion t = new TablaAmortizacion();

            t.setPeriodo(i + 1);//AÃ‘ADIMOS EL PERIODO A LA TABLA
            t.setPagoCuota(Math.round(p * 100) / 100d); //AÃ‘ADIMOS EL PAGO DE LA CUOTA A LA TABLA

            /////CALCULO DE INTERES
            double Interes = cap * ta;
            t.setInteres(Math.round(Interes * 100) / 100d);
            totalInt = totalInt + Interes;
            ///CALCULO DE AMORTIZACION
            double amortiza = p - Interes;
            t.setAmortizacion(Math.round(amortiza * 100) / 100d);
            ////CALCULO DE CAPITAL
            t.setCapital(Math.round(cap * 100) / 100d);
            ////CALCULO DE SALDO
            double saldo = cap - amortiza;
            t.setSaldo(Math.round(saldo * 100) / 100d);
            //CALCULO DE FECHAS
            fechaAux = variarFecha(fechaInicio, Calendar.DAY_OF_YEAR, 30);
            t.setFechas(formatofecha(fechaAux));
            this.tbAmortizacion.add(i, t);
            fechaInicio = fechaAux;
            cap = saldo;
            if (i == 0) {
                fechaInit = fechaInicio;
                pCuota=Math.round(p * 100) / 100d;
            }
            if (i == this.getNpagos() - 1) {
                fechaC = fechaInicio;
            }
        }
        System.out.println("CUOTA FIJA: " + "InterÃ©s=" + totalInt + " Pago=" + totalPago);
    }

    public void calcularCD() {
        Date fechaInicio = new Date();
        Date fechaAux;
        double totalInt = 0;
        double totalPago = 0;
        this.tbAmortizacion = new ArrayList();
        double taT = manejadorTipoCredito.find(tipoCredito2.getIdTipoCredito()).getInteresBase() / 100;//Covertimos el valor a 0.xx
        ///AJUSTE DE TASA A 12 MESES
        double ta = taT / 12;
        //CÃ�LCULO DE AMORTIZACIÃ“N
        double amortiza = capital / npagos;

        double cap = capital;

        //LLENADO DEL INTERÃ‰S, PAGO, CAPITAL
        for (int i = 0; i < this.getNpagos(); i++) {
            TablaAmortizacion t = new TablaAmortizacion();
            t.setPeriodo(i + 1);
            t.setAmortizacion(Math.round(amortiza * 100) / 100d);
            //CÃ�LCULO DEL INTERÃ‰S
            double interes = cap * ta;
            t.setInteres(Math.round(interes * 100) / 100d);
            totalInt = totalInt + interes;
            //CALCULO DEL PAGO
            double pago = amortiza + interes;
            t.setPagoCuota(Math.round(pago * 100) / 100d);
            totalPago = totalPago + pago;
            //CÃ�LCULO DEL CAPITAL
            t.setCapital(Math.round(cap * 100) / 100d);
            //CALCULO DEL SALDO
            double saldo = cap - amortiza;
            t.setSaldo(Math.round(saldo * 100) / 100d);
            //CALCULO DE FECHAS
            fechaAux = variarFecha(fechaInicio, Calendar.DAY_OF_YEAR, 30);
            t.setFechas(formatofecha(fechaAux));
            this.tbAmortizacion.add(i, t);
            fechaInicio = fechaAux;
            cap = saldo;
            if (i == 0) {
                fechaInit = fechaInicio;
                pCuota=Math.round(pago * 100) / 100d;
            }
            if (i == this.getNpagos() - 1) {
                fechaC = fechaInicio;
            }

        }
        System.out.println("CUOTA DECRECIENTE: " + "InterÃ©s=" + totalInt + " Pago=" + totalPago);

    }
//</editor-fold>

    public void calcular() {
        try {
            if (this.indiceTA == 1) {
                calcularCF();

            } else if (this.indiceTA == 2) {
                calcularCD();

            }
            System.out.println("INDICE=" + indiceTA + ",TASA=" + manejadorTipoCredito.find(tipoCredito2.getIdTipoCredito()).getInteresBase());
        } catch (Exception e) {
            capital = 0;
            npagos = 0;
            System.out.println("EN EL CATCH");
            System.out.println("INDICE=" + indiceTA + ",TASA=" + manejadorTipoCredito.find(tipoCredito2.getIdTipoCredito()).getInteresBase());
        }

    }

    public String formatofecha(Date f) {
        DateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        return formato.format(f);
    }

    public static Date variarFecha(Date fecha, int campo, int valor) {
        if (valor == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(campo, valor);
        return calendar.getTime();
    }
}
