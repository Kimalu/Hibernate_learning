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
//		sf = new AnnotationConfiguration().configure().buildSessionFactory();
		try {
			sf = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
		
	}
	
	@Test
	public void testSave() {
		Husband h=new Husband();
		Wife w=new Wife();
		h.setWife(w);
		w.setName("zoie");
		h.setName("kimalu");
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(h);
		session.getTransaction().commit();
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
