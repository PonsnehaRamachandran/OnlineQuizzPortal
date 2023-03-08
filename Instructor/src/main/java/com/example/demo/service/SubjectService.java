package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Subject;
import com.example.demo.exceptions.SubjectException;

@Service
public interface SubjectService {

	List<Subject> getAllSubject() throws SubjectException;
	Subject addSubject(Subject subject) throws SubjectException ;
	public Subject deleteSubject(int subjectId) throws SubjectException ;


}
