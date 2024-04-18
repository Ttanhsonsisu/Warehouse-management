package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Client;


import java.util.List;

public class ClientDAO implements DAOInterface<Client> {

    private final EntityManager em;

    public ClientDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Client> selectAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Client> cq = cb.createQuery(Client.class);
        Root<Client> root = cq.from(Client.class);
        cq.select(root);
        TypedQuery<Client> query = em.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public int insert(Client client) {
        return 0;
    }

    @Override
    public int delete(Client client) {
        return 0;
    }

    @Override
    public Client selectById(Client client) {
        return null;
    }

    @Override
    public List<Client> selectByCondition(String condition) {
        return null;
    }
}
