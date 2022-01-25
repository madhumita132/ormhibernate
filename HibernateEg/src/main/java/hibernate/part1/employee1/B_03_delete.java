package hibernate.part1.employee1;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class B_03_delete {
	public static void main(String args[])
	{
	
	    
		Configuration cfg = new Configuration();
		cfg.configure("/resources/hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		String hql="DELETE FROM Employee where first_name= :fNameKey";
		
		Query query=session.createQuery(hql);
		query.setParameter("fNameKey","vikky");

		int result=query.executeUpdate();
		
		tx.commit();
		
	}
}

