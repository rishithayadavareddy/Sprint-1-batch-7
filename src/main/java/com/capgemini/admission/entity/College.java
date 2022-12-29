package com.capgemini.admission.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "colleges")
public class College implements Serializable {
	@Id
	@GeneratedValue
	private int collegeRegId;
	private String collegeName;

	@ElementCollection(targetClass = Integer.class)
	@OneToMany(mappedBy = "college")

	List<Course> courseList = new ArrayList<>();
	@OneToMany(mappedBy = "college")
	List<Branch> branchList = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "university_Id")
	private University university;

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int collegeRegId, String collegeName, List<Course> courseList, List<Branch> branchList,
			University university) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;

		this.courseList = courseList;
		this.branchList = branchList;
		this.university = university;
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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", courseList=" + courseList
				+ ", branchList=" + branchList + ", university=" + university + "]";
	}

}
