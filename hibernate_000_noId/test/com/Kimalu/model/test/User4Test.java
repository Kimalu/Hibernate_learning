package com.Kimalu.model.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class User4Test {
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
		User4 user=new User4();
		user.setT(Title.B);
		user.setName("Kimalu");
		user.setTitle(Title.C);
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
