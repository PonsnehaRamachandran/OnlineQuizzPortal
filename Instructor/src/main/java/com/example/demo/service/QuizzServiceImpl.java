package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Quizz;
import com.example.demo.exceptions.QuizzException;
import com.example.demo.repository.QuizzRepository;

@Service
public class QuizzServiceImpl implements QuizzService {

	@Autowired
	private QuizzRepository quizzRepository;

	@Override
	public List<Quizz> getAllQuizz() throws QuizzException {
		List<Quizz> quizzes = quizzRepository.findAll();
		if (quizzes.size() > 0) {
			return quizzes;
		} else {
			throw new QuizzException("No Quizz exists..");
		}
	}

	@Override
	public Quizz getParticularQuiz(int quizz) throws QuizzException {
		Optional<Quizz> quizzes = quizzRepository.findById(quizz);
		if (quizzes.isPresent()) {
			return quizzes.get();
		} else {
			throw new QuizzException("No Quizz found with ID : " + quizz);
		}
	}
	

	@Override
	public Quizz addQuizz(Quizz quizz) throws QuizzException{
		if (quizz.getDescription().isEmpty() || quizz.getMarks().isEmpty() || quizz.getPassMarks().isEmpty()
				|| quizz.getTotalQuestion().isEmpty()){
			throw new QuizzException("input field is empty");
		}
		return quizzRepository.save(quizz);
	}

	@Override
	public Quizz deleteQuizz(int id) throws QuizzException {
		Optional<Quizz> quizz = quizzRepository.findById(id);
		if (quizz.isPresent()) {
			Quizz quizzes = quizz.get();
			quizzRepository.delete(quizzes);
			return quizzes;
		} else {
			throw new QuizzException("No Quizz found with ID : " + id);
		}
	}
}
