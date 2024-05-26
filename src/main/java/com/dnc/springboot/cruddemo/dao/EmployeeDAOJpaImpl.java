package com.dnc.springboot.cruddemo.dao;

import com.dnc.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl (EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

//      create a qury
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
//      execute the query
        List<Employee> employees = theQuery.getResultList();
//      return the result
        return employees;
    }
}
