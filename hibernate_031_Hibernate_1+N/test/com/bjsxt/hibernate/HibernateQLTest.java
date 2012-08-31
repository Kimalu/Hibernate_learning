package com.bjsxt.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class HibernateQLTest {
	private static SessionFactory sf;
	
	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}
	
	@AfterClass
	public static void afterClass() {
		sf.close();
	}
	
	@Test
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	}
	
	@Test
	public void testSave() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		for (int i = 0; i < 10; i++) {
			Topic t=new Topic();
			t.setTitle("t"+i);
			t.setCreateDate(new Date());
			List<Msg> msgList=new ArrayList<Msg>();
			for(int j=0; j<10; j++) {
				Msg m=new Msg();
				m.setTopic(t);
				m.setCont("m"+i+j);
				msgList.add(m);
			}
			t.setMsgs(msgList);
			session.persist(t);
		}	
		session.getTransaction().commit();
	}
	
	//N+1
	@Test
	public void testQuery1() {
		Session session = sf.openSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		Topic topic = (Topic)session.createQuery("from Topic where id=1").uniqueResult();
					 
		for(Msg s : topic.getMsgs()) {
			System.out.println(s.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testQuery2() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Topic topics = (Topic)session.get(Topic.class, 1);
			
		for (Iterator<Msg> iterator = topics.getMsgs().iterator(); iterator.hasNext();) {
			Msg m = (Msg) iterator.next();
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
	}
	
	@Test
	public void testQuery3() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Msg m = (Msg)session.get(Msg.class, 1);
		System.out.println(m.getTopic().getTitle());
		session.getTransaction().commit();
	}
	
	@Test
	public void testQuery4() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		Msg m=(Msg)session.createQuery("from Msg where id=1").uniqueResult();
		System.out.println(m.getTopic().getTitle());			 
		session.getTransaction().commit();
	}
	
	@Test
	public void testQuery5() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Topic topics = (Topic)session.load(Topic.class, 1);
		System.out.println(topics.getTitle());
		for (Iterator<Msg> iterator = topics.getMsgs().iterator(); iterator.hasNext();) {
			Msg m = (Msg) iterator.next();
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testQuery6() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		Msg m = (Msg)session.load(Msg.class, 1);
		System.out.println(m.getCont());
		System.out.println(m.getTopic().getTitle());
		session.getTransaction().commit();
	}

//	@BatchSize
	@Test
	public void testQuery7() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		List<Msg> Msgs = (List<Msg>)session.createQuery("from Msg").list();
		
		for(Msg m : Msgs) {
			System.out.println(m.getCont());
		}
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void testQuery8() {
		Session session = sf.getCurrentSession();
		session.beginTransaction();
		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
		List<Msg> mList=(List<Msg>) session.createQuery("from Msg").list();
		for (Iterator<Msg> iterator = mList.iterator(); iterator.hasNext();) {
			Msg msg = (Msg) iterator.next();
			System.out.println(msg.getTopic().getTitle());			 
		}
		session.getTransaction().commit();
	}
//	//join fetch
//	@Test
//	public void testQuery4() {
//		Session session = sf.openSession();
//		session.beginTransaction();
//		//List<Topic> topics = (List<Topic>)session.createCriteria(Topic.class).list();
//		List<Topic> topics = (List<Topic>)session.createQuery("from Topic t left join fetch t.category c").list();
//		
//		for(Topic t : topics) {
//			System.out.println(t.getId() + "-" + t.getTitle());
//			System.out.println(t.getCategory().getName());
//		}
//		session.getTransaction().commit();
//		session.close();
//		
//	}
	public static void main(String[] args) {
		beforeClass();
	}
}
