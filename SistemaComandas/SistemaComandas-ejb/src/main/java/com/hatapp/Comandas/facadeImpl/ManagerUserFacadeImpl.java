/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.facadeImpl;

import com.hatapp.comandas.entity.Acompanantes;
import com.hatapp.comandas.entity.Fotos;
import com.hatapp.comandas.entity.Ingredientes;
import com.hatapp.comandas.entity.Inventario;
import com.hatapp.comandas.entity.Mesas;
import com.hatapp.comandas.entity.Platos;
import com.hatapp.comandas.entity.Unidadesmedidas;
import com.hatapp.comandas.facade.ManagerUserFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ideacentre
 */
@Stateless
public class ManagerUserFacadeImpl implements ManagerUserFacade{
    
    @EJB
    MesasFacade mesasFacade;
    @EJB
    IngredientesFacade ingredientesFacade;
    @EJB
    InventarioFacade inventarioFacade;
    @EJB
    PlatosFacade platosFacade;
    @EJB
    AcompanantesFacade acompanantesFacade;
    @EJB
    FotosFacade fotosFacade;
    @EJB
    UnidadesmedidasFacade unidadesmedidasFacade;

    @Override
    public List<Mesas> getAllMesas() {
        return mesasFacade.findAll();
    }

    @Override
    public void guardarMesa(Mesas elemento) {
        mesasFacade.create(elemento);
    }

    @Override
    public void editarMesa(Mesas elemento) {
        mesasFacade.edit(elemento);
    }

    @Override
    public void borrarMesa(Mesas elemento) {
        mesasFacade.remove(elemento);
    }

    @Override
    public List<Ingredientes> getAllIngredientes() {
        return ingredientesFacade.findAll();
    }

    @Override
    public void crearIngredientes(Ingredientes elemento) {
        Inventario inventario = new Inventario();
        inventarioFacade.create(inventario);
        elemento.setInventarioid(inventario);
        ingredientesFacade.create(elemento);
    }

    @Override
    public void editarIngredientes(Ingredientes elemento) {
        ingredientesFacade.edit(elemento);
    }

    @Override
    public void borrarIngredientes(Ingredientes elemento) {
        ingredientesFacade.remove(elemento);
    }

    @Override
    public List<Platos> getAllPlatos() {
        return platosFacade.findAll();
    }

    @Override
    public List<Acompanantes> getAllAcompañantes() {
        return acompanantesFacade.findAll();
    }

    @Override
    public void borrarPlato(Platos p) {
        platosFacade.remove(p);
    }

    @Override
    public void borrarAcompañante(Acompanantes p) {
        acompanantesFacade.remove(p);
    }

    @Override
    public Platos findPlato(Integer integer) {
        return platosFacade.find(integer);
    }

    @Override
    public Fotos crearFoto(Fotos foto) {
        fotosFacade.create(foto);
        return foto;
    }

    @Override
    public void crearPlato(Platos elemento) {
        platosFacade.create(elemento);
    }

    @Override
    public List<Unidadesmedidas> getAllUnidadesDeMedida() {
        return unidadesmedidasFacade.findAll();
    }
    
}
