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
@Table(name = "nivel_acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcceso.findAll", query = "SELECT n FROM NivelAcceso n"),
    @NamedQuery(name = "NivelAcceso.findByIdNivelAcceso", query = "SELECT n FROM NivelAcceso n WHERE n.idNivelAcceso = :idNivelAcceso"),
    @NamedQuery(name = "NivelAcceso.findByNivelAcceso", query = "SELECT n FROM NivelAcceso n WHERE n.nivelAcceso = :nivelAcceso")})
public class NivelAcceso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_nivel_acceso")
    private Integer idNivelAcceso;
    @Column(name = "nivel_acceso")
    private String nivelAcceso;
    @OneToMany(mappedBy = "idNivelAcceso")
    private List<Credenciales> credencialesList;

    public NivelAcceso() {
    }

    public NivelAcceso(Integer idNivelAcceso) {
        this.idNivelAcceso = idNivelAcceso;
    }

    public Integer getIdNivelAcceso() {
        return idNivelAcceso;
    }

    public void setIdNivelAcceso(Integer idNivelAcceso) {
        this.idNivelAcceso = idNivelAcceso;
    }

    public String getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(String nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    @XmlTransient
    public List<Credenciales> getCredencialesList() {
        return credencialesList;
    }

    public void setCredencialesList(List<Credenciales> credencialesList) {
        this.credencialesList = credencialesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelAcceso != null ? idNivelAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcceso)) {
            return false;
        }
        NivelAcceso other = (NivelAcceso) object;
        if ((this.idNivelAcceso == null && other.idNivelAcceso != null) || (this.idNivelAcceso != null && !this.idNivelAcceso.equals(other.idNivelAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB_Entity.NivelAcceso[ idNivelAcceso=" + idNivelAcceso + " ]";
    }
    
}
