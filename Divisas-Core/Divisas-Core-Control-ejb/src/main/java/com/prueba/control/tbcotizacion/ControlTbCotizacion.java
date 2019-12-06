/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbcotizacion;

import com.prueba.modelo.TbCotizacion;
import javax.ejb.Local;
import com.prueba.control.general.ControlDao;

/**
 * Clase para exponer todos los metodos generales de la entidad TbCotizacion
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Local
public interface ControlTbCotizacion extends ControlDao<TbCotizacion> {

}
