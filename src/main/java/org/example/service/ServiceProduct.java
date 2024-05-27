package org.example.service;

import jakarta.persistence.EntityManager;
import org.example.DAO.ProductDAO;
import org.example.DAO.UserAppDAO;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
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

    public Product findById(int id) {
        Product result = new Product();
        try {
            em.getTransaction().begin();
            result = productDAO.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return result;
        }
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
            Notifications.getInstance().show(Notifications.Type.ERROR , "Vật phẩm chưa được xóa");
            success = false;
        } finally {
            em.getTransaction().commit();
            return success;

        }
    }

    public void inserProduct(Product product) {
        try {
            em.getTransaction().begin();
            productDAO.insert(product);
        }catch(Exception e) {
            e.printStackTrace();
        } finally{
            em.getTransaction().commit();
        }
    }
    public boolean checkProductInDB(Product product) {
        boolean success = false;
        try {
            em.getTransaction().begin();
            productDAO.findById(product.getIdProduct());
            success = true;
        } catch(Exception e) {
            em.getTransaction().rollback();
            success = false;
            e.printStackTrace();
        } finally {
            em.getTransaction().commit();
            return success;
        }
    }

    public void updateQuantityProduct(Product product , Long quantity) {
        em.getTransaction().begin();
        Product result = em.find(Product.class, product.getIdProduct());
        //result.setUserName(before.getUserName()); // no settext
        result.setQuantityProduct(quantity);
        em.getTransaction().commit();
    }
}
