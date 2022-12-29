package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.entity.Branch;
import com.capgemini.admission.entity.College;
import com.capgemini.admission.entity.University;
import com.capgemini.admission.repository.CollegeRepository;
import com.capgemini.admission.repository.UniversityRepository;
import com.capgemini.admission.service.ICollegeService;

@Service
public class ICollegeServiceImpl implements ICollegeService {
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public CollegeDTO addCollege(CollegeDTO collegeDTO) {
		// TODO Auto-generated method stub
		int universityId = collegeDTO.getUniversityId();
		University university = universityRepository.findById(universityId).get();
		if (university != null) {

			College college = new College();
			BeanUtils.copyProperties(collegeDTO, college);
			college.setUniversity(university);
			college.setCollegeName(collegeDTO.getCollegeName());
			collegeRepository.save(college);
		}
		return collegeDTO;

	}

	@Override
	public CollegeDTO updateColleges(CollegeDTO collegeDTO) {
		// TODO Auto-generated method stub
		College college = new College();
		BeanUtils.copyProperties(collegeDTO, college);
		collegeRepository.save(college);
		return collegeDTO;

	}

	@Override
	public CollegeDTO getByClgId(Integer collegeRegId) {
		// TODO Auto-generated method stub
		Optional<College> college = collegeRepository.findById(collegeRegId);
		CollegeDTO dto = new CollegeDTO();
		BeanUtils.copyProperties(college.get(), dto);
		return dto;

	}

	@Override
	public List<CollegeDTO> findAll() {
		List<College> colleges = (List<College>) collegeRepository.findAll();
		List<CollegeDTO> dtos = new ArrayList<>();
		for (College college : colleges) {
			CollegeDTO dto = new CollegeDTO();
			BeanUtils.copyProperties(college, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	@Override
	public CollegeDTO deleteCollege(CollegeDTO collegeDTO) {
		// TODO Auto-generated method stub
		College college = new College();
		BeanUtils.copyProperties(collegeDTO, college);
		collegeRepository.delete(college);
		return collegeDTO;

	}

	/*@Override
	public List<College> getCollegesByUniversityId(int universityId) {
		// TODO Auto-generated method stub
		//String collegeName = collegeDTO.getCollegeName();
	return collegeRepository.FindCollegesByUniversityId(universityId);
		
	}*/

	

	 

		
}
