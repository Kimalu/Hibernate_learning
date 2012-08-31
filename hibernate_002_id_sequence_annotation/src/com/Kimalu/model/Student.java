package com.Kimalu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq",allocationSize=1,sequenceName="Kimalu_seq")
public class Student {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	//默认的sequence名称为HIBERNATE_SEQUENCE
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//不指定生成器，hibernate会自动生成一个oracle的sequence，但自增长的值不确定
	private int id;
	private String name;
	private int age;
	
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
}
