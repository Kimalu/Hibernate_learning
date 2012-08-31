package com.Kimalu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Score {
	@Id
	@GeneratedValue
	private int id;
	private float score;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="studentId")
	private Student student;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="courseId")
	private Course course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
