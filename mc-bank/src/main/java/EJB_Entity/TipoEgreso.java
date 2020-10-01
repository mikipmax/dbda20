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
@Table(name = "tipo_egreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEgreso.findAll", query = "SELECT t FROM TipoEgreso t"),
    @NamedQuery(name = "TipoEgreso.findByIdTipoEgreso", query = "SELECT t FROM TipoEgreso t WHERE t.idTipoEgreso = :idTipoEgreso"),
    @NamedQuery(name = "TipoEgreso.findByDescripcion", query = "SELECT t FROM TipoEgreso t WHERE t.descripcion = :descripcion")})
public class TipoEgreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
   
    @Column(name = "id_tipo_egreso")
    private Integer idTipoEgreso;

    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoEgreso")
    private List<DetalleEgreso> detalleEgresoList;

    public TipoEgreso() {
    }

    public TipoEgreso(Integer idTipoEgreso) {
        this.idTipoEgreso = idTipoEgreso;
    }

    public Integer getIdTipoEgreso() {
        return idTipoEgreso;
    }

    public void setIdTipoEgreso(Integer idTipoEgreso) {
        this.idTipoEgreso = idTipoEgreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idTipoEgreso != null ? idTipoEgreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEgreso)) {
            return false;
        }
        TipoEgreso other = (TipoEgreso) object;
        if ((this.idTipoEgreso == null && other.idTipoEgreso != null) || (this.idTipoEgreso != null && !this.idTipoEgreso.equals(other.idTipoEgreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.TipoEgreso[ idTipoEgreso=" + idTipoEgreso + " ]";
    }
    
}
