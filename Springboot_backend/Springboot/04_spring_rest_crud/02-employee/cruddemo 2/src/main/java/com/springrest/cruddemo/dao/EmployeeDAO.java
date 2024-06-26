package com.springrest.cruddemo.dao;

import com.springrest.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deletedById(int theId);

}
