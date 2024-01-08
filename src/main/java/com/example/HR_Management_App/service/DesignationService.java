package com.example.HR_Management_App.service;

import com.example.HR_Management_App.controller.request.DesignationRequest;
import com.example.HR_Management_App.controller.response.DesignationResponse;
import com.example.HR_Management_App.controller.response.MessageResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DesignationService {

    DesignationResponse add (Long id ,DesignationRequest request);

    List<DesignationResponse> allDesignations ();

    MessageResponse delete (Long id);

    DesignationResponse update (Long id, DesignationRequest designationRequest);
}
