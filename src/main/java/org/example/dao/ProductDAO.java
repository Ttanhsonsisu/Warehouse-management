package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Product;

import java.util.List;

public class ProductDAO implements DAOInterface<Product>{

    private final EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }
// chua lam

    @Override
    public List<Product> selectAll() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        TypedQuery<Product> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

    @Override
    public int insert(Product product) {
        return 0;
    }

    @Override
    public int delete(Product product) {
        return 0;
    }

    @Override
    public Product selectById(Product product) {
        return null;
    }

    @Override
    public List<Product> selectByCondition(String condition) {
        return List.of();
    }
}
