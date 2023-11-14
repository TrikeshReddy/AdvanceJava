package com.main;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;;

public class HibernateMain {
	public static void main(String[] args) {
	SessionFactory sessionFactory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	
	session.getTransaction().commit();
	session.close();
	
		
	}
}
