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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mickmaxy
 */
@Entity
@Table(name = "proceso_asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoAsignacion.findAll", query = "SELECT p FROM ProcesoAsignacion p"),
    @NamedQuery(name = "ProcesoAsignacion.findByIdProcesoCredito", query = "SELECT p FROM ProcesoAsignacion p WHERE p.idProcesoCredito = :idProcesoCredito"),
    @NamedQuery(name = "ProcesoAsignacion.findByEjecutivo", query = "SELECT p FROM ProcesoAsignacion p, Empleado e WHERE p.dniEmpleado.dniEmpleado=e.dniEmpleado AND e.dniEmpleado.dni= :ejecut "),
    @NamedQuery(name = "ProcesoAsignacion.findByCliente", query = "SELECT p FROM ProcesoAsignacion p, Cliente e WHERE p.idProcesoCredito.dniCliente.dniCliente.dni= :ejecut")})
public class ProcesoAsignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @OneToOne
    @JoinColumn(name = "id_proceso_credito", referencedColumnName = "id_proceso_credito", nullable = false)
    private ProcesoCredito idProcesoCredito;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne
    private EstadoCredito idEstado;
    @JoinColumn(name = "dni_empleado", referencedColumnName = "dni_empleado")
    @ManyToOne
    private Empleado dniEmpleado;

    public ProcesoAsignacion() {
    }

    public ProcesoAsignacion(ProcesoCredito idProcesoCredito) {
        this.idProcesoCredito = idProcesoCredito;
    }

    public ProcesoCredito getIdProcesoCredito() {
        return idProcesoCredito;
    }

    public void setIdProcesoCredito(ProcesoCredito idProcesoCredito) {
        this.idProcesoCredito = idProcesoCredito;
    }

    public EstadoCredito getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoCredito idEstado) {
        this.idEstado = idEstado;
    }

    public Empleado getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(Empleado dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
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
        if (!(object instanceof ProcesoAsignacion)) {
            return false;
        }
        ProcesoAsignacion other = (ProcesoAsignacion) object;
        if ((this.idProcesoCredito == null && other.idProcesoCredito != null) || (this.idProcesoCredito != null && !this.idProcesoCredito.equals(other.idProcesoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.ProcesoAsignacion[ idProcesoCredito=" + idProcesoCredito + " ]";
    }
}
