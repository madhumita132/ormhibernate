package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.EmployeeBean;

import training.dao.EmployeeDAOWrapper;



@Service
public class EmployeeServiceImpl implements EmployeeService{
	 @Autowired
	 private EmployeeDAOWrapper employeeDAOWrapper;
	 
	 public int addEmployee(EmployeeBean employee) throws Exception{
		 int result = employeeDAOWrapper.saveEmployee(employee);
		 return result;
		 
}

}