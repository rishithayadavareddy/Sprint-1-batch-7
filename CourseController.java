package com.capgemini.admission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.admission.dto.CourseDTO;
import com.capgemini.admission.service.IBranchService;
import com.capgemini.admission.service.ICollegeService;
import com.capgemini.admission.service.ICourseService;

@RestController
@RequestMapping("/api/courses") // in order to provide specific url which is applicable to all methods of Course
								// Controller

public class CourseController {
	@Autowired
	private ICollegeService collegeService;
	@Autowired
	private ICourseService courseService;

	@PostMapping
	public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {

		courseService.saveCourse(courseDTO);
		return courseDTO;

	}

	// http://localhost:9091/api/courses/1
	@GetMapping("/{courseId}")
	public CourseDTO getCourseById(@PathVariable int courseId) {
		CourseDTO dto = courseService.getByCourseId(courseId);
		return dto;
	}

	// http://localhost:9091/api/courses
	@GetMapping
	public List<CourseDTO> getAllCourses() {
		List<CourseDTO> list = courseService.findAll();
		return list;
	}

	// http://localhost:9091/api/courses/1
	@DeleteMapping("/{courseId}")
	public boolean deleteCourse(@PathVariable int courseId) {
		CourseDTO dto = courseService.getByCourseId(courseId);
		return courseService.deleteCourse(dto);

	}

	// http://localhost:9091/api/courses
	@PutMapping
	public CourseDTO updateCourses(@RequestBody CourseDTO dto) {
		courseService.updateCourse(dto);
		return dto;
	}

}
