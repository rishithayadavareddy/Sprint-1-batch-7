package com.capgemini.admission.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.dto.CourseDTO;
import com.capgemini.admission.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	
	//CourseDTO getCourseByCourseId(int courseId);

	//CourseDTO getCourseByClgRegId(int collegeRegId);
}
