package com.springrest.cruddemo.rest;

import com.springrest.cruddemo.dao.EmployeeRepository;
import com.springrest.cruddemo.entity.Employee;
import com.springrest.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //inject employee dao
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeRestController(EmployeeRepository theemployeeDA)
    {
        employeeRepository = theemployeeDA;
    }

    //expose employee and return
    @RequestMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    //add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
       Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee theEmployee = null;
        if(!result.isPresent())
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }else {
            theEmployee = result.get();
        }
       return theEmployee;

    }

        //add Mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee)
    {
        //also just in case the pass an id in JSON ... set id to 0
        //this is to force a save of new item ... instead of update
        theEmployee.setId(0);

        Employee employee = employeeRepository.save(theEmployee);

        return employee;
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee employee = employeeRepository.save(theEmployee);

        return employee;
    }

    //add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Optional<Employee> result = employeeRepository.findById(employeeId);
        Employee theEmployee = null;
        //throw exception if null
        if(!result.isPresent())
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }else {
            theEmployee = result.get();
        }

        employeeRepository.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
