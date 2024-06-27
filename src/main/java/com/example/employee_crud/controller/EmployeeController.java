package com.example.employee_crud.controller;


import com.example.employee_crud.entity.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;


    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee Id not Found - "+ employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees/employeeId")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        theEmployee.setId(0);
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);
        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employess/employeeId")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if(tempEmployee==null){
            throw  new RuntimeException("Employee id not found -  "+ employeeId);

        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }


}
