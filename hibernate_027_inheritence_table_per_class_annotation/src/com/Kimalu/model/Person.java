package com.Kimalu.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person {
	@Id 
	@GeneratedValue(generator="uid")
	@GenericGenerator(name="uid", strategy = "uuid")
	private String  id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
