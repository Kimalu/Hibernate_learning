package com.Kimalu.model.test;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User4 {
	@Id
	@Enumerated(EnumType.ORDINAL)
	private Title t;
	public Title getT() {
		return t;
	}
	public void setT(Title t) {
		this.t = t;
	}
	@Enumerated(EnumType.STRING)
	private Title title;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
}
