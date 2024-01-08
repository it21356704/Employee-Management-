package com.example.HR_Management_App.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designationId;
    private String department;
    private String jobTitle;
    @ManyToOne
    private Employee employee;
}
