package com.Kimalu.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public void testSave(){
		Husband hb=new Husband();
		hb.setName("Kimalu");
		Wife w=new Wife();
		w.setName("Zoie");
		
		hb.setWife(w);
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(hb);
		session.getTransaction().commit();
	}
	
	@Test
	public void testSave2(){
		Husband hb=new Husband();
		hb.setName("Kimalu");
		
		
		Session session=sf.openSession();
		session.beginTransaction();
		
		
		Wife w=(Wife)session.get(Wife.class, 1);
		hb.setWife(w);
		session.persist(hb);
		session.getTransaction().commit();
	}
	
	/**
	 * 可以执行成功
	 */
	@Test
	public void testSave3(){
		Wife w=new Wife();
		w.setName("Zoie");
		Session session=sf.openSession();
		session.beginTransaction();
		session.persist(w);
		session.getTransaction().commit();
	}
	
	/**
	 * 可以执行成功
	 */
	@Test
	public void testSave4(){
		Wife w=new Wife();
		w.setName("Zoie");
		Session session=sf.openSession();
		session.beginTransaction();
		Husband h=(Husband)session.get(Husband.class, 1);
		h.setWife(w);
		session.persist(h);
		session.getTransaction().commit();
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new Configuration().configure()).create(false, true);
		
	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
