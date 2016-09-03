/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.petfcv.repository;

import com.petfcv.jpaUtil.JpaUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

/**
 *
 * @author tibe
 * @param <T>
 */
public class RepositorioGenerico<T extends Serializable> implements Serializable {

    private final EntityManager entityManager = JpaUtil.getEntityManager();

    private Class<T> clazz;

    public RepositorioGenerico(final Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public void save(final T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro no Gravar RepositorioGenerico \n"
                    + "\n--------------------------------------------------------------------------\n"
                    + e
                    + "\n--------------------------------------------------------------------------\n");
            entityManager.getTransaction().rollback();
        }
    }

    public void update(final T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {

            System.out.println("Erro no update RepositorioGenerico \n"
                    + "--------------------------------------------------------------------------\n"
                    + e
                    + "--------------------------------------------------------------------------\n");
            entityManager.getTransaction().rollback();
        }
    }

    public void delete(final T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro no delete RepositorioGenerico \n"
                    + "--------------------------------------------------------------------------\n"
                    + e
                    + "--------------------------------------------------------------------------\n");
            entityManager.getTransaction().rollback();
        }
    }

    public List<T> findAll() {
        List<T> list;
        try {
            list = entityManager.createQuery("FROM " + clazz.getSimpleName()).getResultList();

            return list;
        } catch (Exception e) {

            System.out.println("Erro no no findForCodigoUnico 1 parametro RepositorioGenerico !!!!!!! \n "
                    + "--------------------------------------------------------------------------\n"
                    + e
                    + "--------------------------------------------------------------------------\n");
            return null;
        }
    }
    
        @Transient
    public Object findForCodigoUnico(final Long id) {
        try {
            return entityManager.find(clazz, id);
        } catch (Exception e) {
           
            System.out.println("Erro no no findForCodigoUnico 1 parametro RepositorioGenerico !!!!!!! \n "
                    + "--------------------------------------------------------------------------\n"
                    + e
                    + "--------------------------------------------------------------------------\n");

            return null;
        }

    }

}
