package com.example.employee_crud.service;

import com.example.employee_crud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    Employee saveEmployee(Employee employee);

    void deleteById(int id);

    List<Employee> getAll();
}
