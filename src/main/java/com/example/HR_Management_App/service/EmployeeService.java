package com.example.HR_Management_App.service;

import com.example.HR_Management_App.controller.request.EmployeeRequest;
import com.example.HR_Management_App.controller.response.EmployeeResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeResponse add (EmployeeRequest request);
    List<EmployeeResponse> allEmployees ();
    EmployeeResponse update (Long id, EmployeeRequest employeeRequest);
    MessageResponse delete (Long id);
    EmployeeResponse specificEmployeeDetails (Long id);

}
