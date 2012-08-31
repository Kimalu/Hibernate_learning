package com.Kimalu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="a_tab",table="a_gen_table",pkColumnName="pk_key",valueColumnName="pk_value",pkColumnValue="Aaa",allocationSize=1)
public class Aaa {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="a_tab")
	private int a;
	private int b;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int c;
	private int d;
	
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
}
