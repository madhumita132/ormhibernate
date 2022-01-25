package hibernate.part1.employee1;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import hibernate.part.employee.Employee;


public class B_02_02_RetiveWithCriteria {
public static void main(String[] args) {
	Configuration cfg = new Configuration().configure("/resources/hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	
	Criteria cr = session.createCriteria(Employee.class);
	
	//add() method available for criteria object to add restrivtion for a criteria query.
	//Restriction-1: To get records having salary more than 20000 ,less than 20000
	//cr.add(Restrctions.)
	
	//cr.add(Restrictions.gt("salary", 20000));
	//cr.add(Restrictions.lt("salary", 20000));
	
	  List results = cr.list();
	 System.out.println("Employee Details");
	 
	 for(Iterator iterator = results.iterator();iterator.hasNext();){
		 Employee emp =  (Employee) iterator.next();
		 System.out.println("First Name" + emp.getFirstName());
		 System.out.println("last Name" + emp.getLastName());
		 System.out.println("First Name" + emp.getSalary());
	 }
	 
	 session.close();
	 System.out.println("Success");


}
}