package com.example.employee_crud.dao;

import com.example.employee_crud.entity.Employee;
import com.example.employee_crud.service.EmployeeService;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDAO {


    Employee findById(int id);

    Employee saveEmployee(Employee employee);

    void deleteById(int id);

    List<Employee> getAll();
}
