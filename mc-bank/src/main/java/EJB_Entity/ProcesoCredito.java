/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mickmaxy
 */
@Entity
@Table(name = "proceso_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoCredito.findAll", query = "SELECT p FROM ProcesoCredito p"),
    @NamedQuery(name = "ProcesoCredito.findByIdProcesoCredito", query = "SELECT p FROM ProcesoCredito p WHERE p.idProcesoCredito = :idProcesoCredito"),
    @NamedQuery(name = "ProcesoCredito.findByMonto", query = "SELECT p FROM ProcesoCredito p WHERE p.monto = :monto"),
    @NamedQuery(name = "ProcesoCredito.findByPlazo", query = "SELECT p FROM ProcesoCredito p WHERE p.plazo = :plazo"),
    @NamedQuery(name = "ProcesoCredito.findByInteres", query = "SELECT p FROM ProcesoCredito p WHERE p.interes = :interes"),
    @NamedQuery(name = "ProcesoCredito.findByFechaInicio", query = "SELECT p FROM ProcesoCredito p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "ProcesoCredito.findByFechaCierre", query = "SELECT p FROM ProcesoCredito p WHERE p.fechaCierre = :fechaCierre")})
public class ProcesoCredito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "id_proceso_credito")
    private Integer idProcesoCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Double monto;
    @Column(name = "plazo")
    private Integer plazo;
    @Column(name = "interes")
    private Double interes;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;
    @JoinColumn(name = "id_tipo_credito", referencedColumnName = "id_tipo_credito")
    @ManyToOne
    private TipoCredito idTipoCredito;
    @JoinColumn(name = "id_tipo_amortizacion", referencedColumnName = "id_tipo_amortizacion")
    @ManyToOne
    private TipoAmortizacion idTipoAmortizacion;
    @JoinColumn(name = "dni_cliente", referencedColumnName = "dni_cliente")
    @ManyToOne
    private Cliente dniCliente;

    public ProcesoCredito() {
    }

    public ProcesoCredito(Integer idProcesoCredito) {
        this.idProcesoCredito = idProcesoCredito;
    }

    public Integer getIdProcesoCredito() {
        return idProcesoCredito;
    }

    public void setIdProcesoCredito(Integer idProcesoCredito) {
        this.idProcesoCredito = idProcesoCredito;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public TipoCredito getIdTipoCredito() {
        return idTipoCredito;
    }

    public void setIdTipoCredito(TipoCredito idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public TipoAmortizacion getIdTipoAmortizacion() {
        return idTipoAmortizacion;
    }

    public void setIdTipoAmortizacion(TipoAmortizacion idTipoAmortizacion) {
        this.idTipoAmortizacion = idTipoAmortizacion;
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
        hash += (idProcesoCredito != null ? idProcesoCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoCredito)) {
            return false;
        }
        ProcesoCredito other = (ProcesoCredito) object;
        if ((this.idProcesoCredito == null && other.idProcesoCredito != null) || (this.idProcesoCredito != null && !this.idProcesoCredito.equals(other.idProcesoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.ProcesoCredito[ idProcesoCredito=" + idProcesoCredito + " ]";
    }
}
