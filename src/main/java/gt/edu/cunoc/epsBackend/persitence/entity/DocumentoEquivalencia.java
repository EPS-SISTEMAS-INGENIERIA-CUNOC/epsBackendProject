/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.persitence.entity;

import java.io.Serializable;
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

/**
 *
 * @author teodoro
 */
@Entity
@Table(name = "DOCUMENTO_EQUIVALENCIA")
@NamedQueries({
    @NamedQuery(name = "DocumentoEquivalencia.findAll", query = "SELECT d FROM DocumentoEquivalencia d"),
    @NamedQuery(name = "DocumentoEquivalencia.findById", query = "SELECT d FROM DocumentoEquivalencia d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentoEquivalencia.findByNombre", query = "SELECT d FROM DocumentoEquivalencia d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DocumentoEquivalencia.findByLinkDocumento", query = "SELECT d FROM DocumentoEquivalencia d WHERE d.linkDocumento = :linkDocumento")})
public class DocumentoEquivalencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "link_documento")
    private String linkDocumento;
    @JoinColumn(name = "id_equivalencia_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DictamenEquivalencia idEquivalenciaFk;

    public DocumentoEquivalencia() {
    }

    public DocumentoEquivalencia(Integer id) {
        this.id = id;
    }

    public DocumentoEquivalencia(Integer id, String nombre, String linkDocumento) {
        this.id = id;
        this.nombre = nombre;
        this.linkDocumento = linkDocumento;
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

    public String getLinkDocumento() {
        return linkDocumento;
    }

    public void setLinkDocumento(String linkDocumento) {
        this.linkDocumento = linkDocumento;
    }

    public DictamenEquivalencia getIdEquivalenciaFk() {
        return idEquivalenciaFk;
    }

    public void setIdEquivalenciaFk(DictamenEquivalencia idEquivalenciaFk) {
        this.idEquivalenciaFk = idEquivalenciaFk;
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
        if (!(object instanceof DocumentoEquivalencia)) {
            return false;
        }
        DocumentoEquivalencia other = (DocumentoEquivalencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.DocumentoEquivalencia[ id=" + id + " ]";
    }
    
}
