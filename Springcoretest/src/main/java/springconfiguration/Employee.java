package springconfiguration;

public class Employee {
	String empname;
	int empid;
	Address address;
	Integer phoneno;
	Double salary;

	public Employee(Address address) {
		this.address = address;
		System.out
				.println("From Constructor of Employee: Created the Employee Object and injected the Address Object\n");
		System.out.println("Constructor Autowiring injected the object n contruuctor as: [" + address + "]");
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		System.out.println("setter invoked by autowriting");
		this.address = address;
	}

	public Integer getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Integer phoneno) {
		this.phoneno = phoneno;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public void display() {
		System.out.println("\\nEmployee details:" + "\nemployee name:" + this.empname + "\\nemployee id" + this.empid);
		System.out.println("\nAddress1" + this.address.getAddress1() + "\nAddress2" + this.address.getAddress2());
		System.out.println("\nsalarry" + this.salary + "\nphoneno" + this.phoneno);
	}
}
