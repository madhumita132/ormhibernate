package traing.service;

import java.util.List;

import buisness.bean.EmployeeBean;

//this is service layer interface
	public interface EmployeeService{
		//This is the businesslogic/service we want to execute through spring framework
		//And this service method can inject DAO operation methods inside its service implementation if required.
		Integer addEmployee(EmployeeBean employeeBean)throws Exception;
		//List<EmployeeBean> getAllEmployeeList() throws Exception;
		//this service layer is going to use DAO which fetch employee details from employee entity
		//EmployeeBean getEmployeeDetailsById(Integer id) throws Exception;
		//This service layer is going to use DAO which fetches the employee details from employee entity based on given Employee Id
	   //EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean1) throws Exception;
	//this layer is use DAO which updates emp details to an employee entity based on
	   //giv3n emp id bean obj
	   //EmployeeBean deleteEmployeeDetails(Integer id) throws Exception;
		//This service layer is going to use DAO which deletes the employee details from employee entity based on given Employee Id
	}