package com.Kimalu.model.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
//只能在oracle数据库使用
@Entity
@SequenceGenerator(name="a_seq",sequenceName="a_oracle_seq",allocationSize=1)
public class User2 {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="a_seq")
	private int id;
	private String name;
	
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
