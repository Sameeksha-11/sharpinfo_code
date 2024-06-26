package com.springrest.cruddemo.service;

import com.springrest.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //Same methods as DAO layer
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deletedById(int theId);

}
