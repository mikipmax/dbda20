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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByDniEmpleado", query = "SELECT e FROM Empleado e WHERE e.dniEmpleado = :dniEmpleado")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
   @Id
    @OneToOne
    @JoinColumn(name = "dni_Empleado", referencedColumnName = "dni", nullable = false)
    private Persona dniEmpleado;

    @OneToMany(mappedBy = "dniEmpleado")
    private List<ProcesoAsignacion> procesoAsignacionList;
   
    @JoinColumn(name = "id_credenciales", referencedColumnName = "id_credenciales")
    @ManyToOne
    private Credenciales idCredenciales;
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    @ManyToOne
    private Cargo idCargo;

    public Empleado() {
    }

    public Empleado(Persona dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public Persona getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(Persona dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    @XmlTransient
    public List<ProcesoAsignacion> getProcesoAsignacionList() {
        return procesoAsignacionList;
    }

    public void setProcesoAsignacionList(List<ProcesoAsignacion> procesoAsignacionList) {
        this.procesoAsignacionList = procesoAsignacionList;
    }

 
    public Credenciales getIdCredenciales() {
        return idCredenciales;
    }

    public void setIdCredenciales(Credenciales idCredenciales) {
        this.idCredenciales = idCredenciales;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniEmpleado != null ? dniEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.dniEmpleado == null && other.dniEmpleado != null) || (this.dniEmpleado != null && !this.dniEmpleado.equals(other.dniEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.Empleado[ dniEmpleado=" + dniEmpleado + " ]";
    }
    
}
