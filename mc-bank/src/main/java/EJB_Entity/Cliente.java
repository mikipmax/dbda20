/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mickmaxy
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByDniCliente", query = "SELECT c FROM Cliente c WHERE c.dniCliente = :dniCliente"),
    @NamedQuery(name = "Cliente.findByDocDni", query = "SELECT c FROM Cliente c WHERE c.docDni = :docDni"),
    @NamedQuery(name = "Cliente.findByUsuario", query = "SELECT c FROM Cliente c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Cliente.findByDocIngreso", query = "SELECT c FROM Cliente c WHERE c.docIngreso = :docIngreso"),
    @NamedQuery(name = "Cliente.findByValorIngreso", query = "SELECT c FROM Cliente c WHERE c.valorIngreso = :valorIngreso"),
    @NamedQuery(name = "Cliente.findByValorEgreso", query = "SELECT c FROM Cliente c WHERE c.valorEgreso = :valorEgreso"),
    @NamedQuery(name = "Cliente.findByCapacidadPago", query = "SELECT c FROM Cliente c WHERE c.capacidadPago = :capacidadPago"),
    @NamedQuery(name = "Cliente.findByVecesMora", query = "SELECT c FROM Cliente c WHERE c.vecesMora = :vecesMora"),
    @NamedQuery(name = "Cliente.findByDiasMora", query = "SELECT c FROM Cliente c WHERE c.diasMora = :diasMora"),
    @NamedQuery(name = "Cliente.findByIngresoValido", query = "SELECT c FROM Cliente c WHERE c.ingresoValido = :ingresoValido"),
    @NamedQuery(name = "Cliente.findByDocDniValido", query = "SELECT c FROM Cliente c WHERE c.docDniValido = :docDniValido")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
   @Id
    @OneToOne
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni", nullable = false)
    private Persona dniCliente;

    @Column(name = "doc_dni")
    private String docDni;

    @Column(name = "usuario")
    private String usuario;
   
    @Column(name = "doc_ingreso")
    private String docIngreso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_ingreso")
    private Double valorIngreso;
    @Column(name = "valor_egreso")
    private Double valorEgreso;
    @Column(name = "capacidad_pago")
    private Double capacidadPago;
    @Column(name = "veces_mora")
    private Integer vecesMora;
    @Column(name = "dias_mora")
    private Integer diasMora;
    @Column(name = "ingreso_valido")
    private Boolean ingresoValido;
    @Column(name = "doc_dni_valido")
    private Boolean docDniValido;
    @OneToMany(mappedBy = "dniCliente")
    private List<ProcesoCredito> procesoCreditoList;
   
    @JoinColumn(name = "id_credenciales", referencedColumnName = "id_credenciales")
    @ManyToOne
    private Credenciales idCredenciales;
    @OneToMany(mappedBy = "dniCliente")
    private List<DetalleEgreso> detalleEgresoList;

    public Cliente() {
    }

    public Cliente(Persona dniCliente) {
        this.dniCliente = dniCliente;
    }

    public Persona getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(Persona dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getDocDni() {
        return docDni;
    }

    public void setDocDni(String docDni) {
        this.docDni = docDni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDocIngreso() {
        return docIngreso;
    }

    public void setDocIngreso(String docIngreso) {
        this.docIngreso = docIngreso;
    }

    public Double getValorIngreso() {
        return valorIngreso;
    }

    public void setValorIngreso(Double valorIngreso) {
        this.valorIngreso = valorIngreso;
    }

    public Double getValorEgreso() {
        return valorEgreso;
    }

    public void setValorEgreso(Double valorEgreso) {
        this.valorEgreso = valorEgreso;
    }

    public Double getCapacidadPago() {
        return capacidadPago;
    }

    public void setCapacidadPago(Double capacidadPago) {
        this.capacidadPago = capacidadPago;
    }

    public Integer getVecesMora() {
        return vecesMora;
    }

    public void setVecesMora(Integer vecesMora) {
        this.vecesMora = vecesMora;
    }

    public Integer getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(Integer diasMora) {
        this.diasMora = diasMora;
    }

    public Boolean getIngresoValido() {
        return ingresoValido;
    }

    public void setIngresoValido(Boolean ingresoValido) {
        this.ingresoValido = ingresoValido;
    }

    public Boolean getDocDniValido() {
        return docDniValido;
    }

    public void setDocDniValido(Boolean docDniValido) {
        this.docDniValido = docDniValido;
    }

    @XmlTransient
    public List<ProcesoCredito> getProcesoCreditoList() {
        return procesoCreditoList;
    }

    public void setProcesoCreditoList(List<ProcesoCredito> procesoCreditoList) {
        this.procesoCreditoList = procesoCreditoList;
    }

  
    public Credenciales getIdCredenciales() {
        return idCredenciales;
    }

    public void setIdCredenciales(Credenciales idCredenciales) {
        this.idCredenciales = idCredenciales;
    }

    @XmlTransient
    public List<DetalleEgreso> getDetalleEgresoList() {
        return detalleEgresoList;
    }

    public void setDetalleEgresoList(List<DetalleEgreso> detalleEgresoList) {
        this.detalleEgresoList = detalleEgresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniCliente != null ? dniCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.dniCliente == null && other.dniCliente != null) || (this.dniCliente != null && !this.dniCliente.equals(other.dniCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.Cliente[ dniCliente=" + dniCliente + " ]";
    }
    
}
