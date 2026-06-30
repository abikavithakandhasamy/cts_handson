package com.example.spring_data_jpa_handson.repository;

import com.example.spring_data_jpa_handson.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}