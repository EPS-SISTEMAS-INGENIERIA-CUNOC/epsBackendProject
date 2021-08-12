/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.persitence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "EXTRAORDINARIO")
@NamedQueries({
    @NamedQuery(name = "Extraordinario.findAll", query = "SELECT e FROM Extraordinario e"),
    @NamedQuery(name = "Extraordinario.findById", query = "SELECT e FROM Extraordinario e WHERE e.id = :id"),
    @NamedQuery(name = "Extraordinario.findByFechaInicio", query = "SELECT e FROM Extraordinario e WHERE e.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Extraordinario.findByEstado", query = "SELECT e FROM Extraordinario e WHERE e.estado = :estado"),
    @NamedQuery(name = "Extraordinario.findByIdEstudiante", query = "SELECT e FROM Extraordinario e WHERE e.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Extraordinario.findByIdDocente", query = "SELECT e FROM Extraordinario e WHERE e.idDocente = :idDocente"),
    @NamedQuery(name = "Extraordinario.findByIdSecretaria", query = "SELECT e FROM Extraordinario e WHERE e.idSecretaria = :idSecretaria"),
    @NamedQuery(name = "Extraordinario.findByIdCoordinador", query = "SELECT e FROM Extraordinario e WHERE e.idCoordinador = :idCoordinador"),
    @NamedQuery(name = "Extraordinario.findByIdCurso", query = "SELECT e FROM Extraordinario e WHERE e.idCurso = :idCurso")})
public class Extraordinario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
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
    @Column(name = "id_curso")
    private String idCurso;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;

    public Extraordinario() {
    }

    public Extraordinario(Integer id) {
        this.id = id;
    }

    public Extraordinario(Integer id, Date fechaInicio, String estado, String idEstudiante, String idDocente, String idSecretaria, String idCoordinador, String idCurso) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.idEstudiante = idEstudiante;
        this.idDocente = idDocente;
        this.idSecretaria = idSecretaria;
        this.idCoordinador = idCoordinador;
        this.idCurso = idCurso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
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
        if (!(object instanceof Extraordinario)) {
            return false;
        }
        Extraordinario other = (Extraordinario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.Extraordinario[ id=" + id + " ]";
    }
    
}
