package com.ui;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import buisness.bean.StudentBean;
import traing.service.EmployeeService;


@SuppressWarnings("resource")
public class UITester {

	public static void main(String[] args) {

		EmployeeService employeeService = null;

		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
					"training/resources/spring_appcontent_main_config.xml");

			
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
		StudentBean empBeanObj = new StudentBean();
		empBeanObj.setStudentName("madhu");
		empBeanObj.setStudentAge(20);
		empBeanObj.setJoinedDate(new Date());
		empBeanObj.setContact(701021280);
		empBeanObj.setStandard("ug");
		// Invoking addEmployee() of service implementation class
		try {
			int returnedEmpId = empServiceImpl.addEmployee(empBeanObj);
			System.out.println("Employee Registered Successfully : " + returnedEmpId);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void getAllEmployeeDetails(EmployeeService empServiceImpl) {

		try {
			List<StudentBean> employeeBeanObj = empServiceImpl.getAllEmployeeList();
			for(StudentBean empBeanList:employeeBeanObj) {
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
					StudentBean employeeBean = empServiceImpl.getEmployeeDetailsById(3);
					if(employeeBean == null)
					{
						System.out.println("Invalid Employee ID");
					}
					else
					{
						System.out.println("******** Employee Details ********");
						System.out.println("Name : " + employeeBean.getStudentName());
						System.out.println("Contact: " + employeeBean.getContact());
						System.out.println("JoinedDate : " +employeeBean.getJoinedDate());
						System.out.println("JoinedDate : " + employeeBean.getStudentAge());			
					}	
				}catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
			}
	}
			public static void updateEmployeeDetails(EmployeeService serviceImpl){
				try {
					StudentBean foundEmployeeBean = serviceImpl.getEmployeeDetailsById(4);
					if(foundEmployeeBean == null)
					{
						System.out.println("Invalid Employee ID");
					}
					else
					{
						//foundEmployeeBean.setSalary(75000.5);
						//foundEmployeeBean.setName("abi");
						//foundEmployeeBean.setName("managerr");
						StudentBean updatedBean = serviceImpl.updateEmployeeDetails(foundEmployeeBean);
						System.out.println("******** Updated Employee Details ********");
						System.out.println("Name : " + updatedBean.getStudentName());
						//System.out.println("Salary : " + employeeBean.getSalary());
						System.out.println("Age: " + updatedBean.getStudentAge());
						
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
						StudentBean employeeBean = empServiceImpl1.getEmployeeDetailsById(2);
						if(employeeBean == null)
						{
							System.out.println("Invalid Employee ID");
						}
						else
						{
							System.out.println("********  deleted Employee Details ********");
							System.out.println("Id: " + employeeBean.getId());
							System.out.println("StudentName : " + employeeBean.getStudentName());
							System.out.println("Standard : " + employeeBean.getStandard());
						}
						
					}catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					

				}
			}
}
