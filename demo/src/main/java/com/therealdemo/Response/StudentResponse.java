package com.therealdemo.Response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.therealdemo.entity.Student;
import com.therealdemo.entity.Subject;
import com.therealdemo.Response.SubjectResponse;

public class StudentResponse {

	@JsonIgnore
	private long id;
	@JsonProperty("first_name")
	private String firstName;
	private String lastName;
	private String email;
	private String fullName;
	private String street;
	private String city;
	
	private List<SubjectResponse> learningSubjects;
	
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
	public StudentResponse(long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	public StudentResponse (Student student)
	{
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.email=student.getEmail();
		this.fullName=student.getFullName();
		this.city=student.getAddress().getCity();
		this.street=student.getAddress().getStreet();
		//if(student.getLearningSubjects()!=null)
	//	{
			this.learningSubjects=new ArrayList<SubjectResponse>();
			for (Subject subject: student.getLearningSubjects()) 
			{
				this.learningSubjects.add(new SubjectResponse(subject));
			}
	//	}
		
		
		
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
