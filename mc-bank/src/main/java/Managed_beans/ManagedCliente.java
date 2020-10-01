/*
 *Cambiar en el futuro incluyendo al cliente con sus respectivos documentos
 */
package Managed_beans;

import EJB_Entity.Cliente;
import EJB_Entity.Credenciales;
import EJB_Entity.Persona;
import EJB_Session.ClienteFacadeLocal;
import EJB_Session.CredencialesFacadeLocal;
import EJB_Session.NivelAccesoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(  "ManagedCliente")
@SessionScoped
public class ManagedCliente implements Serializable {

    @Inject
    private CredencialesFacadeLocal manejadorCredenciales;
    @Inject
    private NivelAccesoFacadeLocal manejadorNivelAcceso;
    @Inject
    private ClienteFacadeLocal manejadorCliente;
    private Persona persona;
    private Cliente cliente;
    private Credenciales credenciales;
    private List<Credenciales> listaCredenciales;
    private List<Cliente> listaClientes;

    @PostConstruct
    public void init() {
        cliente = new Cliente();
        persona = new Persona();
        credenciales = new Credenciales();
        recuperarCliente();

    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public List<Credenciales> getListaCredenciales() {
        return listaCredenciales;
    }

    public void setListaCredenciales(List<Credenciales> listaCredenciales) {
        this.listaCredenciales = listaCredenciales;
    }

    public String grabarPersona() {
        String s="";
        try {

            this.credenciales.setDni(persona);

            this.credenciales.setIdNivelAcceso(manejadorNivelAcceso.find(1));

            manejadorCredenciales.create(credenciales);
            this.cliente.setDniCliente(persona);
            this.cliente.setIdCredenciales(credenciales);
            this.cliente.setValorIngreso(0.0);
            this.cliente.setValorEgreso(0.0);
            this.cliente.setCapacidadPago(0.0);
            manejadorCliente.create(cliente);


s="/signin?faces-redirect=true";


        } catch (Exception e) {
        } finally {
            cliente = new Cliente();
            persona = new Persona();
            credenciales = new Credenciales();
            recuperarCliente();
        }
        return s;
    }

    public void recuperarCliente() {
        try {
            listaClientes = manejadorCliente.findAll();



        } catch (Exception e) {
        }

    }

    public void editarCliente() {
        try {
            //primero edito la tabla q contiene la fk
            this.credenciales.setDni(cliente.getDniCliente());
            this.credenciales.setIdCredenciales(cliente.getIdCredenciales().getIdCredenciales());
            this.credenciales.setUsuario(cliente.getIdCredenciales().getUsuario());
            this.credenciales.setClave(cliente.getIdCredenciales().getClave());
            this.credenciales.setBaneado(cliente.getIdCredenciales().getBaneado());
            this.credenciales.setIdNivelAcceso(manejadorNivelAcceso.find(1));
            manejadorCredenciales.edit(credenciales);
            //ahora por medio del metodo fin encuentro la persona que estoy editando mediante el pk (dni) que se encuentra en la entidad credenciales.
            //  persona = manejadorPersona.find(credenciales.getDni().getDni());
            //finalmente mediante mi controlador de negocio edito la persona 
            //manejadorPersona.edit(persona);
            recuperarCliente();
        } catch (Exception e) {
        } finally {
            cliente = new Cliente();
            persona = new Persona();
            credenciales = new Credenciales();
            recuperarCliente();
        }

    }

    public void leerFilaCliente(Cliente clientesSeleccion) {
        cliente = clientesSeleccion;
    }

    public void clienteSalir() {
        cliente = new Cliente();
        persona = new Persona();
        credenciales = new Credenciales();

    }
}
