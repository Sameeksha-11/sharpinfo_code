package com.springrest.cruddemo.dao;

import com.springrest.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //That's it... no need to write any code
}
