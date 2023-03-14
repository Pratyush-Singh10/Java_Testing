package com.example.au_demo_live.service;

import com.example.au_demo_live.Employee;
import com.example.au_demo_live.exception.EmployeeNotFound;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return null;
    }

    public Employee getEmployee(String id) throws Exception {
        return employees.
                stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElseThrow(EmployeeNotFound::new);
    }
}
