package traing.service;

import java.util.List;


import buisness.bean.StudentBean;

//this is service layer interface
	public interface EmployeeService{
		
		Integer addEmployee(StudentBean employeeBean)throws Exception;
		List<StudentBean> getAllEmployeeList() throws Exception;
		
		StudentBean getEmployeeDetailsById(Integer id) throws Exception;
		
		StudentBean updateEmployeeDetails(StudentBean employeeBean1) throws Exception;
	
		StudentBean deleteEmployeeDetails(Integer id) throws Exception;
		
	}