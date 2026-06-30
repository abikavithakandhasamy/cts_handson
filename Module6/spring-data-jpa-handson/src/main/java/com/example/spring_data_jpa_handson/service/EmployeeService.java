package com.example.spring_data_jpa_handson.service;

import com.example.spring_data_jpa_handson.entity.Employee;
import com.example.spring_data_jpa_handson.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}