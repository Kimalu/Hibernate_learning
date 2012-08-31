package com.Kimalu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Wife1 {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@OneToOne(mappedBy="wife",cascade=CascadeType.PERSIST)
	private Husband1 husband;
	
	public Husband1 getHusband() {
		return husband;
	}
	public void setHusband(Husband1 husband) {
		this.husband = husband;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
