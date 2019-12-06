/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.bean.converter;

import com.prueba.bean.SolicitudesController;
import com.prueba.modelo.TbTasacambio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Armando Becerra Rodríguez
 */
@FacesConverter(forClass = TbTasacambio.class)
public class TasaDeCambioControllerConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        SolicitudesController controller = (SolicitudesController) facesContext.getApplication().getELResolver().
                getValue(facesContext.getELContext(), null, "solicitudesController");
        return controller.getTbTasacambio(getKey(value));
    }

    java.lang.Integer getKey(String value) {
        java.lang.Integer key;
        key = Integer.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Integer value) {
        StringBuilder sb = new StringBuilder();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof TbTasacambio) {
            TbTasacambio o = (TbTasacambio) object;
            return getStringKey(o.getIdTasacambio());
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TbTasacambio.class.getName());
        }
    }

}
