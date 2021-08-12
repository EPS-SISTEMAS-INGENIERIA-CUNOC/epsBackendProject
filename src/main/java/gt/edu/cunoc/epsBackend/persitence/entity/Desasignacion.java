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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "DESASIGNACION")
@NamedQueries({
    @NamedQuery(name = "Desasignacion.findAll", query = "SELECT d FROM Desasignacion d"),
    @NamedQuery(name = "Desasignacion.findById", query = "SELECT d FROM Desasignacion d WHERE d.id = :id"),
    @NamedQuery(name = "Desasignacion.findByFechaInicio", query = "SELECT d FROM Desasignacion d WHERE d.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Desasignacion.findByEstado", query = "SELECT d FROM Desasignacion d WHERE d.estado = :estado"),
    @NamedQuery(name = "Desasignacion.findByIdEstudiante", query = "SELECT d FROM Desasignacion d WHERE d.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "Desasignacion.findByCursoId", query = "SELECT d FROM Desasignacion d WHERE d.cursoId = :cursoId"),
    @NamedQuery(name = "Desasignacion.findByDocenteId", query = "SELECT d FROM Desasignacion d WHERE d.docenteId = :docenteId"),
    @NamedQuery(name = "Desasignacion.findBySecretariaId", query = "SELECT d FROM Desasignacion d WHERE d.secretariaId = :secretariaId"),
    @NamedQuery(name = "Desasignacion.findByCoordinadorId", query = "SELECT d FROM Desasignacion d WHERE d.coordinadorId = :coordinadorId")})
public class Desasignacion implements Serializable {

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
    @Column(name = "curso_id")
    private String cursoId;
    @Basic(optional = false)
    @Column(name = "docente_id")
    private String docenteId;
    @Basic(optional = false)
    @Column(name = "secretaria_id")
    private String secretariaId;
    @Basic(optional = false)
    @Column(name = "coordinador_id")
    private String coordinadorId;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EtapaSolicitud etapaSolicitud;

    public Desasignacion() {
    }

    public Desasignacion(Integer id) {
        this.id = id;
    }

    public Desasignacion(Integer id, Date fechaInicio, String estado, String idEstudiante, String docenteId, String secretariaId, String coordinadorId) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.idEstudiante = idEstudiante;
        this.docenteId = docenteId;
        this.secretariaId = secretariaId;
        this.coordinadorId = coordinadorId;
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

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
    }

    public String getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(String docenteId) {
        this.docenteId = docenteId;
    }

    public String getSecretariaId() {
        return secretariaId;
    }

    public void setSecretariaId(String secretariaId) {
        this.secretariaId = secretariaId;
    }

    public String getCoordinadorId() {
        return coordinadorId;
    }

    public void setCoordinadorId(String coordinadorId) {
        this.coordinadorId = coordinadorId;
    }

    public EtapaSolicitud getEtapaSolicitud() {
        return etapaSolicitud;
    }

    public void setEtapaSolicitud(EtapaSolicitud etapaSolicitud) {
        this.etapaSolicitud = etapaSolicitud;
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
        if (!(object instanceof Desasignacion)) {
            return false;
        }
        Desasignacion other = (Desasignacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.Desasignacion[ id=" + id + " ]";
    }
    
}
