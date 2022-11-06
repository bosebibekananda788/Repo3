package com.therealdemo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.validation.constraints.NotBlank;

public class CreateStudentRequest {

	
	@JsonProperty("first_name")
	@NotBlank (message="First Name is required")
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	private String street;
	private List <CreateSubjectRequest> subjectsLearning;

	public List<CreateSubjectRequest> getSubjectsLearning() {
		return subjectsLearning;
	}
	public void setSubjectsLearning(List<CreateSubjectRequest> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
}
