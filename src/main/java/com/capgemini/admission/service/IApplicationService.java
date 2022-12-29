package com.capgemini.admission.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.admission.dto.ApplicationDTO;
import com.capgemini.admission.entity.Application;

public interface IApplicationService {
	public ApplicationDTO saveApplication(ApplicationDTO applicationDTO);
	public ApplicationDTO updateApplicationStatus(ApplicationDTO applicationDTO);
	public boolean deleteApplication(ApplicationDTO applicationDTO);
	public ApplicationDTO getApplicationById(int applicationId);

	public List<ApplicationDTO> viewAllApplicationDetails();
	//public Boolean getByEmail(String emailId);

	

	




}
