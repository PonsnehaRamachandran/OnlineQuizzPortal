package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.exceptions.ResultException;
import com.example.demo.service.ResultService;

@CrossOrigin("*")
@RestController
public class ResultController {

	@Autowired
	private ResultService resultService;

	// getting all results
	@GetMapping(value = "/api/results")
	public ResponseEntity<List<Result>> getAll() throws ResultException {
		List<Result> results = resultService.getAllResult();
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	// getting all results of a student
	@GetMapping("/api/user/{userName}/results")
	public ResponseEntity<List<Result>> getAllResultsOfStudent(@PathVariable("userName") String userName)
			throws ResultException {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://localhost:8081/api/user/{userName}", User.class);
		List<Result> results = resultService.getResult(userName);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	// adding new result
	@PostMapping(value = "/api/results", consumes = { "application/json" })
	public ResponseEntity<?> postNewResult(@RequestBody Result result) throws ResultException {
		try {
		Result newResult = resultService.addNewResult(result);
		return new ResponseEntity<>(newResult, HttpStatus.CREATED);
		}
		catch (ResultException e) {
			ResultException ex = new ResultException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
