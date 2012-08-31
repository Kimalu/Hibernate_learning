package com.Kimalu.model.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="a_tab",table="a_gen_table",pkColumnName="pk_key",valueColumnName="pk_value",pkColumnValue="Aaa",allocationSize=1)
public class User1 {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="a_tab")
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
