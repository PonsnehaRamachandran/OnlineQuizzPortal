package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "r_result")
@Entity
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resultId;
	
	@Column(name="result_status")
	private String resultStatus;
	
	@Column(name="result_score")
	private String resultScore;
	
	@Column(name="total_marks")
	private String totalMarks;
	
	@Column(name="total_question")
	private String totalQuestion;

	@ManyToOne(targetEntity = Quizz.class)
	@JoinColumn(name = "quizzId")
	private Quizz quizzId;

	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "id")
	private User user;

	public Result() {
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public String getResultScore() {
		return resultScore;
	}

	public void setResultScore(String resultScore) {
		this.resultScore = resultScore;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getTotalQuestion() {
		return totalQuestion;
	}

	public void setTotalQuestion(String totalQuestion) {
		this.totalQuestion = totalQuestion;
	}

	public Quizz getQuizzId() {
		return quizzId;
	}

	public void setQuizzId(Quizz quizzId) {
		this.quizzId = quizzId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Result(int resultId, String resultStatus, String resultScore, String totalMarks, String totalQuestion,
			Quizz quizzId, User user) {
		super();
		this.resultId = resultId;
		this.resultStatus = resultStatus;
		this.resultScore = resultScore;
		this.totalMarks = totalMarks;
		this.totalQuestion = totalQuestion;
		this.quizzId = quizzId;
		this.user = user;
	}

	

}
