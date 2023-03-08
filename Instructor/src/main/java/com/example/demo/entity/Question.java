package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "questionbank")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	
	@Column(name="question_title")
	private String questionTitle;
	
	@Column(name="question")
	private String question;

	@Column(name="option_one")
	private String optionOne;
	
	@Column(name="option_two")
	private String optionTwo;
	
	@Column(name="option_three")
	private String optionThree;
	
	@Column(name="option_four")
	private String optionFour;

	@Column(name="answer")
	private String answer;
	
	@Column(name="mark")
	private String mark;
	
	@Column(name="level_of_difficulty")
	private String levelOfDifficulty;

	@ManyToOne
	@JoinColumn(name = "subjectId")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "quizzId")
	private Quizz quizz;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionOne() {
		return optionOne;
	}

	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}

	public String getOptionTwo() {
		return optionTwo;
	}

	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}

	public String getOptionThree() {
		return optionThree;
	}

	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}

	public String getOptionFour() {
		return optionFour;
	}

	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Quizz getQuizz() {
		return quizz;
	}

	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}

	public String getLevelOfDifficulty() {
		return levelOfDifficulty;
	}

	public void setLevelOfDifficulty(String levelOfDifficulty) {
		this.levelOfDifficulty = levelOfDifficulty;
	}

}
