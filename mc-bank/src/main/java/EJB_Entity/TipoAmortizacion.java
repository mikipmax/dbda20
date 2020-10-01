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
@Table(name = "tipo_amortizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAmortizacion.findAll", query = "SELECT t FROM TipoAmortizacion t"),
    @NamedQuery(name = "TipoAmortizacion.findByIdTipoAmortizacion", query = "SELECT t FROM TipoAmortizacion t WHERE t.idTipoAmortizacion = :idTipoAmortizacion"),
    @NamedQuery(name = "TipoAmortizacion.findByTipoAmortizacion", query = "SELECT t FROM TipoAmortizacion t WHERE t.tipoAmortizacion = :tipoAmortizacion"),
    @NamedQuery(name = "TipoAmortizacion.findByHabilitado", query = "SELECT t FROM TipoAmortizacion t WHERE t.habilitado = :habilitado")})
public class TipoAmortizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)

    @Column(name = "id_tipo_amortizacion")
    private Integer idTipoAmortizacion;
  
    @Column(name = "tipo_amortizacion")
    private String tipoAmortizacion;
    @Column(name = "habilitado")
    private Boolean habilitado;
    @OneToMany(mappedBy = "idTipoAmortizacion")
    private List<ProcesoCredito> procesoCreditoList;

    public TipoAmortizacion() {
    }

    public TipoAmortizacion(Integer idTipoAmortizacion) {
        this.idTipoAmortizacion = idTipoAmortizacion;
    }

    public Integer getIdTipoAmortizacion() {
        return idTipoAmortizacion;
    }

    public void setIdTipoAmortizacion(Integer idTipoAmortizacion) {
        this.idTipoAmortizacion = idTipoAmortizacion;
    }

    public String getTipoAmortizacion() {
        return tipoAmortizacion;
    }

    public void setTipoAmortizacion(String tipoAmortizacion) {
        this.tipoAmortizacion = tipoAmortizacion;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    @XmlTransient
    public List<ProcesoCredito> getProcesoCreditoList() {
        return procesoCreditoList;
    }

    public void setProcesoCreditoList(List<ProcesoCredito> procesoCreditoList) {
        this.procesoCreditoList = procesoCreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAmortizacion != null ? idTipoAmortizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAmortizacion)) {
            return false;
        }
        TipoAmortizacion other = (TipoAmortizacion) object;
        if ((this.idTipoAmortizacion == null && other.idTipoAmortizacion != null) || (this.idTipoAmortizacion != null && !this.idTipoAmortizacion.equals(other.idTipoAmortizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.TipoAmortizacion[ idTipoAmortizacion=" + idTipoAmortizacion + " ]";
    }
    
}
