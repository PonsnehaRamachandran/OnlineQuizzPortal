package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Subject;
import com.example.demo.exceptions.SubjectException;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private SubjectServiceImpl subjectService;

	@GetMapping(value = "/api/subjects")
	public ResponseEntity<?> getAll() throws SubjectException {
		List<Subject> subjects = subjectRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(subjects);
	}

	@PostMapping(value = "/api/subject")
	public ResponseEntity<?> postNewSubject(@RequestBody Subject subject) throws SubjectException {
		try {
			Subject newSubject = subjectService.addSubject(subject);
			return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
		} catch (SubjectException e) {
			SubjectException ex = new SubjectException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/api/subject/{subjectId}")
	public ResponseEntity<?> deleteSubject(@PathVariable("subjectId") int subjectId) throws SubjectException {
		try {
			subjectService.deleteSubject(subjectId);
			return ResponseEntity.status(HttpStatus.OK).body("Subject removed");
		} catch (SubjectException e) {
			SubjectException ex = new SubjectException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
