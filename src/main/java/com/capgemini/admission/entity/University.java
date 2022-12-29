package com.capgemini.admission.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "universities")
public class University implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	@Id
	@GeneratedValue
	public int universityId;
	@OneToMany(mappedBy = "university")
	public List<College> collegeList = new ArrayList<College>();

	public University() {
		super();
		// TODO Auto-generated constructor stub
	}

	public University(String name, List<College> collegeList) {
		super();
		this.name = name;
		this.collegeList = collegeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public List<College> getCollegeList() {
		return collegeList;
	}

	public void setCollegeList(List<College> collegeList) {
		this.collegeList = collegeList;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", universityId=" + universityId + ", collegeList=" + collegeList + "]";
	}
	

}
