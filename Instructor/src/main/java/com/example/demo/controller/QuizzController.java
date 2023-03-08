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

import com.example.demo.entity.Quizz;
import com.example.demo.exceptions.QuizzException;
import com.example.demo.repository.QuizzRepository;
import com.example.demo.service.QuizzServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class QuizzController {

	@Autowired
	private QuizzRepository quizzRepository;
	@Autowired
	private QuizzServiceImpl quizzService;

	// getting all quizz
	@GetMapping(value = "/api/quizz")
	public ResponseEntity<List<Quizz>> getAll() throws QuizzException {
		List<Quizz> quizzes = quizzRepository.findAll();
		return new ResponseEntity<>(quizzes, HttpStatus.OK);
	}

	// getting details of particular quizz
	@GetMapping(value = "/api/quizz/{id}")
	public ResponseEntity<?> getQuestionForAQuizz(@PathVariable int id) throws QuizzException {
		try {
		Quizz quiz = quizzService.getParticularQuiz(id);
		return ResponseEntity.ok(quiz);
		}
		catch(QuizzException e)
		{
			QuizzException ex = new QuizzException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
	}

	// add a new quizz
	@PostMapping(value = "/api/quizz")
	public ResponseEntity<?> postNewQuizz(@RequestBody Quizz quizz) throws QuizzException {
		try {
		Quizz newQuizz = quizzService.addQuizz(quizz);
		return new ResponseEntity<>(newQuizz, HttpStatus.CREATED);
		}
		catch(QuizzException e)
		{
			QuizzException ex = new QuizzException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
		
	}

	//delete a quizz
	@DeleteMapping("/api/quizz/{id}")
	public ResponseEntity<?> deletePlayer(@PathVariable int id) throws QuizzException {
		try {
		quizzService.deleteQuizz(id);
		return ResponseEntity.status(HttpStatus.OK).body("Quizz removed");
		}
		catch(QuizzException e)
		{
			QuizzException ex = new QuizzException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		
		}
	}

}
