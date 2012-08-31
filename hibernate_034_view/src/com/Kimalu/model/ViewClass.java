package com.Kimalu.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;
@Entity
//����д����sql������hql
@Subselect("select t.id,t.name from teacher t join student s on t.id = s.id group by t.name")
//@Subselect("select id, name from teacher union select id, name from student")
@Synchronize( {"student", "teacher"} )//��������������
public class ViewClass {
	@Id
	private int id;			//�����������Ҫ��select����е��ֶ�����һһ��Ӧ
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
