package com.Kimalu.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Org {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToMany(mappedBy="parents",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Org> children=new HashSet<Org>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="parentId")
	private Org parents=null;
	
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
	public Set<Org> getChildren() {
		return children;
	}
	public void setChildren(Set<Org> children) {
		this.children = children;
	}
	public Org getParents() {
		return parents;
	}
	public void setParents(Org parents) {
		this.parents = parents;
	}
}
