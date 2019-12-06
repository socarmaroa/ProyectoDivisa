/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbvalortasacambio;

import com.prueba.modelo.TbValortasacambio;
import javax.ejb.Local;
import com.prueba.control.general.ControlDao;
import com.prueba.modelo.TbTasacambio;

/**
 * Clase para exponer todos los metodos generales de la entidad TbCotizacion
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Local
public interface ControlTbValortasacambio
        extends ControlDao<TbValortasacambio> {

    /**
     * Solicita la busqueda del valor de la tasa de cambio teniendo en cuenta
     * que la tasa de cambio debe ser obligatoria.
     *
     * @param tbTasacambio parámetro tasa de cambio
     * @return un null o una instancia
     */
    public TbValortasacambio findFinishValue(TbTasacambio tbTasacambio);

}
