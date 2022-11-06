package com.therealdemo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.therealdemo.Request.CreateStudentRequest;

@Entity 
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue//(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private long  id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	@OneToOne
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(mappedBy="student")
	private List<Subject> learningSubjects;
	
	@Transient
	private String fullName;
	
	
	public List<Subject> getLearningSubjects() {
		return learningSubjects;
	}

	public void setLearningSubjects(List<Subject> learningSubjects) {
		this.learningSubjects = learningSubjects;
	}

	protected Student() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	public Student (CreateStudentRequest createStudentRequest)
	{
		this.firstName=createStudentRequest.getFirstName();
		this.lastName=createStudentRequest.getLastName();
		this.email=createStudentRequest.getEmail();
		this.fullName=createStudentRequest.getFirstName()+" "+createStudentRequest.getLastName();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
}
