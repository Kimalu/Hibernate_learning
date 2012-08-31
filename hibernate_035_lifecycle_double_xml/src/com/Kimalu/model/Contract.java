package com.Kimalu.model;

import java.util.HashSet;
import java.util.Set;

public class Contract {
	private int id;
	private String name;
	private Set<Dbfile> dbfiles=new HashSet<Dbfile>();
	private Item item;
	
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
	public Set<Dbfile> getDbfiles() {
		return dbfiles;
	}
	public void setDbfiles(Set<Dbfile> dbfiles) {
		this.dbfiles = dbfiles;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

}
