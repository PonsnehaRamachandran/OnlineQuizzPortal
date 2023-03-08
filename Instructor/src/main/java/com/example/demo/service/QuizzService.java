package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Quizz;
import com.example.demo.exceptions.QuizzException;

@Service
public interface QuizzService {

	List<Quizz> getAllQuizz() throws QuizzException;
	Quizz getParticularQuiz(int quizz) throws QuizzException;
	Quizz addQuizz(Quizz quizz) throws QuizzException;
	Quizz deleteQuizz(int id) throws QuizzException;
	
}
