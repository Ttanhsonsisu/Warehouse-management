package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.model.entities.Employee;

import java.util.List;

public class EmployeeDAO implements DAOInterface<Employee> {
    private final EntityManager em;
    public EmployeeDAO(EntityManager em) {
        this.em = em;
    }
    @Override
    public int insert(Employee employee) {
        return 0;
    }

    @Override
    public int delete(Employee employee) {
        return 0;
    }

    @Override
    public List<Employee> selectAll() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        // select *
        criteriaQuery.select(root);

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public Employee selectById(Employee employee) {
        return null;
    }

    @Override
    public List<Employee> selectByCondition(String condition) {
        return null;
    }
}
