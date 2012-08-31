package com.Kimalu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Husband {
	@Id
	@GeneratedValue
	private int hid;
	private String name;

	@OneToOne(cascade=CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(columnDefinition="hid",name="hid",referencedColumnName="wid")
	private Wife wife;


	public String getName() {
		return name;
	}

	public Wife getWife() {
		return wife;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setWife(Wife wife) {
		this.wife = wife;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}
}
