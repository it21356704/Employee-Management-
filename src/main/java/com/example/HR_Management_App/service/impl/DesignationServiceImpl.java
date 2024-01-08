package com.example.HR_Management_App.service.impl;

import com.example.HR_Management_App.controller.request.DesignationRequest;
import com.example.HR_Management_App.controller.response.DesignationResponse;
import com.example.HR_Management_App.controller.response.EmployeeResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import com.example.HR_Management_App.model.Designation;
import com.example.HR_Management_App.model.Employee;
import com.example.HR_Management_App.repository.DesignationRepository;
import com.example.HR_Management_App.repository.EmployeeRepository;
import com.example.HR_Management_App.service.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class DesignationServiceImpl implements DesignationService {

    private DesignationRepository designationRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public DesignationResponse add(Long id, DesignationRequest request) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){

            Employee employee = optionalEmployee.get();

            Designation designation = new Designation();
            designation.setDesignationId(request.getDesignationId());
            designation.setDepartment(request.getDepartment());
            designation.setJobTitle(request.getJobTitle());
            designation.setEmployee(employee);
            designationRepository.save(designation);

            DesignationResponse designationResponse = new DesignationResponse();
            designationResponse.setDepartment(designation.getDepartment());
            designationResponse.setJobTitle(designation.getJobTitle());

            return designationResponse;
        }

        return null;

    }

    @Override
    public List<DesignationResponse> allDesignations() {

        List<Designation> designations = designationRepository.findAll();
        List<DesignationResponse> designationResponseList = new ArrayList<>();

        for(Designation designation:designations){

            DesignationResponse designationResponse = new DesignationResponse();
            designationResponse.setDepartment(designation.getDepartment());
            designationResponse.setJobTitle(designation.getJobTitle());
            designationResponseList.add(designationResponse);
        }
        return designationResponseList;
    }

    @Override
    public MessageResponse delete(Long id) {

        designationRepository.deleteById(id);
        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("Successfully deleted id:"+id);

        return messageResponse;
    }

    @Override
    public DesignationResponse update(Long id, DesignationRequest designationRequest) {
        
        return null;
    }
}

