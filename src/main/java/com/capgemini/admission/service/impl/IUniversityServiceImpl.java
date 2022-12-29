package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.entity.Branch;
import com.capgemini.admission.entity.University;
import com.capgemini.admission.repository.UniversityRepository;
import com.capgemini.admission.service.IUniversityService;

@Service
public class IUniversityServiceImpl implements IUniversityService {
	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
		// TODO Auto-generated method stub
		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.save(university);
		return universityDTO;
	}

	@Override
	public UniversityDTO updateUniversity(UniversityDTO universityDTO) {
		// TODO Auto-generated method stub
		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.save(university);
		return universityDTO;

	}


	/*@Override
	public UniversityDTO getByUniversityId1(int universityId) {
		// TODO Auto-generated method stub
		Optional<University> university = universityRepository.findById(universityId);
		if (university.isPresent()) {
			// convert the entityto DTO
			UniversityDTO dto = new UniversityDTO();
			BeanUtils.copyProperties(university.get(), dto);
			return dto;
		}
		return null;
	}*/

	@Override
	public List<UniversityDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<University> list = universityRepository.findAll();
		List<UniversityDTO> dtos = new ArrayList<>();
		for (University uni : list) {
			UniversityDTO dto = new UniversityDTO();
			BeanUtils.copyProperties(uni, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UniversityDTO deleteUniversity(UniversityDTO universityDTO) {
		// TODO Auto-generated method stub
		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.delete(university);
		return universityDTO;
	}

	@Override
	public UniversityDTO getByUniversityId(int universityId) {
		// TODO Auto-generated method stub
		Optional<University> university = universityRepository.findById(universityId);
		if (university.isPresent()) {
			// convert the entity to DTO
			UniversityDTO dto = new UniversityDTO();
			BeanUtils.copyProperties(university.get(), dto);
			return dto;
		}
		return null;
	
	}

	

}
