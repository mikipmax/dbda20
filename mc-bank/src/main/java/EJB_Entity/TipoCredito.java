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
@Table(name = "tipo_credito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCredito.findAll", query = "SELECT t FROM TipoCredito t"),
    @NamedQuery(name = "TipoCredito.findByIdTipoCredito", query = "SELECT t FROM TipoCredito t WHERE t.idTipoCredito = :idTipoCredito"),
    @NamedQuery(name = "TipoCredito.findByTipoCredito", query = "SELECT t FROM TipoCredito t WHERE t.tipoCredito = :tipoCredito"),
    @NamedQuery(name = "TipoCredito.findByHabilitado", query = "SELECT t FROM TipoCredito t WHERE t.habilitado = :habilitado"),
    @NamedQuery(name = "TipoCredito.findByInteresBase", query = "SELECT t FROM TipoCredito t WHERE t.interesBase = :interesBase")})
public class TipoCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_credito")
    private Integer idTipoCredito;
    @Column(name = "tipo_credito")
    private String tipoCredito;
    @Column(name = "habilitado")
    private Boolean habilitado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "interes_base")
    private Double interesBase;
    @OneToMany(mappedBy = "idTipoCredito")
    private List<ProcesoCredito> procesoCreditoList;

    public TipoCredito() {
    }

    public TipoCredito(Integer idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public Integer getIdTipoCredito() {
        return idTipoCredito;
    }

    public void setIdTipoCredito(Integer idTipoCredito) {
        this.idTipoCredito = idTipoCredito;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(String tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Double getInteresBase() {
        return interesBase;
    }

    public void setInteresBase(Double interesBase) {
        this.interesBase = interesBase;
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
        hash += (idTipoCredito != null ? idTipoCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCredito)) {
            return false;
        }
        TipoCredito other = (TipoCredito) object;
        if ((this.idTipoCredito == null && other.idTipoCredito != null) || (this.idTipoCredito != null && !this.idTipoCredito.equals(other.idTipoCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.TipoCredito[ idTipoCredito=" + idTipoCredito + " ]";
    }
    
}
