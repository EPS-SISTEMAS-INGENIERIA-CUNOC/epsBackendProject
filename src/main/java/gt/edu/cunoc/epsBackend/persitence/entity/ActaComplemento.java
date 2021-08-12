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
@Table(name = "ACTA_COMPLEMENTO")
@NamedQueries({
    @NamedQuery(name = "ActaComplemento.findAll", query = "SELECT a FROM ActaComplemento a"),
    @NamedQuery(name = "ActaComplemento.findById", query = "SELECT a FROM ActaComplemento a WHERE a.id = :id"),
    @NamedQuery(name = "ActaComplemento.findByIdEstudiante", query = "SELECT a FROM ActaComplemento a WHERE a.idEstudiante = :idEstudiante"),
    @NamedQuery(name = "ActaComplemento.findByIdDocente", query = "SELECT a FROM ActaComplemento a WHERE a.idDocente = :idDocente"),
    @NamedQuery(name = "ActaComplemento.findByIdSecretaroa", query = "SELECT a FROM ActaComplemento a WHERE a.idSecretaroa = :idSecretaroa"),
    @NamedQuery(name = "ActaComplemento.findByIdCoordinador", query = "SELECT a FROM ActaComplemento a WHERE a.idCoordinador = :idCoordinador")})
public class ActaComplemento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_estudiante")
    private String idEstudiante;
    @Column(name = "id_docente")
    private String idDocente;
    @Basic(optional = false)
    @Column(name = "id_secretaroa")
    private String idSecretaroa;
    @Column(name = "id_coordinador")
    private String idCoordinador;
    @JoinColumn(name = "etapa_solicitud_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaSolicitud etapaSolicitudFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idActaFk")
    private Collection<DocumentoActa> documentoActaCollection;

    public ActaComplemento() {
    }

    public ActaComplemento(Integer id) {
        this.id = id;
    }

    public ActaComplemento(Integer id, String idEstudiante, String idSecretaroa) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idSecretaroa = idSecretaroa;
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

    public String getIdSecretaroa() {
        return idSecretaroa;
    }

    public void setIdSecretaroa(String idSecretaroa) {
        this.idSecretaroa = idSecretaroa;
    }

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public EtapaSolicitud getEtapaSolicitudFk() {
        return etapaSolicitudFk;
    }

    public void setEtapaSolicitudFk(EtapaSolicitud etapaSolicitudFk) {
        this.etapaSolicitudFk = etapaSolicitudFk;
    }

    public Collection<DocumentoActa> getDocumentoActaCollection() {
        return documentoActaCollection;
    }

    public void setDocumentoActaCollection(Collection<DocumentoActa> documentoActaCollection) {
        this.documentoActaCollection = documentoActaCollection;
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
        return "gt.edu.cunoc.epsBackend.persitence.entity.ActaComplemento[ id=" + id + " ]";
    }
    
}
