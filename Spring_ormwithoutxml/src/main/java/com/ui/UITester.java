package com.ui;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.main.SpringMainConfig;

import buisness.bean.EmployeeBean;
import traing.service.EmployeeService;

@SuppressWarnings("resource")
public class UITester {

	// Step 1 : Load the application context xml file through application context
	// object
	// Step 2 : Object creation for bean entries through getBean() which are
	// available in the application context file.
	//
	public static void main(String[] args) {

		EmployeeService employeeService = null;

		try {
			//ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					//"training/resources/spring_appcontent_main_config.xml");
			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringMainConfig.class);
			// object creation for service implementation class; getBean() will autowire the
			// service implementation class
			employeeService = (EmployeeService) applicationContext.getBean("employeeServiceImpl");

			// 1 - Add Employee
			addEmployee(employeeService);
			//2-
			//getAllEmployeeDetails(employeeService);
			//3-fetch employee using id
			//getEmployeeDetailsById(employeeService);
             //4-update employee
			//updateEmployeeDetails(employeeService);
			//4-delete employee
			//deleteEmployeeDetails(employeeService);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Assigning values to employeeBean object and to trigger the
	// serviceImplementation class addEmployee()
	public static void addEmployee(EmployeeService empServiceImpl) {
		EmployeeBean empBeanObj = new EmployeeBean();
		empBeanObj.setName("abi");
		empBeanObj.setRole("GET");
		empBeanObj.setInsertTime(new Date());
		//empBeanObj.setSalary(50000);

		// Invoking addEmployee() of service implementation class
		try {
			int returnedEmpId = empServiceImpl.addEmployee(empBeanObj);
			System.out.println("Employee Registered Successfully : " + returnedEmpId);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	/*public static void getAllEmployeeDetails(EmployeeService empServiceImpl) {

		try {
			List<EmployeeBean> employeeBeanObj = empServiceImpl.getAllEmployeeList();
			for(EmployeeBean empBeanList:employeeBeanObj) {
				//prints the element of empBeanList object 
				System.out.println(empBeanList);//EmployeeBean class is overriden with toString()
			}
		} 
		catch (Exception e) {
System.out.println(e.getMessage());		
}
	}
	
	//fetch employee details based on ID
	public static void getEmployeeDetailsById(EmployeeService empServiceImpl) {
			{
				try
				{
					EmployeeBean employeeBean = empServiceImpl.getEmployeeDetailsById(3);
					if(employeeBean == null)
					{
						System.out.println("Invalid Employee ID");
					}
					else
					{
						System.out.println("******** Employee Details ********");
						System.out.println("Name : " + employeeBean.getName());
						//System.out.println("Salary : " + employeeBean.getSalary());
						System.out.println("Role : " + employeeBean.getRole());
					}
					
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
			}
	}
			public static void updateEmployeeDetails(EmployeeService serviceImpl){
				try {
					EmployeeBean foundEmployeeBean = serviceImpl.getEmployeeDetailsById(4);
					if(foundEmployeeBean == null)
					{
						System.out.println("Invalid Employee ID");
					}
					else
					{
						//foundEmployeeBean.setSalary(75000.5);
						//foundEmployeeBean.setName("abi");
						//foundEmployeeBean.setName("managerr");
						EmployeeBean updatedBean = serviceImpl.updateEmployeeDetails(foundEmployeeBean);
						System.out.println("******** Updated Employee Details ********");
						System.out.println("Name : " + updatedBean.getName());
						//System.out.println("Salary : " + employeeBean.getSalary());
						System.out.println("Role : " + updatedBean.getRole());
					}
				}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				
			}
			
		
			public static void deleteEmployeeDetails(EmployeeService empServiceImpl1) {
				{
					try
					{
						EmployeeBean employeeBean = empServiceImpl1.getEmployeeDetailsById(2);
						if(employeeBean == null)
						{
							System.out.println("Invalid Employee ID");
						}
						else
						{
							System.out.println("********  deleted Employee Details ********");
							System.out.println("Name : " + employeeBean.getId());
							//System.out.println("Salary : " + employeeBean.getSalary());
							System.out.println("Role : " + employeeBean.getRole());
						}
						
					}catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					}
					}*/
					

				
			}

