/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.POJOs;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ridao
 */
@Entity
@Table(name = "material")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Material.findAll", query = "SELECT m FROM Material m")
    , @NamedQuery(name = "Material.findByMaterialId", query = "SELECT m FROM Material m WHERE m.materialId = :materialId")
    , @NamedQuery(name = "Material.findByRutaArchivo", query = "SELECT m FROM Material m WHERE m.rutaArchivo = :rutaArchivo")
    , @NamedQuery(name = "Material.findByNombre", query = "SELECT m FROM Material m WHERE m.nombre = :nombre")})
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "materialId")
    private Integer materialId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "rutaArchivo")
    private String rutaArchivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "asignaturaId", referencedColumnName = "asignaturaId")
    @ManyToOne(optional = false)
    private Asignaturas asignaturaId;

    public Material() {
    }

    public Material(Integer materialId) {
        this.materialId = materialId;
    }

    public Material(Integer materialId, String rutaArchivo, String nombre) {
        this.materialId = materialId;
        this.rutaArchivo = rutaArchivo;
        this.nombre = nombre;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Asignaturas getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Asignaturas asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialId != null ? materialId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.materialId == null && other.materialId != null) || (this.materialId != null && !this.materialId.equals(other.materialId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.POJOs.Material[ materialId=" + materialId + " ]";
    }
    
}
