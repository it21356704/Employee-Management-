package com.example.HR_Management_App.controller.request;

import lombok.Data;

@Data
public class DesignationRequest {

    private Long designationId;
    private String department;
    private String jobTitle;
}
