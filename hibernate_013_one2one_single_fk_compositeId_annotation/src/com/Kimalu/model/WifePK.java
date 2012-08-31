package com.Kimalu.model;

import java.io.Serializable;

public class WifePK implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof WifePK) {
			WifePK wpk = (WifePK) obj;
			if (wpk.id == id && wpk.name.equals(this.name))
				return true;
		}
		return false;
	}
	
}
