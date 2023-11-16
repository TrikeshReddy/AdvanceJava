package com.Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Laptop;

public class OneToManyMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(100);
		employee.setEmpName("mahesh");
		employee.setSal(1234567);
		
		//created one laptop object
		Laptop laptop1 = new Laptop();
		laptop1.setBrand("mac");
		laptop1.setLaptopId(1);
		laptop1.setRam(32);
		
		//created second laptop object
		Laptop laptop2 = new Laptop();
		laptop2.setBrand("dell");
		laptop2.setLaptopId(2);
		laptop2.setRam(16);
		
		//added the laptops to list
		List<Laptop> list = new ArrayList<Laptop>();
		list.add(laptop1);
		list.add(laptop2);

		//setting it to employee object
		employee.setListOfLaptops(list);
		
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();
	}
}
