package com.capgemini.admission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.ApplicationDTO;
import com.capgemini.admission.entity.Application;
@Repository
public interface ApplicationRepository extends CrudRepository<Application, Integer> {

	//Optional<Application> findByApplicationId(int applicationId);

	//Application findByEmailId(String emailId);
	

}
