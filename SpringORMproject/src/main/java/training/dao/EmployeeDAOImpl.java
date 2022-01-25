package training.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.entity.StudentEntity;


import buisness.bean.StudentBean;


@Repository
@SuppressWarnings("unchecked")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	//To convert from bean object to entity object.
	public static StudentEntity convertBeanToEntity(StudentBean empBean)
	{
		StudentEntity employeeEntityObj = new StudentEntity();
		
		//Logic to convert from BeanObj to EntityObj
		BeanUtils.copyProperties(empBean, employeeEntityObj);
		return employeeEntityObj;
		
	}

	//Add Employee  - data operation
	//JPA needs the entity object to be performed for DAO operation, but spring framework will transfer
	//the data to JPA in the form of bean, so we need a logic which will convert bean format entity format
	@Override
	public Integer addEmployee(StudentBean employeeBean) throws Exception {
		
		System.out.println("DAO implementation class completed the addEmployee operation and returns the ID");
		StudentEntity empEntity = convertBeanToEntity(employeeBean);
		
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
	
	public static StudentBean convertEntityToBean(StudentEntity empEntity) {
		
		StudentBean employeeBeanObj = new StudentBean();
		BeanUtils.copyProperties(empEntity, employeeBeanObj);
		
		return employeeBeanObj;
	}
	
	
	public List<StudentBean> getEmployeeDetailsList() throws Exception {
		
		  //The common steps to follow to define your DAO - operation
		  //Step 1 : Create Entity Manager Factory
		  //Step 2 :Create Entity Manager
	      //Step 3 : beginning the transaction
		  //Step 4 : perform Core DAO Operation - fetching all employee records
		  //Step 5 : Commit the transaction.
		  //Step 6 : Closing the transaction related objects.
		
		EntityManager entityManager = null;
		List<StudentBean> listEmployeeBean = null;
		
		try 
		{
		entityManager=entityManagerFactory.createEntityManager(); //create Entity Manager
		entityManager.getTransaction().begin(); //beginning the transaction
		listEmployeeBean=new ArrayList<StudentBean>();
		List<StudentEntity> listEmpEntity = (List<StudentEntity>) 
				entityManager.createQuery("FROM StudentEntity").getResultList();
		
		//Here, note that the query executed and returned list values will be in entity object type.
		//Because JPA entity manager will deal with only entity type.
		
		//List<EmployeeBean> ListEmployeeBean = null;
		for(StudentEntity empentity :listEmpEntity)
		{
			//To convert from entity object to bean object. 
			StudentBean empBean = convertEntityToBean(empentity);
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

public StudentBean getEmployeeDetailsById(Integer id) throws Exception {
		
		System.out.println("DAO implementation class is invoked for getEmployeeDetailsById ");
		 //The common steps to follow to define your DAO - operation
		  //Step 1 : Create Entity Manager Factory
		  //Step 2 :Create Entity Manager
	      //Step 3 : beginning the transaction
		  //Step 4 : perform Core DAO Operation - fetching all employee records
		  //Step 5 : Commit the transaction.
		  //Step 6 : Closing the transaction related objects.
		
		EntityManager entityManager = null;
		StudentBean employeeBean = null;
		
		try 
		{
			
		    entityManager = entityManagerFactory.createEntityManager(); //create Entity Manager
		    entityManager.getTransaction().begin(); //beginning the transaction
		
		    //find() will return the entity object based on primary key
		    StudentEntity employeeEntity = entityManager.find(StudentEntity.class, id); 
		    
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
	public StudentBean updateEmployeeDetails(StudentBean employeeBean1) throws Exception
	{
		EntityManager entityManager = null;
		StudentBean employeeBean2 = null;
		
		try 
		{
			
		    entityManager = entityManagerFactory.createEntityManager(); //create Entity Manager
		   
		    //find the object of the entity class where update has to happen
		    //This can be checked by fetching the id of bean object in which we have the details to be updated on
		    //the entity object
		    //find() will return the entity object based on primary key
		    StudentEntity employeeEntity = (StudentEntity) entityManager.find(StudentEntity.class, employeeBean1.getId()); 
		  
		    
		    if(employeeEntity != null)
		    {
		    	entityManager.getTransaction().begin(); //beginning the transaction
		    	
		    	//set the new values to the entity which is fetched(using get) from bean object
		    	employeeEntity.setStudentName("abi");
		    	employeeEntity.setStudentAge(20);
		    	employeeEntity.setJoinedDate(new Date());
		    	employeeEntity.setContact(701021280);
		    	
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
	
	public StudentBean deleteEmployeeDetails(Integer id) throws Exception {
		StudentBean employeeBean = null;
	EntityManager entityManager = null;
	try {
		entityManager = entityManagerFactory.createEntityManager();
		StudentEntity employeeEntity = (StudentEntity)entityManager.find(StudentEntity.class,  id);
		
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





	
