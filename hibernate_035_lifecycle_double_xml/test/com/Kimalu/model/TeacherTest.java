package com.Kimalu.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	public void test1(){
		Session session=sf.getCurrentSession();
		session.beginTransaction();
		Contract c=new Contract();
		c.setName("合同1");
		Set<Dbfile> files=new HashSet<Dbfile>();
		Item item=new Item();
		item.setName("项目1");
		Dbfile file=new Dbfile();
		file.setItem(item);
		file.setName("文件1");
		files.add(file);
		c.setDbfiles(files);
		c.setItem(item);
		session.save(item);
		session.save(file);
		session.save(c);
	//	session.getTransaction().commit();
	}
	@Test
	public void test2(){
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		Contract c=(Contract) session.get(Contract.class, 1);
		Item item=c.getItem();
		Iterator<Dbfile> i=c.getDbfiles().iterator();
		while(i.hasNext()){
			i.next().setItem(item);
		}
		session.delete(c);
//		session.getTransaction().commit();
		t.commit();
		
	}
	
//	@Test
//	public void testSchemaExport() {
//		new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
//		
//	}
	@AfterClass
	public static void ac() {
		sf.close();
	}
}
