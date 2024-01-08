package com.example.HR_Management_App.controller.request;

import lombok.Data;

@Data
public class EmployeeRequest {

    private Long employeeId;
    private String employeeName;
    private String contactNumber;
    private String dob;
    private String gender;
    private String address;
    private String email;

}
