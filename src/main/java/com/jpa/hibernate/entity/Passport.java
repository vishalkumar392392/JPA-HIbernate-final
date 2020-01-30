package com.jpa.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String number;

	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;

	/*
	 * public Student getStudent() { return student; }
	 * 
	 * public void setStudent(Student student) { this.student = student; }
	 */

	public Passport() {
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + ", student=" + student + "]";
	}

	

}
