
package trainig.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.jpa.Trainee;



public class Ex_02_FindTrainee 
{
	public static void main(String[] args)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Jpa");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		
		//find will find the records
		Trainee s=em.find(Trainee.class,1);
		 s.setTraineeName("Madhu");
		    s.setSalary(85000);
		    s.setDeg("GET");
		    
		    em.persist(s);
		    em.getTransaction().commit();
		    
		   em.close();
		
		//System.out.println("TraineeId="+s.getTraineeId()+"TraineeName "+s.getTraineeName());
		//System.out.println("Trainee salary="+s.getSalary());
		//System.out.println("Trainee Designation="+s.getDeg());
		
	}

};
