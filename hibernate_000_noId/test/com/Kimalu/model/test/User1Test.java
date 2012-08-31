package com.Kimalu.model.test;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class User1Test {
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
		User1 user=new User1();
		user.setName("Kimalu");
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
	}

	@AfterClass
	public static void ac(){
		sf.close();
	}
}
