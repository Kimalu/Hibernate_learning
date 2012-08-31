package com.Kimalu.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Husband {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@Embedded
	@AttributeOverrides(
			{
				@AttributeOverride(name="name",column=@Column(name="wifeName")),
				@AttributeOverride(name="age",column=@Column(name="wifeAge"))
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
