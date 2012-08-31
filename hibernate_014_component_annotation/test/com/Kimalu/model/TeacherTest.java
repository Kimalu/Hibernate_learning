package com.Kimalu.model;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
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

	@Test
	public void testSave(){
		Wife w=new Wife();
		w.setAge(12);
		w.setName("Zoe");
		
		Husband h=new Husband();
		h.setName("Kimalu");
		h.setWife(w);
		
		
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.save(h);
		session.getTransaction().commit();
	}
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
		
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
