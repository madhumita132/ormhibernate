package training.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.EmployeeEntity;

import buisness.bean.EmployeeBean;


@Repository
@SuppressWarnings("unchecked")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	//To convert from bean object to entity object.
	public static EmployeeEntity convertBeanToEntity(EmployeeBean empBean)
	{
		EmployeeEntity employeeEntityObj = new EmployeeEntity();
		
		//Logic to convert from BeanObj to EntityObj
		BeanUtils.copyProperties(empBean, employeeEntityObj);
		return employeeEntityObj;
		
	}

	//Add Employee  - data operation
	//JPA needs the entity object to be performed for DAO operation, but spring framework will transfer
	//the data to JPA in the form of bean, so we need a logic which will convert bean format entity format
	@Override
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		
		System.out.println("DAO implementation class completed the addEmployee operation and returns the ID");
		EmployeeEntity empEntity = convertBeanToEntity(employeeBean);
		
		EntityManager entityManager = null;
		Integer employeeId = 0;
		
		//Step 1 : Create Entity Manager
		//Step 2 : beginning the transaction
		//Step 3 : perform Core DAO Operation - addingEmployee
		//Step 4 : Commit the transaction.
		//Step 5 : Closing the transaction realted objects.
		
		try
		{
			
		    entityManager = entityManagerFactory.createEntityManager();	//create Entity Manager
		    entityManager.getTransaction().begin(); //beginning the transaction
		    //Here the persist() will convert your emp entity obj into table record to be inserted
		    entityManager.persist(empEntity);
		    
		    entityManager.getTransaction().commit(); // committing the current transaction
		    
		    employeeId = empEntity.getId();
		    
		}catch(Exception exception)
		{
			throw exception;
		}
		finally
		{
			if(entityManager != null) {
			entityManager.close();
			}
		}
		System.out.println("DAO implementation class completed the addEmployee operation and returns the ID");
	return employeeId;
				
	}
	
	public static EmployeeBean convertEntityToBean(EmployeeEntity empEntity) {
		
		EmployeeBean employeeBeanObj = new EmployeeBean();
		BeanUtils.copyProperties(empEntity, employeeBeanObj);
		
		return employeeBeanObj;
	}
	
	
	public List<EmployeeBean> getEmployeeDetailsList() throws Exception {
		
		  //The common steps to follow to define your DAO - operation
		  //Step 1 : Create Entity Manager Factory
		  //Step 2 :Create Entity Manager
	      //Step 3 : beginning the transaction
		  //Step 4 : perform Core DAO Operation - fetching all employee records
		  //Step 5 : Commit the transaction.
		  //Step 6 : Closing the transaction related objects.
		
		EntityManager entityManager = null;
		List<EmployeeBean> listEmployeeBean = null;
		
		try 
		{
		entityManager=entityManagerFactory.createEntityManager(); //create Entity Manager
		entityManager.getTransaction().begin(); //beginning the transaction
		listEmployeeBean=new ArrayList<EmployeeBean>();
		List<EmployeeEntity> listEmpEntity = (List<EmployeeEntity>) 
				entityManager.createQuery("FROM EmployeeEntity").getResultList();
		
		//Here, note that the query executed and returned list values will be in entity object type.
		//Because JPA entity manager will deal with only entity type.
		
		//List<EmployeeBean> ListEmployeeBean = null;
		for(EmployeeEntity empentity :listEmpEntity)
		{
			//To convert from entity object to bean object. 
			EmployeeBean empBean = convertEntityToBean(empentity);
			listEmployeeBean.add(empBean); //Adding empBean object into List for each iteration
		}
		
		} catch(Exception exception)
		{
			throw exception;
		}
		finally
		{
			if(entityManager != null) {
				entityManager.close();
				}
			
		}
		System.out.println("DAO implementation class completed the addEmployee operation and returns the ID");
		
		return listEmployeeBean;
		
	}

public EmployeeBean getEmployeeDetailsById(Integer id) throws Exception {
		
		System.out.println("DAO implementation class is invoked for getEmployeeDetailsById ");
		 //The common steps to follow to define your DAO - operation
		  //Step 1 : Create Entity Manager Factory
		  //Step 2 :Create Entity Manager
	      //Step 3 : beginning the transaction
		  //Step 4 : perform Core DAO Operation - fetching all employee records
		  //Step 5 : Commit the transaction.
		  //Step 6 : Closing the transaction related objects.
		
		EntityManager entityManager = null;
		EmployeeBean employeeBean = null;
		
		try 
		{
			
		    entityManager = entityManagerFactory.createEntityManager(); //create Entity Manager
		    entityManager.getTransaction().begin(); //beginning the transaction
		
		    //find() will return the entity object based on primary key
		    EmployeeEntity employeeEntity = entityManager.find(EmployeeEntity.class, id); 
		    
		    if(employeeEntity != null)
		    {
		    	employeeBean = convertEntityToBean(employeeEntity);
		    		
		    		
		    }
		
		}catch(Exception exception)
		{
			throw exception;
		}
		finally
		{
			if(entityManager != null) 
			{
				entityManager.close();
			}
			
		}
		System.out.println("DAO implementation class completed the getEmployeeDetailsById "
				+ "operation and returns the employeeBean object");
			
		return employeeBean;
	}

//Passing bean object as argument in which the new values to be updated
	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean1) throws Exception
	{
		EntityManager entityManager = null;
		EmployeeBean employeeBean2 = null;
		
		try 
		{
			
		    entityManager = entityManagerFactory.createEntityManager(); //create Entity Manager
		   
		    //find the object of the entity class where update has to happen
		    //This can be checked by fetching the id of bean object in which we have the details to be updated on
		    //the entity object
		    //find() will return the entity object based on primary key
		    EmployeeEntity employeeEntity = (EmployeeEntity) entityManager.find(EmployeeEntity.class, employeeBean1.getId()); 
		  
		    
		    if(employeeEntity != null)
		    {
		    	entityManager.getTransaction().begin(); //beginning the transaction
		    	
		    	//set the new values to the entity which is fetched(using get) from bean object
		    	employeeEntity.setInsertTime(new Date());
		    	employeeEntity.setName("Michael");
		    	employeeEntity.setRole("HR");
		    	employeeEntity.setSalary(70000.0);
		    	
		    	employeeBean2 = convertEntityToBean(employeeEntity);
		    	
		    	entityManager.getTransaction().commit();
		   		    		
		    }
		
		}catch(Exception exception)
		{
			throw exception;
		}
		finally
		{
			if(entityManager != null) 
			{
				entityManager.close();
			}
			
		}
		System.out.println("DAO implementation class completed the getEmployeeDetailsById "
				+ "employee details are updated .");
			
		return employeeBean2;
	}
	
	public EmployeeBean deleteEmployeeDetails(Integer id) throws Exception {
	EmployeeBean employeeBean = null;
	EntityManager entityManager = null;
	try {
		entityManager = entityManagerFactory.createEntityManager();
		EmployeeEntity employeeEntity = (EmployeeEntity)entityManager.find(EmployeeEntity.class,  id);
		
		if(employeeEntity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(employeeEntity);
			entityManager.getTransaction().commit();
			employeeBean = convertEntityToBean(employeeEntity);
		}
	}
	catch (Exception exception) {
		throw exception;
	}
	finally {
		if(entityManager != null) {
			entityManager.close();
	}
	}
	return employeeBean;
	}

	}





	
