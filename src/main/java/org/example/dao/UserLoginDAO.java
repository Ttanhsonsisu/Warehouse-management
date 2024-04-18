package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.abstractEntity.UserAbstract;


public class UserLoginDAO {

    private final EntityManager em;

    public UserLoginDAO(EntityManager em) {
        this.em = em;
    }

    public  UserAbstract findUserLogin(
            String username,
            String password
    ) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserAbstract> criteriaQuery = criteriaBuilder.createQuery(UserAbstract.class);

        // select * user
        Root<UserAbstract> root = criteriaQuery.from(UserAbstract.class);

        // where
        Predicate userNamePredicate = criteriaBuilder.
                like(root.get("username") , username);

        Predicate passwordPredicate = criteriaBuilder.
                like(root.get("password") , password);
        // and 2 cái name với password
        Predicate userAndPassword = criteriaBuilder.and(
                userNamePredicate,
                passwordPredicate
        );

        criteriaQuery.where(userAndPassword);

        TypedQuery<UserAbstract> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
