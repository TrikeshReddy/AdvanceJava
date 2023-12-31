package com.mainmethod;

import org.hibernate.Session;

import com.entity.Employee;

public class HibernateFirst {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// open the session
		Session session = HibernateUtil.getSessionFactory().openSession();
		// For doing any CRUD operation,
		// let us start a transaction
		session.beginTransaction();

		Employee employee =new Employee();
		employee.setEmpId(2);
		employee.setName("rakesh");
		employee.setDeptNo(10);
		employee.setAge(26);
		
		session.update(employee);

		// commit will help to complete
		// the changes in the table
		session.getTransaction().commit();

		// close the session
		session.close();
	}
}
