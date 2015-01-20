/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.comandas.facade;

import com.hatapp.comandas.entity.Acompanantes;
import com.hatapp.comandas.entity.Fotos;
import com.hatapp.comandas.entity.Ingredientes;
import com.hatapp.comandas.entity.Mesas;
import com.hatapp.comandas.entity.Platos;
import com.hatapp.comandas.entity.Unidadesmedidas;
import java.util.List;

/**
 *
 * @author ideacentre
 */
public interface ManagerUserFacade {

    public List<Mesas> getAllMesas();

    public void guardarMesa(Mesas elemento);

    public void editarMesa(Mesas elemento);

    public void borrarMesa(Mesas elemento);

    public List<Ingredientes> getAllIngredientes();

    public void crearIngredientes(Ingredientes elemento);

    public void editarIngredientes(Ingredientes elemento);

    public void borrarIngredientes(Ingredientes elemento);

    public List<Platos> getAllPlatos();

    public List<Acompanantes> getAllAcompañantes();

    public void borrarPlato(Platos p);

    public void borrarAcompañante(Acompanantes p);

    public Platos findPlato(Integer integer);

    public Fotos crearFoto(Fotos foto);

    public void crearPlato(Platos elemento);

    public List<Unidadesmedidas> getAllUnidadesDeMedida();

    
}
