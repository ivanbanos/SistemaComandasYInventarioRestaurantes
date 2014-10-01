/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "ingredientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredientes.findAll", query = "SELECT i FROM Ingredientes i"),
    @NamedQuery(name = "Ingredientes.findById", query = "SELECT i FROM Ingredientes i WHERE i.id = :id"),
    @NamedQuery(name = "Ingredientes.findByNombre", query = "SELECT i FROM Ingredientes i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Ingredientes.findByUnidadMedida", query = "SELECT i FROM Ingredientes i WHERE i.unidadMedida = :unidadMedida")})
public class Ingredientes implements Serializable {
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
    @Column(name = "unidadMedida")
    private String unidadMedida;
    @ManyToMany(mappedBy = "ingredientesList", fetch = FetchType.EAGER)
    private List<Acompanantes> acompanantesList;
    @JoinTable(name = "platos_has_ingredientes", joinColumns = {
        @JoinColumn(name = "Ingredientes_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Platos_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Platos> platosList;
    @JoinColumn(name = "Inventario_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Inventario inventarioid;

    public Ingredientes() {
    }

    public Ingredientes(Integer id) {
        this.id = id;
    }

    public Ingredientes(Integer id, String nombre, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
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

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @XmlTransient
    public List<Acompanantes> getAcompanantesList() {
        return acompanantesList;
    }

    public void setAcompanantesList(List<Acompanantes> acompanantesList) {
        this.acompanantesList = acompanantesList;
    }

    @XmlTransient
    public List<Platos> getPlatosList() {
        return platosList;
    }

    public void setPlatosList(List<Platos> platosList) {
        this.platosList = platosList;
    }

    public Inventario getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(Inventario inventarioid) {
        this.inventarioid = inventarioid;
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
        if (!(object instanceof Ingredientes)) {
            return false;
        }
        Ingredientes other = (Ingredientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Ingredientes[ id=" + id + " ]";
    }
    
}
