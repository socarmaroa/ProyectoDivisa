/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbcotizacion;

import com.prueba.modelo.TbCotizacion;
import com.prueba.control.general.ControlDaoImpl;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Clase para implementar las acciones de sql en la entidad TbCotizacion
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
class TbCotizacionFacadeDao extends ControlDaoImpl<TbCotizacion> {

    /**
     * Constructor de la gestión de datos de la entidad TbCotizacion Se
     * inicializa el constructor padre, pasandole la clase con la que se va a
     * trabajar
     */
    public TbCotizacionFacadeDao() {
        super(TbCotizacion.class);
    }

    /**
     * Sobre escribe el método primario buscando por rango los TbValortasacambio
     * ordenado por fecha de registro
     *
     * @param range rango de busqueda
     * @return listado encontrado
     */
    @Override
    public List<TbCotizacion> findRange(int[] range) {
        try {
            String str = "SELECT t FROM TbCotizacion t "
                    + "ORDER BY t.fechaRegistro DESC";
            Query q = getEntityManager().createQuery(str);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

/**
 * Clase para implementar la lógica de negocio con la entidad TbCotizacion
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Stateless
public class ControlTbCotizacionImpl
        extends TbCotizacionFacadeDao
        implements ControlTbCotizacion {

}
