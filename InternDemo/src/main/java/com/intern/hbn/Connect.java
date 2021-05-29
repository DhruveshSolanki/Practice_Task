package com.intern.hbn;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connect {

	protected SessionFactory getConfigure() {
		Configuration cfg = new Configuration();
		SessionFactory sf = null;
		try {

			sf = cfg.configure().buildSessionFactory();
			return sf;

		} catch (Exception e) {
			System.out.println("Failed to Configure..." + e.getMessage());
			return sf;
		}

	}

	public String insertData(Person p) {

		SessionFactory sf = this.getConfigure();
		Session session = null;
		Transaction t = null;
        String msg="";
		try {
			session = sf.openSession();
			System.out.println("connecgted");
			t = session.beginTransaction();
			
			//------till now no operation on this object
			session.save(p);
			p.setpName("xyz");
			t.commit();
			msg="Succesfully Inserted";
		} catch (Exception e) {
			t.rollback();
			msg=" Failed to Insert Data"+e.getMessage();
		} finally {
			session.close();
			System.out.println("disconnected");
			p.setpName("alok");
		}
		return msg;
	}

	public String updateData(Person p) {
		SessionFactory sf = this.getConfigure();
		Session session = null;
		Transaction t = null;
		String msg="";
		try {
			session = sf.openSession();
			t = session.beginTransaction();
			Person p1 = (Person) session.load(Person.class, p.getpId());
			//  p1    persistent object
			//  if i will try to chnage its value ...tablwe row value will be chnages and update query will be fired
			p1.setpName(p.getpName());
			msg="Succesfully Updated...";
			t.commit();
		} catch (Exception e) {
			t.rollback();
			msg="Err occured..." + e.getMessage();
		} finally {
			session.close();
		}
		return msg;
	}

	public List<Person> displayData() {
		SessionFactory sf = this.getConfigure();
		Session session = null;
		List<Person> list = null;
		 String hql="from Person";
	       Query q=null;
	       try
	       {
	       	  session=sf.openSession();
	       	  q=session.createQuery(hql);
	       	  list= (List<Person>) q.list();
	       	 
	       	}
	       	catch(Exception e){
	    		System.out.println("some error occured..." +e.getMessage());
	       	}
	        finally{
	        	session.close();        
	        }
	       return list;
	}

	public String deleteData(int id) {
		SessionFactory sf = this.getConfigure();
		Session session = null;
		Transaction t =null;
		String msg="";
		try {
			session = sf.openSession();
			t = session.beginTransaction();
			
			Person person=(Person)session.load(Person.class,id);
			//  delete method always takes persistent object as a argument...
     	   session.delete(person);
     	   System.out.println("Data to be Deleted:");
     	  System.out.println(person);
     	  t.commit();
     	  msg="Deleted Succesfully...";
		} catch (Exception e) {
			 t.rollback();
	    		msg="some error occured..." +e.getMessage();
		}
		finally {
			session.close();	
		}	
		return msg;
	}
		
		
}

	/*
	 * try {
	 * 
	 * Configuration cfg = new Configuration(); SessionFactory sf
	 * =cfg.configure().buildSessionFactory(); Session session = null; Transaction t
	 * = null;
	 * 
	 * try { session = sf.openSession(); t= session.beginTransaction();
	 * 
	 * 
	 * t.commit(); } catch (Exception e) { t.rollback(); }finally { sf.close(); }
	 * 
	 * } catch (Exception e) { System.out.println("Failed to Config..."+
	 * e.getMessage()); } }
	 */

