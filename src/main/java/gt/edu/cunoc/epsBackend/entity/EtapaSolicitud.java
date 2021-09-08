/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "etapa_solicitud")
@NamedQueries({
    @NamedQuery(name = "EtapaSolicitud.findAll", query = "SELECT e FROM EtapaSolicitud e")})
public class EtapaSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "tipo_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoSolicitud tipoSolicitudFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaSolicitudFk")
    private Collection<DictamenCierre> dictamenCierreCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaSolicitudFk")
    private Collection<Extraordinario> extraordinarioCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "etapaSolicitud")
    private Desasignacion desasignacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaSolicitudFk")
    private Collection<DictamenEquivalencia> dictamenEquivalenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaSolicitudFk")
    private Collection<ActaComplemento> actaComplementoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaSolicitudFk")
    private Collection<CuartaOportunidad> cuartaOportunidadCollection;

    public EtapaSolicitud() {
    }

    public EtapaSolicitud(Integer id) {
        this.id = id;
    }

    public EtapaSolicitud(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoSolicitud getTipoSolicitudFk() {
        return tipoSolicitudFk;
    }

    public void setTipoSolicitudFk(TipoSolicitud tipoSolicitudFk) {
        this.tipoSolicitudFk = tipoSolicitudFk;
    }

    public Collection<DictamenCierre> getDictamenCierreCollection() {
        return dictamenCierreCollection;
    }

    public void setDictamenCierreCollection(Collection<DictamenCierre> dictamenCierreCollection) {
        this.dictamenCierreCollection = dictamenCierreCollection;
    }

    public Collection<Extraordinario> getExtraordinarioCollection() {
        return extraordinarioCollection;
    }

    public void setExtraordinarioCollection(Collection<Extraordinario> extraordinarioCollection) {
        this.extraordinarioCollection = extraordinarioCollection;
    }

    public Desasignacion getDesasignacion() {
        return desasignacion;
    }

    public void setDesasignacion(Desasignacion desasignacion) {
        this.desasignacion = desasignacion;
    }

    public Collection<DictamenEquivalencia> getDictamenEquivalenciaCollection() {
        return dictamenEquivalenciaCollection;
    }

    public void setDictamenEquivalenciaCollection(Collection<DictamenEquivalencia> dictamenEquivalenciaCollection) {
        this.dictamenEquivalenciaCollection = dictamenEquivalenciaCollection;
    }

    public Collection<ActaComplemento> getActaComplementoCollection() {
        return actaComplementoCollection;
    }

    public void setActaComplementoCollection(Collection<ActaComplemento> actaComplementoCollection) {
        this.actaComplementoCollection = actaComplementoCollection;
    }

    public Collection<CuartaOportunidad> getCuartaOportunidadCollection() {
        return cuartaOportunidadCollection;
    }

    public void setCuartaOportunidadCollection(Collection<CuartaOportunidad> cuartaOportunidadCollection) {
        this.cuartaOportunidadCollection = cuartaOportunidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaSolicitud)) {
            return false;
        }
        EtapaSolicitud other = (EtapaSolicitud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.entity.EtapaSolicitud[ id=" + id + " ]";
    }
    
}
