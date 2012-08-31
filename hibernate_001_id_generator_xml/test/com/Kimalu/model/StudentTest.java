package com.Kimalu.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
public class StudentTest {
	@Test
	public void saveStudent(){
		Student s =new Student();
		s.setAge(1);
		s.setName("Kimalu");
		s.setId(1);
		Configuration cfg=new Configuration();
		SessionFactory sf=cfg.configure().buildSessionFactory();
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
