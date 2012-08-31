package com.Kimalu.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Kimalu.model.test.Teacher;

public class StudentTest {
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
		Student s=new Student();
		s.setName("Kimalu");
		s.setAge(12);
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(s);
		session.getTransaction().commit();
	}

	@AfterClass
	public static void ac(){
		sf.close();
	}

}
