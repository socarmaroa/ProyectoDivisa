/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbdivisa;

import com.prueba.modelo.TbDivisa;
import javax.ejb.Local;
import com.prueba.control.general.ControlDao;

/**
 * Clase para exponer todos los metodos generales de la entidad TbDivisa
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Local
public interface ControlTbDivisa extends ControlDao<TbDivisa> {

}
