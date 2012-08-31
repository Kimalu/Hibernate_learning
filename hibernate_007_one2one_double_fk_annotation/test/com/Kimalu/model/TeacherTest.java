package com.Kimalu.model;

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
//		sf = new AnnotationConfiguration().configure().buildSessionFactory();
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
	
	/**
	 * 只在Husband中设置和Wife的关系，不在wife中设置和husband的关系
	 * 通过保存husband来级联保存wife
	 */
	@Test
	public void saveHusband(){
		
		Husband h=new Husband();
		h.setName("Kimalu");
		Wife w=new Wife();
		w.setName("Zoe");
		h.setWife(w);
		
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(h);
		session.getTransaction().commit();
	}
	/**
	 * 在这里因为一对一的关系是通过husband来维护的，所以在保存wife的时候，还是先保存husband再保存wife
	 * 程序中没有在husband中设置呢wife的关系,所以husband字段中的外键为null
	 */
	@Test
	public void saveWife1(){
		
		Husband h=new Husband();
		h.setName("Kimalu");
		Wife w=new Wife();
		w.setName("Zoe");
		//h.setWife(w);		//在husband中也设置和wife的关系，那么外键才不为空
		w.setHusband(h);
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.persist(w);
		session.getTransaction().commit();
	}
	
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
