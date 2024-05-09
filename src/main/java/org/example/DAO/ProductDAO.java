package org.example.DAO;

import jakarta.persistence.EntityManager;


public class ProductDAO {
    private final EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;
    }

}
