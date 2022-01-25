package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.EmployeeService;


@RestController

//it extends @controller and object can be automatially converted to other formats ike json,xml,text

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
@RequestMapping(value ="/emp/contoller/addEmp",method = RequestMethod.POST,
consumes = MediaType.APPLICATION_JSON_VALUE,
produces = MediaType.TEXT_HTML_VALUE)

public ResponseEntity<String> addEmployee(@RequestBody EmployeeBean employeebean ) throws Exception{
int id = employeeService.addEmployee(employeebean);
	return new ResponseEntity<String>("Employee addes with id " +id,HttpStatus.CREATED);
}
}