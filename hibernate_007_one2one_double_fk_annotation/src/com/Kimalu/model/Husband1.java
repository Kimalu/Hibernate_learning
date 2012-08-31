package com.Kimalu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Husband1 {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@OneToOne
	@JoinColumn(name = "wifeId")
	private Wife1 wife;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wife1 getWife() {
		return wife;
	}

	public void setWife(Wife1 wife) {
		this.wife = wife;
	}

}
