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
@Table(name = "DICTAMEN_EQUIVALENCIA")
@NamedQueries({
    @NamedQuery(name = "DictamenEquivalencia.findAll", query = "SELECT d FROM DictamenEquivalencia d"),
    @NamedQuery(name = "DictamenEquivalencia.findById", query = "SELECT d FROM DictamenEquivalencia d WHERE d.id = :id"),
    @NamedQuery(name = "DictamenEquivalencia.findByIdEstudiante", query = "SELECT d FROM DictamenEquivalencia d WHERE d.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "DictamenEquivalencia.findByIdDocente", query = "SELECT d FROM DictamenEquivalencia d WHERE d.idDocente = :idDocente"),
    @NamedQuery(name = "DictamenEquivalencia.findByIdSecretaria", query = "SELECT d FROM DictamenEquivalencia d WHERE d.idSecretaria = :idSecretaria"),
    @NamedQuery(name = "DictamenEquivalencia.findByIdCoordinador", query = "SELECT d FROM DictamenEquivalencia d WHERE d.idCoordinador = :idCoordinador"),
    @NamedQuery(name = "DictamenEquivalencia.findByNota", query = "SELECT d FROM DictamenEquivalencia d WHERE d.nota = :nota")})
public class DictamenEquivalencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private String idEstudiante;
    @Basic(optional = false)
    @Column(name = "id_docente")
    private String idDocente;
    @Basic(optional = false)
    @Column(name = "id_secretaria")
    private String idSecretaria;
    @Basic(optional = false)
    @Column(name = "id_coordinador")
    private String idCoordinador;
    @Basic(optional = false)
    @Column(name = "nota")
    private double nota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquivalenciaFk")
    private Collection<DocumentoEquivalencia> documentoEquivalenciaCollection;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;

    public DictamenEquivalencia() {
    }

    public DictamenEquivalencia(Integer id) {
        this.id = id;
    }

    public DictamenEquivalencia(Integer id, String idEstudiante, String idDocente, String idSecretaria, String idCoordinador, double nota) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idDocente = idDocente;
        this.idSecretaria = idSecretaria;
        this.idCoordinador = idCoordinador;
        this.nota = nota;
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

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        this.idDocente = idDocente;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Collection<DocumentoEquivalencia> getDocumentoEquivalenciaCollection() {
        return documentoEquivalenciaCollection;
    }

    public void setDocumentoEquivalenciaCollection(Collection<DocumentoEquivalencia> documentoEquivalenciaCollection) {
        this.documentoEquivalenciaCollection = documentoEquivalenciaCollection;
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
        if (!(object instanceof DictamenEquivalencia)) {
            return false;
        }
        DictamenEquivalencia other = (DictamenEquivalencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.DictamenEquivalencia[ id=" + id + " ]";
    }
    
}
