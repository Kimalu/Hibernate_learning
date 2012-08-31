package com.Kimalu.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	public static SessionFactory sf = null;

	@BeforeClass
	public static void bc() {
		
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void testSchemaExport() {
//		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
//		
//	}
	@Test
	public void testSave(){
		Person p=new Person();
		p.setName("god");
		Student student=new Student();
		student.setScore(123);
		student.setName("Kimalu");
		Teacher t=new Teacher();
		t.setName("Zoie");
		t.setTitle("A");
		
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		s.persist(p);
		s.save(student);
		s.save(t);
		s.getTransaction().commit();
		
	}
	@Test
	public void testLoad(){
		Session s=sf.getCurrentSession();
		s.beginTransaction();
		Student student=(Student)s.get(Student.class, 4);
		System.out.println(student.getName());
		s.getTransaction().commit();
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
