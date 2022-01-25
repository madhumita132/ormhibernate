package hibernate.part1.employee1;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class B_03_UpdateEmployeeObject {
	public static void main(String args[]) {

		Configuration cfg = new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String up1 = "UPDATE Employee set first_name = :fNameKey WHERE id = :idKey";

		Query query = session.createQuery(up1);
		query.setParameter("fNameKey", "Eric");
		query.setParameter(":idKey", 3);

//executeUpdate() returns the number of records affected
		int result = query.executeUpdate();
//commit() is mandate to update the change in the source table
		tx.commit();
		

	}

}