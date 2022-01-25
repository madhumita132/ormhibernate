package buisness.bean;

import java.util.Date;

public class StudentBean {
	private Integer id;
private Integer StudentAge;
private String StudentName;
private String Standard;
private Integer Contact;
private Date JoinedDate;

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getStudentAge() {
	return StudentAge;
}

public void setStudentAge(Integer studentAge) {
	StudentAge = studentAge;
}

public String getStudentName() {
	return StudentName;
}

public void setStudentName(String studentName) {
	StudentName = studentName;
}

public String getStandard() {
	return Standard;
}

public void setStandard(String standard) {
	Standard = standard;
}

public Integer getContact() {
	return Contact;
}

public void setContact(Integer contact) {
	Contact = contact;
}

public Date getJoinedDate() {
	return JoinedDate;
}

public void setJoinedDate(Date joinedDate) {
	JoinedDate = joinedDate;
}

@Override
public String toString() {
	return "StudentBean [StudentAge=" + StudentAge + ", StudentName=" + StudentName + ", Standard=" + Standard
			+ ", Contact=" + Contact + ", JoinedDate=" + JoinedDate + "]";
}
}
