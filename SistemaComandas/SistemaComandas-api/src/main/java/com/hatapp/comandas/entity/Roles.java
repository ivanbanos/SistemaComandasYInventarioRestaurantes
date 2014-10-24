/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name = "roles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r"),
    @NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id"),
    @NamedQuery(name = "Roles.findByNombre", query = "SELECT r FROM Roles r WHERE r.nombre = :nombre")})
public class Roles implements Serializable {

    @JoinTable(name = "roles_has_funciones", joinColumns = {
        @JoinColumn(name = "Roles_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Funciones_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Funciones> funcionesList;
    @JoinTable(name = "roles_has_vistas", joinColumns = {
        @JoinColumn(name = "Roles_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Vistas_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Vistas> vistasList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    public Roles() {
        usuariosList = new ArrayList<Usuarios>();
        funcionesList = new ArrayList<Funciones>();
        vistasList = new ArrayList<Vistas>();
    }

    public Roles(Integer id) {
        this.id = id;
        usuariosList = new ArrayList<Usuarios>();
        funcionesList = new ArrayList<Funciones>();
        vistasList = new ArrayList<Vistas>();
    }

    public Roles(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        usuariosList = new ArrayList<Usuarios>();
        funcionesList = new ArrayList<Funciones>();
        vistasList = new ArrayList<Vistas>();
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

    @XmlTransient
    public List<Funciones> getFuncionesList() {
        return funcionesList;
    }

    public void setFuncionesList(List<Funciones> funcionesList) {
        this.funcionesList = funcionesList;
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
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Roles[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Vistas> getVistasList() {
        return vistasList;
    }

    public void setVistasList(List<Vistas> vistasList) {
        this.vistasList = vistasList;
    }
}
