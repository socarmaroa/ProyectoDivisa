/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.control.general;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * Clase genérica para implementar todos los metodos generales persistentes.
 *
 * @author Armando Becerra Rodríguez
 * @version 1.0
 * @param <T> entidad que representa la tabla de la base de datos.
 */
public abstract class ControlDaoImpl<T>
        implements ControlDao<T> {

    /**
     * Variable que representa la unidad persistente conectada a la base de
     * datos
     */
    @PersistenceContext(unitName = "DatosDivisa")
    private EntityManager em;

    /**
     * identificador de la clase entidad con la que se está trabajando
     */
    private final Class<T> entityClass;

    /**
     * Constructor con parámetro entidad clase a crear
     *
     * @param entityClass entidad clase
     */
    public ControlDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Entity manager para la busqueda de información de la base de datos
     *
     * @return un objeto entity manager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity {@inheritDoc}
     */
    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity {@inheritDoc}
     */
    @Override
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     * {@inheritDoc}
     *
     * @param entity {@inheritDoc}
     */
    @Override
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * {@inheritDoc}
     *
     * @param id {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq
                = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     * {@inheritDoc}
     *
     * @param range {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq
                = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq
                = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
