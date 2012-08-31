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
	 * ֻ��Husband�����ú�Wife�Ĺ�ϵ������wife�����ú�husband�Ĺ�ϵ
	 * ͨ������husband����������wife
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
	 * ��������Ϊһ��һ�Ĺ�ϵ��ͨ��husband��ά���ģ������ڱ���wife��ʱ�򣬻����ȱ���husband�ٱ���wife
	 * ������û����husband��������wife�Ĺ�ϵ,����husband�ֶ��е����Ϊnull
	 */
	@Test
	public void saveWife1(){
		
		Husband h=new Husband();
		h.setName("Kimalu");
		Wife w=new Wife();
		w.setName("Zoe");
		//h.setWife(w);		//��husband��Ҳ���ú�wife�Ĺ�ϵ����ô����Ų�Ϊ��
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
