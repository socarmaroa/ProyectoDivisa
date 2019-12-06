/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.tbtasacambio;

import com.prueba.modelo.TbTasacambio;
import com.prueba.control.general.ControlDaoImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Clase para implementar las acciones de sql en la entidad TasaCambio
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
class TbTasacambioFacadeDao extends ControlDaoImpl<TbTasacambio> {

    /**
     * Constructor de la gestión de datos de la entidad TbTbDivisa Se inicializa
     * el constructor padre, pasandole la clase con la que se va a trabajar
     */
    public TbTasacambioFacadeDao() {
        super(TbTasacambio.class);
    }

    /**
     * Busca en la base de datos el registro TasaCambio que cumpla con el
     * parámetro de llave primaria.
     *
     * @param id parámetro llave primaria.
     * @return un null o una instancia de la clase TasaCambio
     */
    @Override
    public TbTasacambio find(Object id) {
        TbTasacambio aux = null;
        try {
            String str = "SELECT t FROM TbTasacambio t "
                    + "WHERE t.idTasacambio = :idTasacambio";
            Query query = getEntityManager().createQuery(str);
            query.setParameter("idTasacambio", id);
            query.setMaxResults(1);
            query.setFirstResult(0);
            aux = (TbTasacambio) query.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    /**
     * Buscar en la base de datos en la tabla TasaCambio todos los registros que
     * tengan el paramatro TbDivisa activo y ordenado por TbDivisa abreviatura.
     *
     * @return un listado de tasas de cambio.
     */
    protected List<TbTasacambio> findAllActive() {
        try {
            String str = "SELECT t FROM TbTasacambio t "
                    + "WHERE t.idDivisa1.activa=true "
                    + "AND t.idDivisa2.activa=true "
                    + "ORDER by t.idDivisa1.abreviaturaDivisa ";
            Query q = getEntityManager().createQuery(str);
            List<TbTasacambio> list = q.getResultList();
            return list;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

/**
 * Clase para implementar la lógica de negocio con la entidad TasaCambio
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 */
@Stateless
public class ControlTbTasacambioImpl
        extends TbTasacambioFacadeDao
        implements ControlTbTasacambio {

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public List<TbTasacambio> findListaTasasCambio() {
        return super.findAllActive();
    }

}
