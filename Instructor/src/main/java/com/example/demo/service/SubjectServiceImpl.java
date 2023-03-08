package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Subject;
import com.example.demo.exceptions.SubjectException;
import com.example.demo.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubject() throws SubjectException {
		List<Subject> subjects = subjectRepository.findAll();
		if (subjects.size() > 0) {
			return subjects;
		} else {
			throw new SubjectException("No Subject exists..");
		}

	}
	
	@Override
	public Subject addSubject(Subject subject) throws SubjectException {
		 if (subject == null) {
		        throw new SubjectException("subject parameter is null");
		    }
		if (subject.getSubjectName().isEmpty()) {
			throw new SubjectException("input field is empty");
		}

		return subjectRepository.save(subject);
	}

	@Override
	public Subject deleteSubject(int subjectId) throws SubjectException {
		Optional<Subject> subject = subjectRepository.findById(subjectId);
		if (subject.isPresent()) {
			Subject subjects = subject.get();
			subjectRepository.delete(subjects);
			return subjects;
		} else {
			throw new SubjectException("No Subject found with ID : " + subjectId);
		}
	}

}
