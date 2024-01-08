package com.example.HR_Management_App.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeName;
    private String contactNumber;
    private String dob;
    private String gender;
    private String address;
    private String email;
    @OneToMany
    private List<Designation> designations;

}
