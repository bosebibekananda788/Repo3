package com.therealdemo.Response;

import com.therealdemo.entity.Subject;

public class SubjectResponse {
	
	private Long id;
	private String subjectName;
	private Double marksObtained;
	
	public SubjectResponse() {}
	
	public SubjectResponse(Subject subject)
	{
		this.id=subject.getId();
		this.subjectName=subject.getSubjectName();
		this.marksObtained=subject.getMarksObtained();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Double getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Double marksObtained) {
		this.marksObtained = marksObtained;
	}

}
