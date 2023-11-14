package com.hibernate3.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate3.entity.Adress;
import com.hibernate3.entity.Student;

import jakarta.persistence.TypedQuery;


public class Hibarnate3Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sessionFactory =new Configuration().configure("hibernate.configuration.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Adress adress = new Adress();
		adress.setAddressId(3);
		adress.setCity("hyderabad");
		adress.setPincode(500050);
		adress.setCountry("india");
		
		Student student =new Student();
		student.setStudId(100199);
		student.setGrade(8);
		student.setStuName("nihal");
		student.setAdress(adress);
		
		session.persist(student);
		
		session.getTransaction().commit();
		TypedQuery query=session.createQuery("from Student");    
	    List<Student> list=query.getResultList();  
	    Iterator<Student> itr=list.iterator();    
	    while(itr.hasNext()){    
	    	Student student1=itr.next();    
	     System.out.println(student1.getStudId()+" "+student1.getStuName()+" "+student1.getGrade());    
	     Adress address=student1.getAdress();    
	     System.out.println(address.getAddressId()+" "+address.getCity()+" "+address.getCountry()+" "+address.getPincode());    
	    }    
		session.close();
		
	}
}
