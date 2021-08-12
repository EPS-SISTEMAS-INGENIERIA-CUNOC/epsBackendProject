/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.persitence.entity;

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
import javax.persistence.Table;

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "CUARTA_OPORTUNIDAD")
@NamedQueries({
    @NamedQuery(name = "CuartaOportunidad.findAll", query = "SELECT c FROM CuartaOportunidad c"),
    @NamedQuery(name = "CuartaOportunidad.findById", query = "SELECT c FROM CuartaOportunidad c WHERE c.id = :id"),
    @NamedQuery(name = "CuartaOportunidad.findByIdEstudiante", query = "SELECT c FROM CuartaOportunidad c WHERE c.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "CuartaOportunidad.findByIdCurso", query = "SELECT c FROM CuartaOportunidad c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "CuartaOportunidad.findByIdSecretaria", query = "SELECT c FROM CuartaOportunidad c WHERE c.idSecretaria = :idSecretaria"),
    @NamedQuery(name = "CuartaOportunidad.findByIdCoordinador", query = "SELECT c FROM CuartaOportunidad c WHERE c.idCoordinador = :idCoordinador")})
public class CuartaOportunidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private String idEstudiante;
    @Column(name = "id_curso")
    private String idCurso;
    @Basic(optional = false)
    @Column(name = "id_secretaria")
    private String idSecretaria;
    @Basic(optional = false)
    @Column(name = "id_coordinador")
    private String idCoordinador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuartaOportunidadFk")
    private Collection<DocumentoCuartaOportunidad> documentoCuartaOportunidadCollection;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;

    public CuartaOportunidad() {
    }

    public CuartaOportunidad(Integer id) {
        this.id = id;
    }

    public CuartaOportunidad(Integer id, String idEstudiante, String idSecretaria, String idCoordinador) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idSecretaria = idSecretaria;
        this.idCoordinador = idCoordinador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getIdSecretaria() {
        return idSecretaria;
    }

    public void setIdSecretaria(String idSecretaria) {
        this.idSecretaria = idSecretaria;
    }

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public Collection<DocumentoCuartaOportunidad> getDocumentoCuartaOportunidadCollection() {
        return documentoCuartaOportunidadCollection;
    }

    public void setDocumentoCuartaOportunidadCollection(Collection<DocumentoCuartaOportunidad> documentoCuartaOportunidadCollection) {
        this.documentoCuartaOportunidadCollection = documentoCuartaOportunidadCollection;
    }

    public EtapaSolicitud getEtapaSolicitudFk() {
        return etapaSolicitudFk;
    }

    public void setEtapaSolicitudFk(EtapaSolicitud etapaSolicitudFk) {
        this.etapaSolicitudFk = etapaSolicitudFk;
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
        if (!(object instanceof CuartaOportunidad)) {
            return false;
        }
        CuartaOportunidad other = (CuartaOportunidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.CuartaOportunidad[ id=" + id + " ]";
    }
    
}
