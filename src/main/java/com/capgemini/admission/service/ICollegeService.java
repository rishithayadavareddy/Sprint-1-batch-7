package com.capgemini.admission.service;

import java.util.List;

import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.entity.College;

public interface ICollegeService {
	public CollegeDTO addCollege(CollegeDTO collegeDTO);

	public CollegeDTO updateColleges(CollegeDTO collegeDTO);

	public  CollegeDTO deleteCollege(CollegeDTO collegeDTO);

	public CollegeDTO getByClgId(Integer collegeRegId);

	public List<CollegeDTO> findAll();
	//public List<College> getCollegesByUniversityId(int university_id);

}
