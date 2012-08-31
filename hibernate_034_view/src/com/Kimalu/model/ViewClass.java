package com.Kimalu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
@Entity
//这里写的是sql而不是hql
@Subselect("select t.id,t.name from teacher t join student s on t.id = s.id group by t.name")
//@Subselect("select id, name from teacher union select id, name from student")
@Synchronize( {"student", "teacher"} )//表名而不是类名
public class ViewClass {
	@Id
	private int id;			//类的属性名称要和select语句中的字段名能一一对应
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
