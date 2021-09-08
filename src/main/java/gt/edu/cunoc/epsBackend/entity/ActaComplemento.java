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
@Table(name = "acta_complemento")
@NamedQueries({
    @NamedQuery(name = "ActaComplemento.findAll", query = "SELECT a FROM ActaComplemento a")})
public class ActaComplemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estudiante_id")
    private String estudianteId;
    @Column(name = "docente_id")
    private String docenteId;
    @Basic(optional = false)
    @Column(name = "secretaria_id")
    private String secretariaId;
    @Column(name = "coordinador_id")
    private String coordinadorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActaFk")
    private Collection<DocumentoActa> documentoActaCollection;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;

    public ActaComplemento() {
    }

    public ActaComplemento(Integer id) {
        this.id = id;
    }

    public ActaComplemento(Integer id, String estudianteId, String secretariaId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.secretariaId = secretariaId;
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

    public Collection<DocumentoActa> getDocumentoActaCollection() {
        return documentoActaCollection;
    }

    public void setDocumentoActaCollection(Collection<DocumentoActa> documentoActaCollection) {
        this.documentoActaCollection = documentoActaCollection;
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
        if (!(object instanceof ActaComplemento)) {
            return false;
        }
        ActaComplemento other = (ActaComplemento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.entity.ActaComplemento[ id=" + id + " ]";
    }
    
}
