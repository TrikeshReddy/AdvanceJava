package com.Crud.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Crud.entity.SchoolRecord;

public class CrudMain {
	public static void main(String[] args) {
		//creating will be done by config file and session factory object
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		

		//reading using primary key
		int schoolId=8;
		SchoolRecord schRecord=session.get(SchoolRecord.class, schoolId);
		System.out.println(schRecord);
		
		
		SchoolRecord schoolRecord = new SchoolRecord();
		schoolRecord.setBoard("ICSE");
		schoolRecord.setLocality("hyderabad");
		schoolRecord.setSchoolId(21);
		schoolRecord.setSchoolName("high school");
		//inserting a new school record 
		session.save(schoolRecord);
		SchoolRecord schoolRecordUpdate = new SchoolRecord();

		schoolRecordUpdate.setLocality("hyderabad");
		schoolRecordUpdate.setSchoolId(8);
		schoolRecordUpdate.setSchoolName("internation school");
		//updating a exiting school record
		session.update(schoolRecord);
		SchoolRecord schoolRecorddelete = new SchoolRecord();
		//deleting a schoolrecord
		schoolRecorddelete.setSchoolId(0);
		session.delete(schoolRecorddelete);
		
		schoolId=8;
		SchoolRecord schRecord2=session.get(SchoolRecord.class, schoolId);
		System.out.println(schRecord2);
		session.getTransaction().commit();
		session.close();
	}
}
