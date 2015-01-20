/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.util;

import com.hatapp.comandas.entity.Vistas;

/**
 *
 * @author ideacentre
 */
public class VistasBoolean {
    
    private Vistas vista;
    private boolean checked;

    public VistasBoolean() {
    }

    public VistasBoolean(Vistas vista, boolean checked) {
        this.vista = vista;
        this.checked = checked;
    }

    public Vistas getVista() {
        return vista;
    }

    public void setVista(Vistas vista) {
        this.vista = vista;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
}
