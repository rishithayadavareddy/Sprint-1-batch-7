package com.capgemini.admission.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course implements Serializable {
	@Id
	@GeneratedValue
	private int courseId;
	private String courseName;
	private String eligibity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "collegeReg_Id")
	private College college;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	private List<Branch> branches = new ArrayList<>();

	public Course() {
		super();

	}

	public Course(String courseName, String eligibity, College college, List<Branch> branches) {
		super();

		this.courseName = courseName;
		this.eligibity = eligibity;
		this.college = college;
		this.branches = branches;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEligibity() {
		return eligibity;
	}

	public void setEligibity(String eligibity) {
		this.eligibity = eligibity;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", eligibity=" + eligibity + ", college="
				+ college + ", branches=" + branches + "]";
	}

}
