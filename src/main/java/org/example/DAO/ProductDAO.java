package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Product;

import java.util.List;


public class ProductDAO {
    private final EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

    public List<Product> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    public void insert(Product product) {
        em.persist(product);
    }


    public Integer findProductIdByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        Predicate predicate = cb.equal(root.get("name"), name);
        cq.where(predicate);
        TypedQuery<Product> query = em.createQuery(cq);
        var result = query.getSingleResult();
        return result.getIdProduct();
    }
}
