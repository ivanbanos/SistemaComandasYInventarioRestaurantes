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
@Table(name = "atributosclientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atributosclientes.findAll", query = "SELECT a FROM Atributosclientes a"),
    @NamedQuery(name = "Atributosclientes.findById", query = "SELECT a FROM Atributosclientes a WHERE a.id = :id"),
    @NamedQuery(name = "Atributosclientes.findByNombre", query = "SELECT a FROM Atributosclientes a WHERE a.nombre = :nombre")})
public class Atributosclientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinTable(name = "clientes_has_atributos", joinColumns = {
        @JoinColumn(name = "AtributosClientes_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Clientes_id", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Clientes> clientesList;

    public Atributosclientes() {
    }

    public Atributosclientes(Integer id) {
        this.id = id;
    }

    public Atributosclientes(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
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
        if (!(object instanceof Atributosclientes)) {
            return false;
        }
        Atributosclientes other = (Atributosclientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hatapp.comandas.entity.Atributosclientes[ id=" + id + " ]";
    }
    
}
