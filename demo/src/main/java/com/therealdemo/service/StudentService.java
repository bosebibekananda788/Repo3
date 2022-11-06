package com.therealdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.therealdemo.Request.CreateStudentRequest;
import com.therealdemo.Request.CreateSubjectRequest;
import com.therealdemo.Request.InQueryRequest;
import com.therealdemo.Request.UpdateStudentRequest;
import com.therealdemo.entity.Address;
import com.therealdemo.entity.Student;
import com.therealdemo.entity.Subject;
import com.therealdemo.repository.AddressRepository;
import com.therealdemo.repository.StudentRepository;
import com.therealdemo.repository.SubjectRepository;

@Service
public class StudentService {

	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	
	AddressRepository addressRepository;
	
	@Autowired
	
	SubjectRepository subjectRepository;
	
	
	
	public List<Student> getAllStudents()
	{
		
		return studentRepository.findAll();
	}
	
	//CREATE STUDENT 
	
	public Student createStudent(CreateStudentRequest createStudentRequest) {
		
		Student student=new Student(createStudentRequest);
		Address address=new Address();
		address.setCity(createStudentRequest.getCity());
		address.setStreet(createStudentRequest.getStreet());
		
		address=addressRepository.save(address);
		student.setAddress(address);
		student=studentRepository.save(student);
		
		List<Subject> subjectsList=new ArrayList<Subject>();
		
		if(createStudentRequest.getSubjectsLearning()!=null)
		{
			for (CreateSubjectRequest createSubjectRequest:
				    createStudentRequest.getSubjectsLearning()) {
				Subject subject=new Subject();
				subject.setSubject(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				subjectsList.add(subject);
			}
				subjectRepository.saveAll(subjectsList);
		}
		student.setLearningSubjects(subjectsList);
		return student;
		
	}
	//update student 
	
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
		
		
    Student student=studentRepository.findById(updateStudentRequest.getId()).get();
    
    if (updateStudentRequest.getFirstName()!=null && !updateStudentRequest.getFirstName().isEmpty() )
    {
    	student.setFirstName(updateStudentRequest.getFirstName());
    	
    }
    
   student= studentRepository.save(student);
   return student;
    
    }
		
	
	public String deleteStudent(long id) {
		
		studentRepository.deleteById(id);
		
		return "student has been deleted";
		
	}
	
	
	public List<Student> getByFirstName(String firstName)
	{
		return studentRepository.findByFirstName(firstName);
		
	}
	
	/*
	public Student getByFirstNameAndLastName(String firstName,String lastName)
	{
		return studentRepository.findByFirstNameAndLastName(firstName,lastName);
		
	}
		*/
	
	
	public List <Student> getByFirstNameOrLastName(String firstName,String lastName)
	{
		//return studentRepository.findByFirstNameOrLastName(firstName,lastName);
		return studentRepository.getByFirstNameOrLastName(firstName,lastName);
		
	}
	
	public List <Student> getByFirstNameIn (InQueryRequest inQueryRequest)
	{
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
		
	}
	
	
	public List <Student> getAllStudentWithPagination(int pageNo, int pageSize)
	{
		
		PageRequest pageable=PageRequest.of(pageNo-1, pageSize);
		return studentRepository.findAll(pageable).getContent();
		
	}
	
	
	public Integer updateStudentWithJpql(Long id , String firstName)
	{
		
		return studentRepository.updateFirstName(id, firstName);
	}
	
	public Integer deleteStudentWithJpql(String firstName)
	{
		
		return studentRepository.deleteFirstName(firstName);
	}
	
	
	public List<Student> getByCity(String City)
	{
		//return studentRepository.findByAddressCity(City);
		return studentRepository.getByAddressCity(City);
	}
	
	
	}
	
	
	

