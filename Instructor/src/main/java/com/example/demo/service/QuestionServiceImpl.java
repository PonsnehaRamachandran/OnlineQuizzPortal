package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.exceptions.QuestionException;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	// to show all questions from db
	public List<Question> getAllQuestion() throws QuestionException {
		List<Question> questions = questionRepository.findAll();
		if (questions.size() > 0) {
			return questions;
		} 
		else {
			throw new QuestionException("No Question exists..");
		}
	}
	
	// getting all questions of a particular quizz
		@Override
		public List<Question> getQuestionsByQuizzId(int id) {
			return questionRepository.findByquizzId(id);
		}

	// adding new question
	public Question addQuestion(Question question) throws QuestionException{
		if (question.getQuestionTitle().isEmpty() || question.getQuestion().isEmpty() || question.getOptionOne().isEmpty()
				|| question.getOptionTwo().isEmpty() || question.getOptionThree().isEmpty() || question.getOptionFour().isEmpty() 
				||question.getAnswer().isEmpty()|| question.getLevelOfDifficulty().isEmpty() || question.getMark().isEmpty()){
			throw new QuestionException("input field is empty");
		}

		return questionRepository.save(question);
	}

	// delete a question in a particular quizz
	public Question deleteQuestion(int id) throws QuestionException {
		Optional<Question> question = questionRepository.findById(id);
		if (question.isPresent()) {
			Question questions = question.get();
			questionRepository.delete(questions);
			return questions;
		} 
		else {
			throw new QuestionException("No Question found with ID : " + id);
		}
	}

	@Override
	public Question updateQuestion(int questionId, Question question) throws QuestionException {
		Question newQuestion = questionRepository.findById(questionId).get();
		newQuestion.setAnswer(question.getAnswer());
		newQuestion.setLevelOfDifficulty(question.getLevelOfDifficulty());
		newQuestion.setMark(question.getMark());
		newQuestion.setOptionFour(question.getOptionFour());
		newQuestion.setOptionOne(question.getOptionOne());
		newQuestion.setOptionThree(question.getOptionThree());
		newQuestion.setOptionTwo(question.getOptionTwo());
		newQuestion.setQuestion(question.getQuestion());

		return questionRepository.save(newQuestion);

	}

}
