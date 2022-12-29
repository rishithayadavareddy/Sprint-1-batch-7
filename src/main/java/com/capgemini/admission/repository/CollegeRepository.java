package com.capgemini.admission.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.entity.College;
@Repository
public interface CollegeRepository extends CrudRepository<College, Integer> {
	/*@Query(
			value = 
			"select * from College where college_name in(select collegeName from University where universityId=:c)",nativeQuery=true)
	
			
	
			List<College> FindCollegesByUniversityId(@Param("universityId") Integer universityId );
	/*List<College>findCollegesByUniversityId(String collegeName,int universityId);
	 default List<College> shortName(String collegeName, int universityId) {
         return findCollegesByUniversityId(collegeName, universityId);
     }*/
			
			

}
