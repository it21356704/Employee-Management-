package com.example.HR_Management_App.controller;

import com.example.HR_Management_App.controller.request.EmployeeRequest;
import com.example.HR_Management_App.controller.response.EmployeeResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import com.example.HR_Management_App.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    @PostMapping("/employees")
    public EmployeeResponse addEmployee(@RequestBody EmployeeRequest request){

        return employeeService.add(request);
    }

    @GetMapping("/employees")
    public List<EmployeeResponse> getAllEmployee(){

        return employeeService.allEmployees();

    }

    @PutMapping("/employees/{employee-id}")
    public EmployeeResponse updateEmployee(@PathVariable("employee-id")Long id,
                                           @RequestBody EmployeeRequest employeeRequest){

        return employeeService.update(id, employeeRequest);

    }

    @DeleteMapping("/employees/{employee-id}")
    public MessageResponse deleteEmployee(@PathVariable("employee-id")Long id){

        return employeeService.delete(id);
    }

    @GetMapping("/employees/{employee-id}")
    public EmployeeResponse specificEmployeeDetails(@PathVariable("employee-id")Long id){
        return employeeService.specificEmployeeDetails(id);
    }


}
