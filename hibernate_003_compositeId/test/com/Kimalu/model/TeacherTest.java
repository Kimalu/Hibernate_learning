package com.Kimalu.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	public static SessionFactory sf = null;

	@BeforeClass
	public static void bc() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void saveStudent() {
		PK pk = new PK();
		pk.setId(1);
		pk.setName("Kimalu");
		Student s = new Student();
		s.setPk(pk);
		s.setAge(19);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void saveTeacher() {
		Teacher s=new Teacher();
		s.setId(2);
		s.setName("Kimalu");
		s.setAge(19);
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void ac() {
		sf.close();
	}
}
