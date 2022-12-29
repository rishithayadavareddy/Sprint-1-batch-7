package com.capgemini.admission.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.admission.dto.*;
import com.capgemini.admission.exception.*;
import com.capgemini.admission.service.IBranchService;
import com.capgemini.admission.service.ICollegeService;

@RestController
@RequestMapping("/api/branch")
public class BranchController {
	@Autowired
	private IBranchService branchService;
	@Autowired
	private ICollegeService collegeService;
	
	
	@PostMapping
	public ResponseEntity<BranchDTO> addBranch(@RequestBody BranchDTO branchDTO) {
		BranchDTO branch = branchService.addBranch(branchDTO);
		return ResponseEntity.ok(branch);

	}

	@GetMapping("/{branchId}")
	public ResponseEntity<BranchDTO> getBranchById(@PathVariable int branchId) {
		BranchDTO branchDTO = branchService.getByBranchId(branchId);
		return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.FOUND);
	}

	/*
	 * @PutMapping public ResponseEntity<BranchDTO> updateBranch(@RequestBody
	 * BranchDTO branchDTO) { BranchDTO branch =
	 * branchService.updateBranch(branchDTO); return ResponseEntity.ok(branch);
	 * 
	 * }
	 */
	@PutMapping("/{userId}")
	public ResponseEntity<BranchDTO> updateUser(@RequestBody BranchDTO dto) {
		return new ResponseEntity<BranchDTO>(branchService.addBranch(dto), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{branchId}")
	public ResponseEntity<BranchDTO> deleteCourseById(@PathVariable Integer branchId) {
		BranchDTO branchDTO = branchService.getByBranchId(branchId);
		if (branchDTO != null) {
			branchService.deleteBranch(branchDTO);
			return new ResponseEntity<BranchDTO>(branchDTO, HttpStatus.ACCEPTED);

		}
		throw new CollegeNotFoundException("Branch with id" + branchId+ "doesn't exist");
	}
	@GetMapping
	public ResponseEntity<List<BranchDTO>> getAllBranches() {
		List<BranchDTO> list = branchService.findAll();
		return ResponseEntity.ok(list);
	}
}
