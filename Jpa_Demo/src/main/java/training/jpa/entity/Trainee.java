package training.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Trainee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // remove if it not to be auto generated one
	private int traineeid;
	@Column
	private String traineeName;
	@Column
	private double salary;
	@Column
	private String deg;

	public Trainee(int traineeid, String traineeName, double salary, String deg) {
		// super();
		this.traineeid = traineeid;
		this.traineeName = traineeName;
		this.salary = salary;
		this.deg = deg;
	}
	

	public Trainee() {
		//super();
	}


	@Override
	public String toString() {
		return "Trainee [traineeid=" + traineeid + ", traineeName=" + traineeName + ", salary=" + salary + ", deg="
				+ deg + "]";
	}


	public int getTraineeid() {
		return traineeid;
	}

	public void setTraineeid(int traineeid) {
		this.traineeid = traineeid;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}
}