package com.Kimalu.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	public static SessionFactory sf = null;

	@BeforeClass
	public static void bc() {
//		sf = new Configuration().configure().buildSessionFactory();
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
		
	}
	@Test
	public void add(){
		Teacher t1=new Teacher();
		t1.setName("t1");
		Teacher t2=new Teacher();
		t2.setName("t2");
		Teacher t3=new Teacher();
		t3.setName("t3");
		Teacher t4=new Teacher();
		t4.setName("t4");
		
		Student s1=new Student();
		s1.setName("s1");
		Student s2=new Student();
		s2.setName("s2");
		Student s3=new Student();
		s3.setName("s3");
		Student s4=new Student();
		s4.setName("s4");
		
		Set<Student> students=new HashSet<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		
		t1.setStudents(students);
		t2.setStudents(students);
		t3.setStudents(students);
		t4.setStudents(students);
		
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.save(t1);
		session.save(t2);
		session.save(t3);
		session.save(t4);
		session.getTransaction().commit();
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
