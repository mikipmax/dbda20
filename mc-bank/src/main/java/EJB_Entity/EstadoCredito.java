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
@Table(name = "estado_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoCredito.findAll", query = "SELECT e FROM EstadoCredito e"),
    @NamedQuery(name = "EstadoCredito.findByIdEstado", query = "SELECT e FROM EstadoCredito e WHERE e.idEstado = :idEstado"),
    @NamedQuery(name = "EstadoCredito.findByEstado", query = "SELECT e FROM EstadoCredito e WHERE e.estado = :estado")})
public class EstadoCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "idEstado")
    private List<ProcesoAsignacion> procesoAsignacionList;

    public EstadoCredito() {
    }

    public EstadoCredito(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<ProcesoAsignacion> getProcesoAsignacionList() {
        return procesoAsignacionList;
    }

    public void setProcesoAsignacionList(List<ProcesoAsignacion> procesoAsignacionList) {
        this.procesoAsignacionList = procesoAsignacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoCredito)) {
            return false;
        }
        EstadoCredito other = (EstadoCredito) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.EstadoCredito[ idEstado=" + idEstado + " ]";
    }
    
}
