package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjectss")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;

	@Column(name="subject_name")
	private String subjectName;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Subject(int subjectId) {
		this.subjectId = subjectId;
	}

	public Subject() {
		this.subjectId = 0;
		this.subjectName = "";
	}
}
