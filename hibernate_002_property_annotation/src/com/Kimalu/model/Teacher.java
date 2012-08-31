package com.Kimalu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Teacher {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="cloumn_name")
	private String name;
	@Transient
	//在数据库表中不生成对应字段
	private int age;
	@Temporal(value=TemporalType.TIME)
	private Date brithday;
	
	@Enumerated(EnumType.STRING)
	private Title t;
	public Title getT() {
		return t;
	}
	public void setT(Title t) {
		this.t = t;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBrithday() {
		return brithday;
	}
	public void setBrithday(Date brithday) {
		this.brithday = brithday;
	}
}
