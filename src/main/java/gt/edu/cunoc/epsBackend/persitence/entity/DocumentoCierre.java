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
@Table(name = "DOCUMENTO_CIERRE")
@NamedQueries({
    @NamedQuery(name = "DocumentoCierre.findAll", query = "SELECT d FROM DocumentoCierre d"),
    @NamedQuery(name = "DocumentoCierre.findById", query = "SELECT d FROM DocumentoCierre d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentoCierre.findByNombre", query = "SELECT d FROM DocumentoCierre d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DocumentoCierre.findByLinkDoc", query = "SELECT d FROM DocumentoCierre d WHERE d.linkDoc = :linkDoc")})
public class DocumentoCierre implements Serializable {

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
    @Column(name = "link_doc")
    private String linkDoc;
    @JoinColumn(name = "id_cierre_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DictamenCierre idCierreFk;

    public DocumentoCierre() {
    }

    public DocumentoCierre(Integer id) {
        this.id = id;
    }

    public DocumentoCierre(Integer id, String nombre, String linkDoc) {
        this.id = id;
        this.nombre = nombre;
        this.linkDoc = linkDoc;
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

    public String getLinkDoc() {
        return linkDoc;
    }

    public void setLinkDoc(String linkDoc) {
        this.linkDoc = linkDoc;
    }

    public DictamenCierre getIdCierreFk() {
        return idCierreFk;
    }

    public void setIdCierreFk(DictamenCierre idCierreFk) {
        this.idCierreFk = idCierreFk;
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
        if (!(object instanceof DocumentoCierre)) {
            return false;
        }
        DocumentoCierre other = (DocumentoCierre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.persitence.entity.DocumentoCierre[ id=" + id + " ]";
    }
    
}
