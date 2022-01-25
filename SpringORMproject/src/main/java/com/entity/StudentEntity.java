package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Student")
public class StudentEntity {
//the @GeneratedValue annotation is to configure the way the way of increment of the specified column(field).
	//For example when using Mysql, you may specify auto_increment in the definition of table to make it self-increment
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer StudentAge;
	private String StudentName;
	private String Standard;
	private Integer Contact;

	@Column(name="JoinedDate")
	@Temporal(TemporalType.DATE)
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

	

	
}
