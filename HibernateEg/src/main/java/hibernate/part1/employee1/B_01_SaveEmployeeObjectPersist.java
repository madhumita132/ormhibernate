package hibernate.part1.employee1;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import hibernate.part.employee.Employee;


public class B_01_SaveEmployeeObjectPersist {
public static void main(String[] args) {
	//Need this hibernate configuration object to print the hibernate.cfg.xml file
	Configuration cfg = new Configuration();
	//Configuration is set as per the database details mentioned in this file
	cfg.configure("/resources/hibernate.cfg.xml");
	
	
	//SessionFactory object creation through configuration
	SessionFactory factory = cfg.buildSessionFactory();
	
	//Here, session is used to get a physical connection with database as configured in factory object.
	//The session object is lightweight and designed to be instantiated each time an interaction is needed with db
	
	Session session = factory.openSession();
	
	//Begin Transaction related to an unit of data operation and return the associated transaction object.
	Transaction tx = session.beginTransaction();
	
	Employee empl =  new Employee();
	empl.setFirstName("madhu");
	empl.setLastName("mita");
	empl.setSalary(25000);
	
	//committing transaction. it is mandatory for DML opeartions
	
	tx.commit();
	
	//closing session object
	
	session.close();
	factory.close();
	
}
}