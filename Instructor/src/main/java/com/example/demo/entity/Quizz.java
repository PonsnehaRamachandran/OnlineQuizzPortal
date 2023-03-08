package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "quizzes")
public class Quizz {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "quizzId")
	private int id;

	@ManyToOne
	private Subject subject;

	@Column(name = "quizz_description")
	private String description;

	@Column(name = "quizz_marks")
	private String marks;

	@Column(name = "quizz_totalQuestion")
	private String totalQuestion;

	@Column(name = "quizz_passMarks")
	private String passMarks;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public String getPassMarks() {
		return passMarks;
	}

	public void setPassMarks(String passMarks) {
		this.passMarks = passMarks;
	}

	public Quizz(int id, Subject subject, String description, String marks, String totalQuestion, String passMarks) {
		super();
		this.id = id;
		this.subject = subject;
		this.description = description;
	}
	public Quizz() {
	}

	public Quizz(int id) {
		super();
		this.id = id;
	}

}
