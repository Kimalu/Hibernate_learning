package com.Kimalu.model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewClassTest {
	public static SessionFactory sf = null;

	@BeforeClass
	public static void bc() {
//		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetViewClass(){
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		List<ViewClass> vcList=sf.getCurrentSession().createQuery("from ViewClass").list();
		session.getTransaction().commit();
		System.out.println(vcList.size());
	}
	
	@Test
	public void testInitData(){
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Teacher t=new Teacher();
		t.setName("t1");
		Student s=new Student();
		s.setName("s1");
		session.save(t);
		session.save(s);
		session.getTransaction().commit();
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
