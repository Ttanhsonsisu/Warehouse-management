package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Supplier;

import java.util.List;


public class SupplierDAO implements DAOInterface {

    private final EntityManager em;

    public SupplierDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public List<Supplier> selectAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Supplier> cq = cb.createQuery(Supplier.class);
        Root<Supplier> root = cq.from(Supplier.class);
        TypedQuery<Supplier> q = em.createQuery(cq);

        return q.getResultList();
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public List selectByCondition(String condition) {
        return List.of();
    }
}
