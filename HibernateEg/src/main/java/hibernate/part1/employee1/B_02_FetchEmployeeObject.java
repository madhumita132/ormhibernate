package hibernate.part1.employee1;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.part.employee.Employee;


public class B_02_FetchEmployeeObject {
	
	public static void main(String args[])
	{
	
	    
		Configuration cfg = new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Fetching values from the entity associated with the table.
		//Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but
		//instead of opening on tables and columns,HQL works with persistent objects and their properties.
		
		
		//Syntax : session.createQuery("HQL Query"/String variable which has hql query)
		String hql1 = "FROM Employee";
		
		Query query = session.createQuery(hql1); //equivalent to sql : select * from employeedetails;
		List results = query.list();
		
		System.out.println("Employee Details");
		
		//Iterator iterator = results.iterator();
		for(Iterator iterator = results.iterator();iterator.hasNext();) 
		{
			Employee emp =  (Employee) iterator.next();
			System.out.println("First Name : " + emp.getFirstName() + "Last Name : " + emp.getLastName()
			+ "Salary : " + emp.getSalary());
		}
		String hql11 = "FROM Employee";
		String hql2 = "FROM Employee E WHERE E.id=2";
		String hql3 = "FROM Employee E WHERE E.id > 1 ORDER BY E.salary DESC";
		
	}

}
