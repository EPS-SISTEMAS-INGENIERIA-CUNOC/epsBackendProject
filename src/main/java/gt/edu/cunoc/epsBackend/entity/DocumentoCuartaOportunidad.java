/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.cunoc.epsBackend.entity;

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
@Table(name = "documento_cuarta_oportunidad")
@NamedQueries({
    @NamedQuery(name = "DocumentoCuartaOportunidad.findAll", query = "SELECT d FROM DocumentoCuartaOportunidad d")})
public class DocumentoCuartaOportunidad implements Serializable {

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
    @Column(name = "link")
    private String link;
    @JoinColumn(name = "id_cuarta_oportunidad_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CuartaOportunidad idCuartaOportunidadFk;

    public DocumentoCuartaOportunidad() {
    }

    public DocumentoCuartaOportunidad(Integer id) {
        this.id = id;
    }

    public DocumentoCuartaOportunidad(Integer id, String nombre, String link) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CuartaOportunidad getIdCuartaOportunidadFk() {
        return idCuartaOportunidadFk;
    }

    public void setIdCuartaOportunidadFk(CuartaOportunidad idCuartaOportunidadFk) {
        this.idCuartaOportunidadFk = idCuartaOportunidadFk;
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
        if (!(object instanceof DocumentoCuartaOportunidad)) {
            return false;
        }
        DocumentoCuartaOportunidad other = (DocumentoCuartaOportunidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.edu.cunoc.epsBackend.entity.DocumentoCuartaOportunidad[ id=" + id + " ]";
    }
    
}
