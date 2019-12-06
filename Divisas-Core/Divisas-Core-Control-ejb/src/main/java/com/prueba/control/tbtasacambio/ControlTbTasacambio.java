/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbtasacambio;

import com.prueba.modelo.TbTasacambio;
import java.util.List;
import javax.ejb.Local;
import com.prueba.control.general.ControlDao;

/**
 * Clase para exponer todos los metodos generales de la entidad TasaCambio
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Local
public interface ControlTbTasacambio
        extends ControlDao<TbTasacambio> {

    /**
     * Busca en la base de datos las tasas de cambio disponibles para realizar
     * cotizaciones.
     *
     * @return un listado de tasas de cambio disponibles para cotizaciones.
     */
    public List<TbTasacambio> findListaTasasCambio();

}
