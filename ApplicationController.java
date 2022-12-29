package com.capgemini.admission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.admission.dto.ApplicationDTO;
import com.capgemini.admission.service.IApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	@Autowired
	private IApplicationService applicationService;
	@PostMapping
	public ResponseEntity<ApplicationDTO>addApplicaton(@RequestBody ApplicationDTO applicationDTO){
		ApplicationDTO application=applicationService.saveApplication(applicationDTO);
		return ResponseEntity.ok(application);
	}
	@GetMapping("/{applicationId}")
	public ResponseEntity<ApplicationDTO>getApplicationById(@PathVariable int applicationId){
		ApplicationDTO applicationDTO=applicationService.getApplicationById(applicationId);
		return new ResponseEntity<ApplicationDTO>(applicationDTO,HttpStatus.FOUND);
	}
	@PutMapping
	public ResponseEntity<ApplicationDTO>updateApplication(@RequestBody ApplicationDTO applicationDTO){
		ApplicationDTO application=applicationService.updateApplicationStatus(applicationDTO);
		return ResponseEntity.ok(application);
	}
	@DeleteMapping
	public ResponseEntity<ApplicationDTO>deleteApplication(@PathVariable int applicationId){
		ApplicationDTO application=applicationService.getApplicationById(applicationId);
		return new ResponseEntity<ApplicationDTO>(application,HttpStatus.ACCEPTED);
	}
	@GetMapping
	public ResponseEntity<List<ApplicationDTO>>getAllApplications()
	{
		List<ApplicationDTO> list = applicationService.viewAllApplicationDetails();
		return ResponseEntity.ok(list);
	}
	
}
