package hibernate.part2.annotation;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//In general entity is an object that has some distinct value.
//In a persistent storage mechanism, an entity is a business object. Each entity
//has an associated table in relational database. Each instance of the entity 
//represents a row of the table. Entity class is an annotated POJO (plain old java object)

@Entity
@Table
//@Table(name="employee_annotation")
public class EmployeeAnnotationEntity {

	@Id //to make primary key
	private int id;
	@Column
	private String firstName;
	@Column
	String lastName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}