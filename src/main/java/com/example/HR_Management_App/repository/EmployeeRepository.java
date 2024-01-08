package com.example.HR_Management_App.repository;

import com.example.HR_Management_App.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
