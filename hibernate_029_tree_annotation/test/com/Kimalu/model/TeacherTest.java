package com.Kimalu.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;

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
		Org o=new Org();
		o.setName("0");
		Org o1=new Org();
		o1.setName("01");
		Org o2=new Org();
		o2.setName("02");
		Org o11=new Org();
		o11.setName("011");
		Org o12=new Org();
		o12.setName("012");
		Org o21=new Org();
		o21.setName("021");
		Org o22=new Org();
		o22.setName("022");
		
		o.getChildren().add(o1);
		o.getChildren().add(o2);
		o1.getChildren().add(o11);
		o1.getChildren().add(o12);
		o2.getChildren().add(o21);
		o2.getChildren().add(o22);
		
		o1.setParents(o);
		o2.setParents(o);
		o11.setParents(o1);
		o12.setParents(o1);
		o21.setParents(o2);
		o22.setParents(o2);
		
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		session.save(o);
		session.getTransaction().commit();
		
	}
	@Test
	public void testLoad(){
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Org org=(Org)session.get(Org.class, 1);
		session.getTransaction().commit();
		print(org,0);
	}

	private void print(Org org,int level) {
		for(int i=0;i<level;i++){
			System.out.print("|__");
		}
		System.out.println(org.getName());
		for(Org o:org.getChildren()){
			print(o,level+1);
		}
	}

	@AfterClass
	public static void ac() {
		sf.close();
	}
}
