package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import org.example.model.entities.Product;
import org.example.model.entities.UserApp;
import org.example.persistence.CustomPersistenceUnitInfo;


import org.example.service.ServiceProduct;
import org.example.service.ServiceUserApp;
import org.example.view.dashboart.application.Application;

import org.hibernate.jpa.HibernatePersistenceProvider;


import java.util.HashMap;


import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


// if turn off frame -> set dispose for frame

        String puName = "my-persistence-unit";

        Map<String, String> props = new HashMap<>();

        props.put("hibernate.show_sql" , "true");
        props.put("hibernate.hbm2ddl.auto", "none");

        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(
                new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();
        System.out.println(em);

       //MainLoginRegister a = new MainLoginRegister(em);
     //a.setVisible(true);
        // check service
        //Application testApp = new Application(em);
        Application.initForm(em);

        ServiceUserApp findAll = new ServiceUserApp(em);
        List<UserApp> r =findAll.listUserApp();
        for (UserApp u : r) {
            System.out.println(u.toString());
        }
ServiceProduct serviceProduct = new ServiceProduct(em);
        //serviceProduct.updateQuantityProduct(em.find(Product.class, 302),100);
//        ServiceUserApp app = new ServiceUserApp(em);
//        boolean check = app.checkDuplicateEmail("tesr324");
//        System.out.print(check);
//       try {
//          em.getTransaction().begin();
//             //test email
//           UserAppDAO testEmail = new UserAppDAO(em);
//           System.out.println(testEmail.findUserEmail("tesrsdf").size());


           //
//
//          // test query login
//           UserAppDAO testLogin = new UserAppDAO(em);
//           System.out.print(testLogin.findLoginRegister("123","1244").getIdUser());


//            List<Product> test = new UserAppDAO(em).findAllProduct();
           //UserApp userApp = new UserApp("tesr", "teset123", "dfsees");
           //em.getTransaction().begin();
           //em.persist(userApp);
           //em.getTransaction().commit();

//            // no para
////            String jpql = "SELECT u FROM UserApp u";
////            TypedQuery<UserApp> query = em.createQuery(jpql, UserApp.class);
////            query.getResultList().forEach(System.out::println);
//
//            // para
//            String jpql2 = "SELECT u FROM UserApp u WHERE u.email = :email";
//
//            TypedQuery<UserApp> query = em.createQuery(jpql2, UserApp.class);
//            query.setParameter("email", "%com%");
//
//            String jpql3 = "Insert into UserApp (email, name) values (:email, :name)";
//            query.setParameter("email", "%com%");
//            query.executeUpdate();

//
//            em.getTransaction().commit();
//       } finally {
//            em.close();
//        }

    }
}