package com.capgemini.admission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.entity.Application;
import com.capgemini.admission.entity.University;
@Repository
public interface UniversityRepository extends CrudRepository<University, Integer> {	
	UniversityDTO getByUniversityId(int universityId);
}
