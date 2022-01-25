package buisness.bean;

import java.util.Date;

public class EmployeeBean {
private Integer id;
private String name;
private String role;
private Date insertTime;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public Date getInsertTime() {
	return insertTime;
}
public void setInsertTime(Date insertTime) {
	this.insertTime = insertTime;
}
@Override
public String toString() {
	return "EmployeeBean [id=" + id + ", name=" + name + ", role=" + role + "]";
}

}
