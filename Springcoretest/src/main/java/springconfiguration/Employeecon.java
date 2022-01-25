package springconfiguration;

public class Employeecon {
	private Addresscon address;

	private Integer employeeId;

	private Double salary;

	private String employeeName;


	public Employeecon() {
		System.out.println("From Constructor of Employee: Created the Employee Object and injected the Address Object\n");
	}
public Addresscon getAddress() {
	return address;
}
	public void setAddress(Addresscon address) {
		System.out.println(".......................From Setter of Address....");
		this.address = address;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		System.out.println("FRom setter of EmployeeId");
		this.employeeId = employeeId;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		System.out.println("From setter of Salary");
		this.salary = salary;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void display() {
		System.out.println("\nEmployee Details are:");
		System.out.println("Employee ID:" + this.employeeId);
		System.out.println("Employee Salaray:" + this.salary);
		System.out.println("Emloyee Name: " + this.employeeName);
		System.out.println("\nAddress line1:" + this.address.getAddress1());
		System.out.println("Address line2:" + this.address.getAddress2());
	}
}
