/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "unidadesmedidas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadesmedidas.findAll", query = "SELECT u FROM Unidadesmedidas u"),
    @NamedQuery(name = "Unidadesmedidas.findById", query = "SELECT u FROM Unidadesmedidas u WHERE u.id = :id"),
    @NamedQuery(name = "Unidadesmedidas.findByUnidad", query = "SELECT u FROM Unidadesmedidas u WHERE u.unidad = :unidad"),
    @NamedQuery(name = "Unidadesmedidas.findByAbreviacion", query = "SELECT u FROM Unidadesmedidas u WHERE u.abreviacion = :abreviacion")})
public class Unidadesmedidas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(max = 45)
    @Column(name = "unidad")
    private String unidad;
    @Size(max = 45)
    @Column(name = "abreviacion")
    private String abreviacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadesMedidasid")
    private List<Ingredientes> ingredientesList;

    public Unidadesmedidas() {
    }

    public Unidadesmedidas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    @XmlTransient
    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
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
        if (!(object instanceof Unidadesmedidas)) {
            return false;
        }
        Unidadesmedidas other = (Unidadesmedidas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Unidadesmedidas[ id=" + id + " ]";
    }
    
}
