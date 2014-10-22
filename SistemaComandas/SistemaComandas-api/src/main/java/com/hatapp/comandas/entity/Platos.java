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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivan
 */
@Entity
@Table(name = "platos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platos.findAll", query = "SELECT p FROM Platos p"),
    @NamedQuery(name = "Platos.findById", query = "SELECT p FROM Platos p WHERE p.id = :id"),
    @NamedQuery(name = "Platos.findByNombre", query = "SELECT p FROM Platos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Platos.findByPrecio", query = "SELECT p FROM Platos p WHERE p.precio = :precio"),
    @NamedQuery(name = "Platos.findByGrupo", query = "SELECT p FROM Platos p WHERE p.grupo = :grupo"),
    @NamedQuery(name = "Platos.findByTipo", query = "SELECT p FROM Platos p WHERE p.tipo = :tipo")})
public class Platos implements Serializable {
    @ManyToMany(mappedBy = "platosList")
    private List<Menu> menuList;
    @JoinTable(name = "platos_has_ingredientes", joinColumns = {
        @JoinColumn(name = "Platos_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Ingredientes_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Ingredientes> ingredientesList;
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
    @Column(name = "precio")
    private float precio;
    @Column(name = "grupo")
    private String grupo;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinColumn(name = "Foto", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Fotos foto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platos", fetch = FetchType.EAGER)
    private List<PedidosHasPlatos> pedidosHasPlatosList;

    public Platos() {
    }

    public Platos(Integer id) {
        this.id = id;
    }

    public Platos(Integer id, String nombre, float precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Ingredientes> getIngredientesList() {
        return ingredientesList;
    }

    public void setIngredientesList(List<Ingredientes> ingredientesList) {
        this.ingredientesList = ingredientesList;
    }

    public Fotos getFoto() {
        return foto;
    }

    public void setFoto(Fotos foto) {
        this.foto = foto;
    }

    @XmlTransient
    public List<PedidosHasPlatos> getPedidosHasPlatosList() {
        return pedidosHasPlatosList;
    }

    public void setPedidosHasPlatosList(List<PedidosHasPlatos> pedidosHasPlatosList) {
        this.pedidosHasPlatosList = pedidosHasPlatosList;
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
        if (!(object instanceof Platos)) {
            return false;
        }
        Platos other = (Platos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Platos[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    
}
