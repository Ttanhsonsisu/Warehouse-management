package org.example.DAO;

import com.sun.jna.platform.win32.Netapi32Util;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Product;
import org.example.model.entities.UserApp;

import java.util.List;

public class UserAppDAO {

    private final EntityManager  em;

    public UserAppDAO(EntityManager em) {
        this.em = em;
    }

    public List<UserApp> findAllUserApp() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserApp> cq = cb.createQuery(UserApp.class);
        Root<UserApp> root = cq.from(UserApp.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();
    }

    public List<Product> findAllProduct() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> root = cq.from(Product.class);
        cq.select(root);
        return em.createQuery(cq).getResultList();

    }
    public void insertLoginRegister(String userName, String email , String password) {
        em.persist(new UserApp(userName , email, password));
    }

    public UserApp findLoginRegister(String userName, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<UserApp> cq = cb.createQuery(UserApp.class);
        Root<UserApp> root = cq.from(UserApp.class);

        Predicate userNamePred = cb.like(root.get("userName"),  userName );
        Predicate passwordPred = cb.like(root.get("password"),  password );

        Predicate andUsernamePasswordPred = cb.and(userNamePred, passwordPred);
        //or
        //Predicate orPred = cb.or(userNamePred, passwordPred);
        //and
        cq.where(andUsernamePasswordPred);
        TypedQuery<UserApp> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    public Integer findUserAppId(String user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);

        Root<UserApp> root = cq.from(UserApp.class);
        Predicate userNamePred = cb.like(root.get("userName"),  user );
        cq.where(userNamePred);
        TypedQuery<Integer> query = em.createQuery(cq);


        return query.getSingleResult();
    }

    public List<Integer> findUserEmail(String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<UserApp> root = cq.from(UserApp.class);
        cq.select(root.get("idUser"));
        Predicate userNamePred = cb.like(root.get("email"),  email );
        cq.where(userNamePred);
        TypedQuery<Integer> query = em.createQuery(cq);


        return query.getResultList();
    }
}
