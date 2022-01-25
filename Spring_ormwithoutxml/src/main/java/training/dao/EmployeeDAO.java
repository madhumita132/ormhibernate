package training.dao;

import buisness.bean.EmployeeBean;
import java.util.List;



//The Data Access Object (DAO) is one of the best practice that allows us to isolate the
//application/business logic layer from the persistence layer (usually a relational database).

public interface EmployeeDAO {
	
	//DAO - Visualization - 1 : adding an employee bean object into the employee entity and returning its id
	Integer addEmployee(EmployeeBean employeeBean) throws Exception;
	
	//DAO - Visualization - 2 : returning list of employee bean objects added in the entity
	//List<EmployeeBean>getEmployeeDetailsList() throws Exception;
	
	//DAO - Visualization - 3 : returning employee bean based on employee id
	//EmployeeBean getEmployeeDetailsById(Integer id) throws Exception;
	
	//EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception;
	//1.pass the bean object which has the details to be updated in entity object.
	//2. update to be done in the entity through bean object.
	//3.convert from the bean to entity
	//4.return the updated object in the bean format.

	//EmployeeBean deleteEmployeeDetails(Integer id) throws Exception;
}