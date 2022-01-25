package trainig.jpa.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Ex_04_JPQL_Demo {
	public static void main(String args[]) {
		// EntityManagerFactory object creation
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Jpa");

		// EntityManager object creation
		EntityManager entitymanager = emfactory.createEntityManager();

		// Query object is used to store the returned values of SQL like resultset in
		// JDBC scalar function
		Query query1 = entitymanager.createQuery("SELECT UPPER(t1.traineeName) From Trainee t1");
		List<String> list = query1.getResultList();// fetch multiple records

		for (String tNames : list) {
			System.out.println("Trainee Name: " + tNames);

		}
		// Aggregate function

		Query query2 = entitymanager.createQuery("SELECT MIN(t1.salary) FROM Trainee t1");
		Double result = (Double) query2.getSingleResult(); // fetching single value
		System.out.println("Minimum Trainee salary: " + result);
	}

}