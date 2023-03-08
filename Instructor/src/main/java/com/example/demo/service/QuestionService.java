package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.exceptions.QuestionException;

@Service
public interface QuestionService {
	
	List<Question> getAllQuestion() throws QuestionException;
	List<Question> getQuestionsByQuizzId(int id) throws QuestionException;
	Question addQuestion(Question question) throws QuestionException;
	Question deleteQuestion(int id) throws QuestionException;
	Question updateQuestion(int questionId, Question question) throws QuestionException;
	
}
