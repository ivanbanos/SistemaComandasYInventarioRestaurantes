/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatapp.Comandas.util;

/**
 *
 * @author ivan
 */
public class ObjectBoolean {
    private Object object;
    private boolean selected;
    private String label;

    public ObjectBoolean() {
    }

    public ObjectBoolean(Object object, boolean selected, String label) {
        this.object = object;
        this.selected = selected;
        this.label = label;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
