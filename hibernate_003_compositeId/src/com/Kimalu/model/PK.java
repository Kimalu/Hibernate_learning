package com.Kimalu.model;

import java.io.Serializable;

public class PK implements Serializable {
	
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
	public boolean equals(Object o) {
		if (o instanceof PK) {
			PK pk = (PK) o;
			if (pk.id == id && pk.name.equals(name))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
