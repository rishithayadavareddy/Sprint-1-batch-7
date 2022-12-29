package com.capgemini.admission.service;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.admission.dto.CourseDTO;
import com.capgemini.admission.entity.Branch;
import com.capgemini.admission.entity.Course;

public interface ICourseService {
	public CourseDTO saveCourse(CourseDTO courseDTO);
	public CourseDTO updateCourse(CourseDTO courseDTO);
	public boolean deleteCourse(CourseDTO courseDTO);
	public CourseDTO getByCourseId(int courseId);
	public List<CourseDTO>findAll();
	//public Boolean getByCourseName(String name);
	
	
}
