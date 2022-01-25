package traing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import buisness.bean.EmployeeBean;
import training.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	//DAO operations can be used inside service implementations
	@Autowired
	
	private EmployeeDAO employeeDAO;
	
	public Integer addEmployee(EmployeeBean employeeBean) throws Exception{
		
		System.out.println("Employee service implementation class is invoked to perform employee insertion");//business logic layer
		//buisness logic layer
		return employeeDAO.addEmployee(employeeBean); //it returns employeeId
	}
	
	/*
	 * public List<EmployeeBean> getAllEmployeeList() throws Exception{ System.out.
	 * println("Employee service implementation class is invoked to fetch employee records"
	 * ); return employeeDAO.getEmployeeDetailsList();//DAO operation injection in
	 * sevice layer }
	 * 
	 * @Override public EmployeeBean getEmployeeDetailsById(Integer id) throws
	 * Exception{
	 * 
	 * System.out.
	 * println("Employee service implementation class is invoked to fetch particular id record"
	 * ); EmployeeBean empBeanObj=employeeDAO.getEmployeeDetailsById(id);
	 * 
	 * if(empBeanObj==null) { throw new InvalidEmployeeIdException(); }
	 * 
	 * return empBeanObj; }
	 * 
	 * @Override public EmployeeBean updateEmployeeDetails(EmployeeBean
	 * employeeBean) throws Exception{ System.out.
	 * println("Employee serviceis invoked to using update employeedetailsdao operation"
	 * ); //DAO injection in setrvicwe layer EmployeeBean
	 * emp=employeeDAO.updateEmployeeDetails(employeeBean); return emp; } public
	 * EmployeeBean deleteEmployeeDetails(Integer id) throws Exception{ System.out.
	 * println("Employee serviceis invoked to using delete employeedetails dao operation"
	 * ); //DAO injection in service layer EmployeeBean
	 * emp=employeeDAO.deleteEmployeeDetails(id); return emp; }
	 */
}