package com.example.HR_Management_App.controller;

import com.example.HR_Management_App.controller.request.DesignationRequest;
import com.example.HR_Management_App.controller.response.DesignationResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import com.example.HR_Management_App.service.DesignationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class DesignationController {

    private DesignationService designationService;

    @PostMapping("/designation/{employee-id}")
    public DesignationResponse addDesignation(@PathVariable("employee-id")Long id,
                                               @RequestBody DesignationRequest designationRequest){

        return designationService.add(id,designationRequest);
    }

    @GetMapping("/designation")
    public List<DesignationResponse> getAll(){

        return designationService.allDesignations();

    }

    @DeleteMapping("/designation/{employee-id}")
    public MessageResponse deleteDesignation(@PathVariable("employee-id") Long id){

        return designationService.delete(id);
    }

    @PutMapping("/designation/{employee-id}")
    public DesignationResponse updateEmployee(@PathVariable("employee-id")Long id,
                                              @RequestBody DesignationRequest designationRequest){

        return  designationService.update(id, designationRequest);
    }
}
