package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.BranchDTO;
import com.capgemini.admission.entity.Branch;
import com.capgemini.admission.entity.College;
import com.capgemini.admission.entity.Course;
import com.capgemini.admission.exception.BranchNotFoundException;
import com.capgemini.admission.repository.BranchRepository;
import com.capgemini.admission.repository.CollegeRepository;
import com.capgemini.admission.repository.CourseRepository;
import com.capgemini.admission.service.IBranchService;
@Service
public class IBranchServiceImpl implements IBranchService {
	@Autowired
	private BranchRepository branchRepository;
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public BranchDTO addBranch(BranchDTO branchDTO) {
		// TODO Auto-generated method stub
		int collegeRegId = branchDTO.getCollegeRegId();
		int courseId = branchDTO.getCourseId();
		College college = collegeRepository.findById(collegeRegId).get();
		Course course = courseRepository.findById(courseId).get();

		if (college != null || course != null) {
			Branch branch = new Branch();
			BeanUtils.copyProperties(branchDTO, branch);
			branch.setCollege(college);
			branch.setCourse(course);
			branch.setBranchName(branchDTO.getBranchName());

			branchRepository.save(branch);
		}
		return branchDTO;
	}
	@Override
	public BranchDTO updateBranch(BranchDTO branchDTO) {
		// TODO Auto-generated method stub
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDTO, branch);
		branchRepository.save(branch);
		return branchDTO;
	}
	@Override
	public BranchDTO deleteBranch(BranchDTO branchDTO) {
		// TODO Auto-generated method stub
		Branch branch = new Branch();
		BeanUtils.copyProperties(branchDTO, branch);
		branchRepository.delete(branch);
		return branchDTO;
	}
	@Override
	public List<BranchDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<Branch> list = branchRepository.findAll();
		List<BranchDTO> dtos = new ArrayList<>();
		for (Branch branch : list) {
			BranchDTO dto = new BranchDTO();
			BeanUtils.copyProperties(branch, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public BranchDTO getByBranchId(int branchId) {
		// TODO Auto-generated method stub

		Optional<Branch> branch = branchRepository.findById(branchId);
		if (branch.isPresent()) {
			BranchDTO dto = new BranchDTO();
			BeanUtils.copyProperties(branch.get(), dto);
			return dto;
		}
		throw new BranchNotFoundException("Branch with id" + branchId + "doesn't exist");
	}

}
