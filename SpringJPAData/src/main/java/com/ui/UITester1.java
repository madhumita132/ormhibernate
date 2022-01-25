package com.ui;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.EmployeeDAO;
import com.entity.EmployeeEntityBean;


public class UITester1 {

	public static void main(String[] args) {
		
		EmployeeDAO employeeDAOIMPL = null;
		
		try
		{
		ApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("com/resource/jpa_spring1.xml");
		employeeDAOIMPL = (EmployeeDAO) applicationContext.getBean("employeeDAO");
		
		//1 - Add Employee
		//addEmployee(employeeDAOIMPL);
		getEmployeeDetails(employeeDAOIMPL);
		updateEmployeeDetails(employeeDAOIMPL);
		deleteEmployeeDetails(employeeDAOIMPL);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	

}

private static void updateEmployeeDetails(EmployeeDAO daoimpl1) {
	try{
	EmployeeEntityBean foundEmployeeBean = daoimpl1.findOne(1);
	if(foundEmployeeBean == null)
	{
		System.out.println("Invalid Employee ID");
	}
	else
	{
		foundEmployeeBean.setSalary(75000.5);
		foundEmployeeBean.setName("abi");
		foundEmployeeBean.setRole("managerr");
		EmployeeEntityBean updatedBean =  daoimpl1.save(foundEmployeeBean);
		System.out.println("******** Updated Employee Details ********");
		System.out.println("Name : " + updatedBean.getName());
		System.out.println("Salary : " + updatedBean.getSalary());
		System.out.println("Role : " + updatedBean.getId());
		System.out.println("Role : " + updatedBean.getInsertTime());
	}
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}

		
	}
public static void getEmployeeDetails(EmployeeDAO daoimpl) {
	try{
		EmployeeEntityBean employeeEntityBean = daoimpl.findOne(5);
		//daoimpl.findOne(5); //find all emp details
		if(employeeEntityBean == null)
	{
		System.out.println("Invalid Employee ID");
	}
	else
	{
		System.out.println("******** Employee Details ********");
		System.out.println("Name : " + employeeEntityBean.getName());
		System.out.println("Salary : " + employeeEntityBean.getSalary());
		System.out.println("Role : " + employeeEntityBean.getRole());
	}
	
}catch(Exception e)
{
	System.out.println(e.getMessage());
}
	}



	public static void addEmployee(EmployeeDAO daoimpl) {
	
		EmployeeEntityBean bean = new EmployeeEntityBean();
		bean.setName("madhu");
		bean.setRole("GET");
		bean.setInsertTime(new Date());
		bean.setSalary(50000.00);
		
		
		try
		{
			//result has the auto-generated id
			EmployeeEntityBean result = daoimpl.save(bean);
		    int id = result.getId();
		    System.out.println("Employee Registered Successfully : " + id);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void deleteEmployeeDetails(EmployeeDAO daoimpl) {
		try
		{
			EmployeeEntityBean employeeEntityBean = daoimpl.findOne(3);
			if(employeeEntityBean == null)
			{
				System.out.println("Invalid Employee ID");
			}
			else
			{
				daoimpl.delete(employeeEntityBean);
				System.out.println("********  deleted Employee Details ********"+employeeEntityBean.getId());
				System.out.println("Name : " + employeeEntityBean.getId());
				System.out.println("Salary : " + employeeEntityBean.getSalary());
				System.out.println("Role : " + employeeEntityBean.getRole());
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
			
		}
		
}