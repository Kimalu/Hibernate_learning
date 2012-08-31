package com.Kimalu.model.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	public static SessionFactory sf=null;
	@BeforeClass
	public static void bc(){
		try {
			sf=new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		Teacher t=new Teacher();
		t.setName("Kimalu");
		t.setAge(12);
		t.setBrithday(new Date());
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(t);
		session.getTransaction().commit();
	}

	@AfterClass
	public static void ac(){
		sf.close();
	}
}
