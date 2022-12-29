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

import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.exception.UniversityNotFoundException;
import com.capgemini.admission.service.IUniversityService;
@RestController
@RequestMapping("/api/university")
public class UniversityController {
	@Autowired
	private IUniversityService universityService;

	@PostMapping
	public ResponseEntity<UniversityDTO> addUniversity(@RequestBody UniversityDTO universityDTO) {
		UniversityDTO university = universityService.saveUniversity(universityDTO);
		return ResponseEntity.ok(university);

	}

	@GetMapping("/{universityId}")
	public ResponseEntity<UniversityDTO> getByUniversityId(@PathVariable int universityId) {
		UniversityDTO university = universityService.getByUniversityId(universityId);
		return new ResponseEntity<UniversityDTO>(university, HttpStatus.FOUND);

	}

	@PutMapping("/{universityId}")
	public ResponseEntity<UniversityDTO> updateUniversity(@RequestBody UniversityDTO universityDTO) {
		UniversityDTO university = universityService.updateUniversity(universityDTO);
		return new ResponseEntity<UniversityDTO>(university, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/{universityId}")
	public ResponseEntity<Boolean> deleteByUniversityId(@PathVariable Integer universityId) {
		UniversityDTO universityDTO = universityService.getByUniversityId(universityId);
		if(universityDTO!=null) {
			universityService.deleteUniversity(universityDTO);
			return new ResponseEntity<Boolean>(HttpStatus.ACCEPTED);
		}
		throw new UniversityNotFoundException("University with id"+universityId+"doesn't exist");
		
	}

	@GetMapping
	public ResponseEntity<List<UniversityDTO>> getAllUniversities() {
		List<UniversityDTO> list = universityService.findAll();
		return ResponseEntity.ok(list);
	}
}
