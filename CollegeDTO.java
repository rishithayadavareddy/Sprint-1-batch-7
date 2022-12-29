package com.capgemini.admission.dto;

import java.util.ArrayList;
import java.util.List;

public class CollegeDTO {

	private int collegeRegId;
	private String collegeName;

	List<BranchDTO> branchList = new ArrayList<BranchDTO>();
	List<CourseDTO> courseList = new ArrayList<CourseDTO>();
	private int universityId;

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public int getCollegeRegId() {
		return collegeRegId;
	}

	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public List<BranchDTO> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<BranchDTO> branchList) {
		this.branchList = branchList;
	}

	public List<CourseDTO> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<CourseDTO> courseList) {
		this.courseList = courseList;
	}

}
