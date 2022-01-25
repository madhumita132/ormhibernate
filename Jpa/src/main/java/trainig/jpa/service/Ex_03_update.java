package trainig.jpa.service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.jpa.Trainee;

public class Ex_03_update {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Jpa");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		//find will find the records
		Trainee s=em.find(Trainee.class,2);
		 s.setTraineeName("naga");
		    s.setSalary(25000);
		    s.setDeg("GET");
		    
		    em.persist(s);
		    em.getTransaction().commit();
		    
		   em.close();
		
	}

}