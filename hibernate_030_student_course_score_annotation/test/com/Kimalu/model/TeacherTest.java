package com.Kimalu.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	public static SessionFactory sf = null;

	@BeforeClass
	public static void bc() {
		// sf = new Configuration().configure().buildSessionFactory();
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
	public void testSave(){
		Student s1=new Student();
		s1.setName("Kimalu");
		Student s2=new Student();
		s2.setName("Zoie");
		Course c1=new Course();
		c1.setName("computer");
		Course c2=new Course();
		c2.setName("english");
		Score s1c1=new Score();
//		s1c1.setId(1);
		s1c1.setCourse(c1); 
		s1c1.setStudent(s1);
		s1c1.setScore(100);
		Session session=sf.getCurrentSession();
		session.beginTransaction();
//		session.save(s1);
//		session.save(s2);
//		session.save(c1);
//		session.save(c2);
		
		session.save(s1c1);
		session.getTransaction().commit();
		
	}
	public static void ac() {
		sf.close();
	}
}
