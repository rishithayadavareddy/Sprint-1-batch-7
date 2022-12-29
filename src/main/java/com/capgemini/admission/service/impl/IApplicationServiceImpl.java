package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.ApplicationDTO;
import com.capgemini.admission.entity.Application;
import com.capgemini.admission.entity.Payment;
import com.capgemini.admission.repository.ApplicationRepository;
import com.capgemini.admission.repository.PaymentRepository;
import com.capgemini.admission.service.IApplicationService;

@Service
public class IApplicationServiceImpl implements IApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public ApplicationDTO saveApplication(ApplicationDTO applicationDTO) {
		// TODO Auto-generated method stub
		int paymentId = applicationDTO.getPaymentId();
		Payment payment = paymentRepository.findById(paymentId).get();
		if (payment != null) {
			Application application = new Application();
			BeanUtils.copyProperties(applicationDTO, application);
			application.setPayment(payment);
			application.setApplicantFullName(applicationDTO.getApplicantFullName());
			application.setApplicationStatus(applicationDTO.getApplicationStatus());
			application.setDateOfBirth(applicationDTO.getDateOfBirth());
			application.setEmailId(applicationDTO.getEmailId());
			application.setFinalYearPercentage(applicationDTO.getFinalYearPercentage());
			application.setHighestQualification(applicationDTO.getHighestQualification());

			applicationRepository.save(application);

		}
		return applicationDTO;

	}

	@Override
	public ApplicationDTO updateApplicationStatus(ApplicationDTO applicationDTO) {
		// TODO Auto-generated method stub
		Application application = new Application();
		BeanUtils.copyProperties(applicationDTO, application);
		applicationRepository.save(application);
		return applicationDTO;

	}

	@Override
	public boolean deleteApplication(ApplicationDTO applicationDTO) {
		// TODO Auto-generated method stub
		Application application = new Application();
		BeanUtils.copyProperties(applicationDTO, application);
		applicationRepository.delete(application);

		return true;
	}

	@Override
	public ApplicationDTO getApplicationById(int applicationId) {
		// TODO Auto-generated method stub
		Optional<Application> application = applicationRepository.findById(applicationId);
		if (application.isPresent()) {
			ApplicationDTO dto = new ApplicationDTO();
			BeanUtils.copyProperties(application.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<ApplicationDTO> viewAllApplicationDetails() {
		// TODO Auto-generated method stub
		Iterable<Application> list = applicationRepository.findAll();
		List<ApplicationDTO> dtos = new ArrayList<>();
		for (Application app : list) {
			ApplicationDTO dto = new ApplicationDTO();
			BeanUtils.copyProperties(app, dto);
			dtos.add(dto);

		}
		return dtos;
	}
/*
	@Override
	public Boolean getByEmail(String emailId) {
		// TODO Auto-generated method stub
		if (applicationRepository.findByEmailId(emailId) != null) {
			return true;
		}
		return false;
	}*/


}
