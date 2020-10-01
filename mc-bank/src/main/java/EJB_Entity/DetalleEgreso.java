/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mickmaxy
 */
@Entity
@Table(name = "detalle_egreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleEgreso.findAll", query = "SELECT d FROM DetalleEgreso d"),
    @NamedQuery(name = "DetalleEgreso.findByIdDetalleEgreso", query = "SELECT d FROM DetalleEgreso d WHERE d.idDetalleEgreso = :idDetalleEgreso"),
    @NamedQuery(name = "DetalleEgreso.findByDniCliente", query = "SELECT d FROM DetalleEgreso d WHERE d.dniCliente.dniCliente.dni = :dniCliente ORDER BY d.idTipoEgreso.idTipoEgreso ASC"),
    @NamedQuery(name = "DetalleEgreso.findByImagen", query = "SELECT d FROM DetalleEgreso d WHERE d.imagen = :imagen"),
    @NamedQuery(name = "DetalleEgreso.findByValor", query = "SELECT d FROM DetalleEgreso d WHERE d.valor = :valor"),
    @NamedQuery(name = "DetalleEgreso.findByEgresoValido", query = "SELECT d FROM DetalleEgreso d WHERE d.egresoValido = :egresoValido")})
public class DetalleEgreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_detalle_egreso")
    private Integer idDetalleEgreso;
    @Column(name = "imagen")
    private String imagen;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "egreso_valido")
    private Boolean egresoValido;
    @JoinColumn(name = "id_tipo_egreso", referencedColumnName = "id_tipo_egreso")
    @ManyToOne
    private TipoEgreso idTipoEgreso;
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni_cliente")
    @ManyToOne
    private Cliente dniCliente;

    public DetalleEgreso() {
    }

    public DetalleEgreso(Integer idDetalleEgreso) {
        this.idDetalleEgreso = idDetalleEgreso;
    }

    public Integer getIdDetalleEgreso() {
        return idDetalleEgreso;
    }

    public void setIdDetalleEgreso(Integer idDetalleEgreso) {
        this.idDetalleEgreso = idDetalleEgreso;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getEgresoValido() {
        return egresoValido;
    }

    public void setEgresoValido(Boolean egresoValido) {
        this.egresoValido = egresoValido;
    }

    public TipoEgreso getIdTipoEgreso() {
        return idTipoEgreso;
    }

    public void setIdTipoEgreso(TipoEgreso idTipoEgreso) {
        this.idTipoEgreso = idTipoEgreso;
    }

    public Cliente getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(Cliente dniCliente) {
        this.dniCliente = dniCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleEgreso != null ? idDetalleEgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleEgreso)) {
            return false;
        }
        DetalleEgreso other = (DetalleEgreso) object;
        if ((this.idDetalleEgreso == null && other.idDetalleEgreso != null) || (this.idDetalleEgreso != null && !this.idDetalleEgreso.equals(other.idDetalleEgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.DetalleEgreso[ idDetalleEgreso=" + idDetalleEgreso + " ]";
    }
    
}
