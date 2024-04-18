package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.dao.ClientDAO;
import org.example.dao.EmployeeDAO;
import org.example.dao.ProductDAO;
import org.example.dao.SupplierDAO;
import org.example.model.entities.Employee;
import org.example.model.entities.Product;
import org.example.model.entities.WareHouse;
import org.example.persistence.CustomPersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String puName = "my-persistence-unit";

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql" , "true");
        props.put("hibernate.hbm2ddl.auto", "");

        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
                CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
                CriteriaQuery<WareHouse> criteriaQuery = criteriaBuilder.createQuery(WareHouse.class);
                Root<WareHouse> root = criteriaQuery.from(WareHouse.class);
                criteriaQuery.select(root);
                TypedQuery<WareHouse> query = em.createQuery(criteriaQuery);
                query.getResultList().forEach(System.out::println);

            List<Employee> e = new EmployeeDAO(em).selectAll();
            e.forEach(System.out::println);
            // test client
            new ClientDAO(em).selectAll().forEach(System.out::println);
            // test product
            new ProductDAO(em).selectAll().forEach(System.out::println);
           // test
            new SupplierDAO(em).selectAll().forEach(System.out::println);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}