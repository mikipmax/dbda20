/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mickmaxy
 */
@Entity
@Table(name = "credenciales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credenciales.findAll", query = "SELECT c FROM Credenciales c"),
    @NamedQuery(name = "Credenciales.findByIdCredenciales", query = "SELECT c FROM Credenciales c WHERE c.idCredenciales = :idCredenciales"),
    @NamedQuery(name = "Credenciales.findByUsuario", query = "SELECT c FROM Credenciales c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Credenciales.findByClave", query = "SELECT c FROM Credenciales c WHERE c.clave = :clave"),
    @NamedQuery(name = "Credenciales.findByEstadoUsuario", query = "SELECT c FROM Credenciales c WHERE c.estadoUsuario = :estadoUsuario"),
    @NamedQuery(name = "Credenciales.findByBaneado", query = "SELECT c FROM Credenciales c WHERE c.baneado = :baneado"),
    @NamedQuery(name = "Credenciales.validarUsuario", query = "SELECT c FROM Credenciales c WHERE c.clave = :clave and c.usuario = :usuario")})
public class Credenciales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_credenciales")
    private Integer idCredenciales;
    @Basic(optional = false)

  
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "clave")
    private String clave;
    @Column(name = "estado_usuario")
    private Boolean estadoUsuario;
    @Column(name = "baneado")
    private Boolean baneado;
    @OneToMany(mappedBy = "idCredenciales")
    private List<Cliente> clienteList;
    @OneToMany(mappedBy = "idCredenciales")
    private List<Empleado> empleadoList;
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    @ManyToOne(cascade = CascadeType.ALL)
    private Persona dni;
    @JoinColumn(name = "id_nivel_acceso", referencedColumnName = "id_nivel_acceso")
    @ManyToOne
    private NivelAcceso idNivelAcceso;

    public Credenciales() {
    }

    public Credenciales(Integer idCredenciales) {
        this.idCredenciales = idCredenciales;
    }

    public Credenciales(Integer idCredenciales, String usuario) {
        this.idCredenciales = idCredenciales;
        this.usuario = usuario;
    }

    public Integer getIdCredenciales() {
        return idCredenciales;
    }

    public void setIdCredenciales(Integer idCredenciales) {
        this.idCredenciales = idCredenciales;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Boolean getBaneado() {
        return baneado;
    }

    public void setBaneado(Boolean baneado) {
        this.baneado = baneado;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public Persona getDni() {
        return dni;
    }

    public void setDni(Persona dni) {
        this.dni = dni;
    }

    public NivelAcceso getIdNivelAcceso() {
        return idNivelAcceso;
    }

    public void setIdNivelAcceso(NivelAcceso idNivelAcceso) {
        this.idNivelAcceso = idNivelAcceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCredenciales != null ? idCredenciales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credenciales)) {
            return false;
        }
        Credenciales other = (Credenciales) object;
        if ((this.idCredenciales == null && other.idCredenciales != null) || (this.idCredenciales != null && !this.idCredenciales.equals(other.idCredenciales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.Credenciales[ idCredenciales=" + idCredenciales + " ]";
    }
    
}
