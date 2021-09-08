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
@Table(name = "cuarta_oportunidad")
@NamedQueries({
    @NamedQuery(name = "CuartaOportunidad.findAll", query = "SELECT c FROM CuartaOportunidad c")})
public class CuartaOportunidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estudiante_id")
    private String estudianteId;
    @Column(name = "curso_id")
    private String cursoId;
    @Basic(optional = false)
    @Column(name = "secretaria_id")
    private String secretariaId;
    @Basic(optional = false)
    @Column(name = "coordinador_id")
    private String coordinadorId;
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

    public CuartaOportunidad(Integer id, String estudianteId, String secretariaId, String coordinadorId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.secretariaId = secretariaId;
        this.coordinadorId = coordinadorId;
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

    public String getCursoId() {
        return cursoId;
    }

    public void setCursoId(String cursoId) {
        this.cursoId = cursoId;
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
        return "gt.edu.cunoc.epsBackend.entity.CuartaOportunidad[ id=" + id + " ]";
    }
    
}
