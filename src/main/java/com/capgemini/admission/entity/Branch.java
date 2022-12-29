package com.capgemini.admission.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch implements Serializable {
	@Id
	@GeneratedValue
	private int branchId;
	private String branchName;
	private String branchDescription;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private Course course;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "collegeReg_id")
	private College college;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(String branchName, String branchDescription) {
		super();

		this.branchName = branchName;
		this.branchDescription = branchDescription;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDescription() {
		return branchDescription;
	}

	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + ", course=" + course + ", college=" + college + "]";
	}

}
