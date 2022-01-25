package training.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.EmployeeBean;
import com.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapper {
@Autowired
private EmployeeDAO dao;

public Integer saveEmployee(EmployeeBean employeeBean) {
	EmployeeEntity employeeEntity = new EmployeeEntity();
	
	//converting bean to entity
	BeanUtils.copyProperties(employeeBean, employeeEntity);
	
	//inserting the entity into table
	EmployeeEntity en = dao.save(employeeEntity);
	
	return en.getEmployeeId();
}
}