/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.util;

import com.hatapp.comandas.entity.Funciones;

/**
 *
 * @author ideacentre
 */
public class FuncionesBoolean {
    private Funciones funcion;
    private boolean checked;

    public FuncionesBoolean(Funciones funcion, boolean checked) {
        this.funcion = funcion;
        this.checked = checked;
    }

    public FuncionesBoolean() {
    }

    public Funciones getFuncion() {
        return funcion;
    }

    public void setFuncion(Funciones funcion) {
        this.funcion = funcion;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
}
