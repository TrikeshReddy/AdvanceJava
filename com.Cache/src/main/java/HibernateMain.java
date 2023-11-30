import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.entity.Employee;
import com.util.HibernateUtil;

public class HibernateMain {
	public static void main(String[] args) {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
//		 Session session=sessionFactory.openSession();    
//		 	Employee employee=new Employee();
//		 	employee.setId(121);
//		 	employee.setName("trikesh");
//		 	employee.setSalary(12345678789f);
//		 	session.save(employee);
//		 	session.close();
		 	
		 	
//			 Session session1=sessionFactory.openSession();    
//
//		    Employee emp1=(Employee)session1.load(Employee.class,121);    
//		    System.out.println("hello 21:"+emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary()); 
//		    Employee emp2=(Employee)session1.load(Employee.class,121);    
//		    System.out.println("hello 26:"+emp2.getId()+" "+emp2.getName()+" "+emp2.getSalary());    
//		   
//		    session1.close();    
//		        
//		    Session session2=sessionFactory.openSession();    
//		     session2.close();  
		Session session=sessionFactory.openSession();    
		Criteria cr = session.createCriteria(Employee.class);
		Criterion salary = Restrictions.gt("salary", 2000);
		Criterion name = Restrictions.ilike("name","as%");

		// To get records matching with AND conditions
		LogicalExpression andExp = Restrictions.and(salary, name);
		cr.add( andExp );

		cr.setProjection(Projections.avg("salary"));
		
		cr.list();
	}
}
