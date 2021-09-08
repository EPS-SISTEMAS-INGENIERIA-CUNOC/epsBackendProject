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
import javax.persistence.Table;

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "dictamen_equivalencia")
@NamedQueries({
    @NamedQuery(name = "DictamenEquivalencia.findAll", query = "SELECT d FROM DictamenEquivalencia d")})
public class DictamenEquivalencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estudiante_id")
    private String estudianteId;
    @Basic(optional = false)
    @Column(name = "docente_id")
    private String docenteId;
    @Basic(optional = false)
    @Column(name = "secretaria_id")
    private String secretariaId;
    @Basic(optional = false)
    @Column(name = "coordinador_id")
    private String coordinadorId;
    @Basic(optional = false)
    @Column(name = "nota")
    private double nota;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquivalenciaFk")
    private Collection<DocumentoEquivalencia> documentoEquivalenciaCollection;

    public DictamenEquivalencia() {
    }

    public DictamenEquivalencia(Integer id) {
        this.id = id;
    }

    public DictamenEquivalencia(Integer id, String estudianteId, String docenteId, String secretariaId, String coordinadorId, double nota) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.docenteId = docenteId;
        this.secretariaId = secretariaId;
        this.coordinadorId = coordinadorId;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(String estudianteId) {
        this.estudianteId = estudianteId;
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

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public EtapaSolicitud getEtapaSolicitudFk() {
        return etapaSolicitudFk;
    }

    public void setEtapaSolicitudFk(EtapaSolicitud etapaSolicitudFk) {
        this.etapaSolicitudFk = etapaSolicitudFk;
    }

    public Collection<DocumentoEquivalencia> getDocumentoEquivalenciaCollection() {
        return documentoEquivalenciaCollection;
    }

    public void setDocumentoEquivalenciaCollection(Collection<DocumentoEquivalencia> documentoEquivalenciaCollection) {
        this.documentoEquivalenciaCollection = documentoEquivalenciaCollection;
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
        return "gt.edu.cunoc.epsBackend.entity.DictamenEquivalencia[ id=" + id + " ]";
    }
    
}
