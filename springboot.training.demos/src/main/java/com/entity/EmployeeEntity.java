package com.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeEntity {
	
	@Column(name="employeename")
	private String employeeName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employeeid")
	private Integer employeeId;
	
	@Column(name="salary")
	private double salary;
	
	@Column(name="departmentcode")
	private Integer departmentCode;

	public EmployeeEntity() {
		super();
public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Integer getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(Integer departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeId="
				+ employeeId + ", salary=" + salary + ", departmentCode="+ departmentCode + "]";
	}
}
