package com.springrest.cruddemo.dao;

import com.springrest.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{

    //Define field for entity manger
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        //excute query
        List<Employee> employees = theQuery.getResultList();

        //return result
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        //Get Employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //Return Employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //Save or update the employee
        //merge either saves or updates the employee based of id (id==0 save or update)
        Employee dbEmployee = entityManager.merge(theEmployee);

        return dbEmployee;
    }

    @Override
    public void deletedById(int theId) {
        //find the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //delete object with primary key
        entityManager.remove(theEmployee);

    }
}
