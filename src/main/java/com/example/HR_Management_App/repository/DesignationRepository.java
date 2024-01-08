package com.example.HR_Management_App.repository;

import com.example.HR_Management_App.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
