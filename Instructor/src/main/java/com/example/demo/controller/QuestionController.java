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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.exceptions.QuestionException;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionServiceImpl;

@CrossOrigin(origins = "*")
@RestController
public class QuestionController {

	@Autowired
	private QuestionServiceImpl questionService;
	@Autowired
	private QuestionRepository questionRepository;

	// getting questions from the db
	@GetMapping(value = "/api/questions")
	public ResponseEntity<List<Question>> getAll() throws QuestionException {
		List<Question> questions = questionRepository.findAll();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	// getting questions frm quizz using quizzId
	@GetMapping(value = "/api/quizz/{id}/questions")
	public ResponseEntity<List<Question>> getAllQuestionsForQuizz(@PathVariable int id) {
		List<Question> questions = questionService.getQuestionsByQuizzId(id);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	// adding new question to db basedonquizz
	@PostMapping(value = "/api/questions")
	public ResponseEntity<?> postNewQuestion(@RequestBody Question question) throws QuestionException {
		try {
			Question newQuestion = questionService.addQuestion(question);
			return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
		} catch (QuestionException e) {
			QuestionException ex = new QuestionException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	// deleting questionsbyId
	@DeleteMapping("/questions/{questionId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable("questionId") int questionId) throws QuestionException {
		try {
			questionService.deleteQuestion(questionId);
			return ResponseEntity.status(HttpStatus.OK).body("Question deleted");
		} catch (QuestionException e) {
			QuestionException ex = new QuestionException(e.getMessage());
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	// Edit a question
	@PutMapping(value = "api/questions/{questionId}")
	public ResponseEntity<?> editQuestion(@PathVariable int questionId, @RequestBody Question question)
			throws QuestionException {
		Question updateQuestion = questionService.updateQuestion(questionId, question);
		return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
	}

}
