/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbvalortasacambio;

import com.prueba.control.general.ControlDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import java.util.List;
import javax.ejb.Stateless;
import com.prueba.modelo.TbTasacambio;
import com.prueba.modelo.TbValortasacambio;

/**
 * Clase para implementar las acciones de sql en la entidad ValorTasaCambio
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
class TbValortasacambioFacadeDao
        extends ControlDaoImpl<TbValortasacambio> {

    /**
     * Constructor de la gestión de datos de la entidad TbTbDivisa Se inicializa
     * el constructor padre, pasandole la clase con la que se va a trabajar
     */
    public TbValortasacambioFacadeDao() {
        super(TbValortasacambio.class);
    }

    /**
     * Sobre escribe el método primario buscando por rango los ValorTasaCambio
     * ordenado por fecha de registro
     *
     * @param range rango de busqueda
     * @return listado encontrado
     */
    @Override
    public List<TbValortasacambio> findRange(int[] range) {
        try {
            String str = "SELECT t FROM TbValortasacambio t "
                    + "ORDER BY t.fechaValortasacambio DESC";
            Query q = getEntityManager().createQuery(str);
            q.setMaxResults(range[1] - range[0] + 1);
            q.setFirstResult(range[0]);
            return q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Busca en la base de datos el valor de tasa de cambio registrado por
     * última ves de la tasa de cambio recibida como parámetro.
     *
     * @param tbTasacambio objeto tasa de cambio.
     * @return un null o una instancia de la clase ValorTasaCambio que
     * corresponde a la busqueda realizada.
     */
    protected TbValortasacambio findFinishValueDao(TbTasacambio tbTasacambio) {
        TbValortasacambio aux = null;
        try {
            String str = "SELECT t FROM TbValortasacambio t "
                    + "WHERE t.idTasacambio = :idTasacambio "
                    + "ORDER BY t.fechaValortasacambio DESC";
            Query query = getEntityManager().createQuery(str);
            query.setParameter("idTasacambio", tbTasacambio);
            query.setMaxResults(1);
            query.setFirstResult(0);
            aux = (TbValortasacambio) query.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

}

/**
 * Clase para implementar la lógica de negocio con la entidad ValorTasaCambio
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Stateless
public class ControlTbValortasacambioImpl
        extends TbValortasacambioFacadeDao
        implements ControlTbValortasacambio {

    /**
     * {@inheritDoc}
     *
     * @param tbTasacambio {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public TbValortasacambio findFinishValue(TbTasacambio tbTasacambio) {
        if (null == tbTasacambio) {
            try {
                throw new Exception("Failed : tasa de cambio no puede ser nula");
            } catch (Exception ex) {
                Logger.getLogger(ControlTbValortasacambioImpl.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return super.findFinishValueDao(tbTasacambio);
    }
}
