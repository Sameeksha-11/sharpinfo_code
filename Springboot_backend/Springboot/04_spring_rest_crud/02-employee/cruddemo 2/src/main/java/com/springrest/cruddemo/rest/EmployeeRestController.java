package com.springrest.cruddemo.rest;

import com.springrest.cruddemo.dao.EmployeeDAO;
import com.springrest.cruddemo.entity.Employee;
import com.springrest.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //inject employee dao
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theemployeeDA)
    {
        employeeService = theemployeeDA;
    }

    //expose employee and return
    @RequestMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //add mapping for get /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee ==null)
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
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

        Employee employee = employeeService.save(theEmployee);

        return employee;
    }

    //add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee employee = employeeService.save(theEmployee);

        return employee;
    }

    //add mapping for DELETE /employees/{employeeId} - delete employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);

        //throw exception if null
        if(theEmployee == null)
        {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deletedById(employeeId);

        return "Deleted employee id - " + employeeId;
    }
}
