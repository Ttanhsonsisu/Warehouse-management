package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.DAO.ProductDAO;
import org.example.model.entities.Product;
import raven.toast.Notifications;

import java.util.ArrayList;
import java.util.List;

public class ServiceProduct {

    private final EntityManager em;

    private ProductDAO productDAO;

    public ServiceProduct(EntityManager em) {
        this.em = em;
        productDAO = new ProductDAO(em);
    }

    public List<Product> findAllProduct() {
       List<Product> products = new ArrayList<>();
        try {
            em.getTransaction().begin();
            products = productDAO.findAll();
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return products;
        }
    }

    public boolean delProduct(Product product) {
        boolean success = true;
        try {
            em.getTransaction().begin();

            Product productDel = em.find(Product.class, product.getIdProduct());
            em.remove(productDel);
        } catch(Exception e) {
            e.printStackTrace();
            //Notifications.getInstance().show(Notifications.Type.ERROR , "Vật phẩm chưa được xóa");
            success = false;
        } finally {
            em.getTransaction().commit();
            return success;
        }
    }
}
