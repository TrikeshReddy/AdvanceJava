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
		SchoolRecord schoolRecord = new SchoolRecord();
		schoolRecord.setBoard("ICSE");
		schoolRecord.setLocality("hyderabad");
		schoolRecord.setSchoolId(8);
		schoolRecord.setSchoolName("high school");
		//inserting a new school record 
		session.save(schoolRecord);
		SchoolRecord schoolRecordUpdate = new SchoolRecord();

		schoolRecordUpdate.setLocality("secunderabad");
		schoolRecordUpdate.setSchoolId(9);
		schoolRecordUpdate.setSchoolName("internation school");
		//updating a exiting school record
		session.update(schoolRecord);
		SchoolRecord schoolRecorddelete = new SchoolRecord();
		//deleting a schoolrecord
		schoolRecorddelete.setSchoolId(0);
		session.delete(schoolRecorddelete);

		session.getTransaction().commit();
		session.close();
	}
}
