package com.therealdemo.Request;

import javax.validation.constraints.NotNull;

public class UpdateStudentRequest {

	@NotNull(message="Student id is required")
    private Long id;	
	private String firstName;
	private String lastName;
	private String email;
	
	protected UpdateStudentRequest() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	
}
