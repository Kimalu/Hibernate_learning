package com.Kimalu.model;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
public class TeacherTest {
	public static SessionFactory sf=null;
	@BeforeClass
	public static void bc(){
		System.out.println("bc");
		try {
			sf=new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void saveTeacher(){
		Teacher s=new Teacher();
		
		s.setName("Kimalu");
		s.setAge(10);
		s.setT(Title.B);
		s.setBrithday(new Date());
		Session session=sf.openSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void loadTeacher(){
		Session session=sf.openSession();
		Teacher s=(Teacher) session.load(Teacher.class, 1);
		System.out.println(s.getBrithday());
		System.out.println(s.getAge());
		System.out.println(s.getName());
		System.out.println(s.getT());
		session.close();
	}
	@AfterClass
	public static void ac(){
		System.out.println("ac");
		sf.close();
	}
}
