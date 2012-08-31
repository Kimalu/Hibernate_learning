package com.Kimalu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;

@Entity
public class Husband {
	@Id
	@GeneratedValue
	private int id;
	private String name;

	@OneToOne
	@JoinColumns(
		{
			@JoinColumn(name="wifeId",referencedColumnName="id"),
			@JoinColumn(name="wifeName",referencedColumnName="name")
		}
	)
	private Wife wife;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Wife getWife() {
		return wife;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
