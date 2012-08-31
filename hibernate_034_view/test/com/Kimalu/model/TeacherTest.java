package com.Kimalu.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
	public void saveTeacher() {
		Teacher t=new Teacher();
		t.setName("Kimalu");
		Student s=new Student();
		s.setName("3lifan_zheng");
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}
	@Test
	public void criteriaTest() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Criteria c=session.createCriteria(Teacher.class);
		c.add(Restrictions.eq("name", "Kimalu"));
		c.createCriteria("student").add(Restrictions.like("name", "2%"));
		List<Teacher> tl=c.list();
		session.getTransaction().commit();
	}
	
//	@Test
//	public void update1Teacher() {
//		Teacher s=new Teacher();
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		s=(Teacher)session.get(Teacher.class, 2);
//		s.setAge(1);
//		s.setAge(2);
//		session.getTransaction().commit();
//	}
//	
//	@Test
//	public void update2Teacher() {
//		Teacher s=new Teacher();
//		s.setId(2);
//		s.setName("ewqewqewq");
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		session.update(s);
//		session.getTransaction().commit();
//		
//	}
//	@Test
//	public void testSchemaExport() {
//		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);
//		
//	}
//	@Test
//	public void update3Teacher() {
//		Teacher s=new Teacher();
//		
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		Query q=session.createQuery("update Teacher t set t.name='zlf' where t.id='2'");
//		q.executeUpdate();
//		session.getTransaction().commit();
//		
//	}
//	@Test
//	public void update4Teacher() {
//		Teacher s=new Teacher();
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		s=(Teacher)session.get(Teacher.class, 2);
//		s.setName("ewqewqewq");
//		session.getTransaction().commit();
//	}
//
//	@Test
//	public void loadTeacher() {
//		Teacher s=new Teacher();
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		s=(Teacher)session.get(Teacher.class, 2);
//		
//		System.out.println(s.getAge());
//		System.out.println(s.getName());
//		s=(Teacher)session.load(Teacher.class, 2);
//		System.out.println(s.getName());
//		System.out.println(s.getAge());
//		session.getTransaction().commit();
//	}
//	
//	@Test
//	public void delTeacher() {
//		Teacher s=new Teacher();
//		s.setId(1);
//		s.setName("Aaa");
//		s.setAge(19);
//		Session session = sf.getCurrentSession();
//		session.beginTransaction();
//		session.delete(s);
//		session.getTransaction().commit();
//	}
//	@Test
//	public void saveTeacher10times() {
//		Session session=sf.getCurrentSession();
//		Transaction t=session.beginTransaction();
//		//for(int i=0;i<10;i++){
//			Teacher s=new Teacher();
//			s.setName("Kimalu");
//			s.setAge(3);
//			
//			session.save(s);
//			
//		//}
//		t.commit();
//	}
//	@Test
//	public void criteriaTest(){
//		Session session=sf.getCurrentSession();
//		session.beginTransaction();
//		Criteria c=session.createCriteria(Teacher.class);
//		c.add(Restrictions.between("age", 1, 6));
//		List<Teacher> tl=c.list();
//		System.out.println(tl);
//		session.getTransaction().commit();
//		
//	}
	
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
