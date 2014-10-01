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
@Table(name = "atributosusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atributosusuario.findAll", query = "SELECT a FROM Atributosusuario a"),
    @NamedQuery(name = "Atributosusuario.findById", query = "SELECT a FROM Atributosusuario a WHERE a.id = :id"),
    @NamedQuery(name = "Atributosusuario.findByNombre", query = "SELECT a FROM Atributosusuario a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Atributosusuario.findByTipo", query = "SELECT a FROM Atributosusuario a WHERE a.tipo = :tipo")})
public class Atributosusuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private Integer tipo;
    @JoinTable(name = "usuarios_has_atributos", joinColumns = {
        @JoinColumn(name = "AtributosUsuario_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Usuarios_username", referencedColumnName = "username")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    public Atributosusuario() {
    }

    public Atributosusuario(Integer id) {
        this.id = id;
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

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
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
        if (!(object instanceof Atributosusuario)) {
            return false;
        }
        Atributosusuario other = (Atributosusuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Atributosusuario[ id=" + id + " ]";
    }
    
}
