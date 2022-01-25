package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.entity.EmployeeEntityBean;

public interface EmployeeDAO extends CrudRepository<EmployeeEntityBean, Integer> {

	

}