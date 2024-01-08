package com.example.HR_Management_App.service.impl;

import com.example.HR_Management_App.controller.request.EmployeeRequest;
import com.example.HR_Management_App.controller.response.EmployeeResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import com.example.HR_Management_App.model.Employee;
import com.example.HR_Management_App.repository.EmployeeRepository;
import com.example.HR_Management_App.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public EmployeeResponse add(EmployeeRequest request) {

        Employee employee = new Employee();
        employee.setEmployeeId(request.getEmployeeId());
        employee.setEmployeeName(request.getEmployeeName());
        employee.setDob(request.getDob());
        employee.setEmail(request.getEmail());
        employee.setAddress(request.getAddress());
        employee.setGender(request.getGender());
        employee.setContactNumber(request.getContactNumber());
        repository.save(employee);

        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setEmployeeName(employee.getEmployeeName());
        employeeResponse.setContactNumber(employee.getContactNumber());
        employeeResponse.setEmail(employee.getEmail());

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> allEmployees() {
        List<Employee> AllEmployees = repository.findAll();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for (Employee employee:AllEmployees){
            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setEmployeeName(employee.getEmployeeName());
            employeeResponse.setContactNumber(employee.getContactNumber());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponseList.add(employeeResponse);
        }
        return employeeResponseList;
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if(optionalEmployee.isPresent()){

            Employee employee = optionalEmployee.get();
            employee.setEmployeeName(employeeRequest.getEmployeeName());
            employee.setDob(employeeRequest.getDob());
            employee.setEmail(employeeRequest.getEmail());
            employee.setAddress(employeeRequest.getAddress());
            employee.setGender(employeeRequest.getGender());
            employee.setContactNumber(employeeRequest.getContactNumber());

            Employee updateEmployee = repository.save(employee);

            EmployeeResponse employeeResponse = new EmployeeResponse();
            employeeResponse.setEmployeeName(employee.getEmployeeName());
            employeeResponse.setEmail(updateEmployee.getEmail());
            employeeResponse.setContactNumber(updateEmployee.getContactNumber());
            return employeeResponse;

        }
        return null;
    }

    @Override
    public MessageResponse delete(Long id) {
        repository.deleteById(id);
        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setMessage("Successfully deleted id:"+id);

        return messageResponse;

    }

    @Override
    public EmployeeResponse specificEmployeeDetails(Long id) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        EmployeeResponse employeeResponse = new EmployeeResponse();

        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employeeResponse.setEmployeeName(employee.getEmployeeName());
            employeeResponse.setEmail(employee.getEmail());
            employeeResponse.setContactNumber(employee.getContactNumber());
        }

        return null;
    }
}
