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
@Table(name = "dictamen_cierre")
@NamedQueries({
    @NamedQuery(name = "DictamenCierre.findAll", query = "SELECT d FROM DictamenCierre d")})
public class DictamenCierre implements Serializable {

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
    @Column(name = "coordinador_id")
    private String coordinadorId;
    @Basic(optional = false)
    @Column(name = "secretaria_id")
    private String secretariaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota")
    private Double nota;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCierreFk")
    private Collection<DocumentoCierre> documentoCierreCollection;

    public DictamenCierre() {
    }

    public DictamenCierre(Integer id) {
        this.id = id;
    }

    public DictamenCierre(Integer id, String estudianteId, String coordinadorId, String secretariaId) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.coordinadorId = coordinadorId;
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

    public String getCoordinadorId() {
        return coordinadorId;
    }

    public void setCoordinadorId(String coordinadorId) {
        this.coordinadorId = coordinadorId;
    }

    public String getSecretariaId() {
        return secretariaId;
    }

    public void setSecretariaId(String secretariaId) {
        this.secretariaId = secretariaId;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public EtapaSolicitud getEtapaSolicitudFk() {
        return etapaSolicitudFk;
    }

    public void setEtapaSolicitudFk(EtapaSolicitud etapaSolicitudFk) {
        this.etapaSolicitudFk = etapaSolicitudFk;
    }

    public Collection<DocumentoCierre> getDocumentoCierreCollection() {
        return documentoCierreCollection;
    }

    public void setDocumentoCierreCollection(Collection<DocumentoCierre> documentoCierreCollection) {
        this.documentoCierreCollection = documentoCierreCollection;
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
        if (!(object instanceof DictamenCierre)) {
            return false;
        }
        DictamenCierre other = (DictamenCierre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.entity.DictamenCierre[ id=" + id + " ]";
    }
    
}
