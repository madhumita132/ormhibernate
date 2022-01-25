package trainig.jpa.service;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.jpa.Trainee;

//java persistence API is a collection o classes and method to persistently store the vast amounts
//of data into a database provided by the oracle corporation
public class Ex_01_CreateTrainee{
	public static void main(String[] args) {
		System.out.println("the 'createEntityManagerFactory()' creates a persistence unit by providing the same unique name which we provided for persistence-unit in persistence.xml file.");
		
		EntityManagerFactory trfactory = Persistence.createEntityManagerFactory("Jpa");
		
		System.out.println("The object of 'EntityManagerFactory' will create the entitymanager instance by using 'createEntityManager() method");
		EntityManager entitymanager = trfactory.createEntityManager();
		
		System.out.println("the transaction starts");
		entitymanager.getTransaction().begin();
		
	    Trainee t1 = new Trainee();
	    //t1.settrainee(7050);
	    t1.setTraineeName("madhu");
	    t1.setSalary(20000);
	    t1.setDeg("GET");
	    
	    System.out.println("java object Persistence");
	    entitymanager.persist(t1);
	    
	    
	    System.out.println("Data transaction commit");
	    entitymanager.getTransaction().commit();
	    
	    entitymanager.close();
	    trfactory.close();
	    
	}

}