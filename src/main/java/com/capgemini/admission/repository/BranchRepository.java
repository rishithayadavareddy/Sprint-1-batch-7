package com.capgemini.admission.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.BranchDTO;
import com.capgemini.admission.entity.Branch;
import com.capgemini.admission.entity.Course;
@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer>{

	//Optional<Branch> findById(Integer branchId);

}
