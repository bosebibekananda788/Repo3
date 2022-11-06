package com.therealdemo.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.therealdemo.Request.CreateStudentRequest;
import com.therealdemo.Request.InQueryRequest;
import com.therealdemo.Request.UpdateStudentRequest;
import com.therealdemo.Response.StudentResponse;
import com.therealdemo.entity.Student;
import com.therealdemo.service.StudentService;

@RestController
@RequestMapping ("/api/student/")
public class StudentController {
	
	Logger logger =LoggerFactory.getLogger(StudentController.class);

	@Autowired
	StudentService studentService;
	
	@GetMapping("/getAll")
	public List <StudentResponse> getStudent() {
		logger.error("Inside Error");
		logger.warn("Inside Warning");
		logger.info("Inside info");
		logger.debug("Inside debug");
		logger.trace("Inside Trace");
		
		List<Student>  studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponseList=new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student->{
			
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
		
		
	}
	
	
	
	@PostMapping("create")
	
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
		
		
		Student student=studentService.createStudent(createStudentRequest);
		
		return new StudentResponse(student);
	}
	
	
	@PutMapping("update")
	
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest)
	{
		Student student=studentService.updateStudent(updateStudentRequest);
		return new StudentResponse(student);
		
	}
	
	
	@PutMapping("updateFirstName/{id}/{firstName}")
	
	public String updateStudentWithJpql(@PathVariable Long id,@PathVariable String firstName)
	{
		return studentService.updateStudentWithJpql(id,firstName)+ "student updated";
	}
	
    @DeleteMapping("deleteByFirstName/{firstName}")
	
	public String deleteStudentWithJpql(@PathVariable String firstName)
	{
		return studentService.deleteStudentWithJpql(firstName)+ "student (s) deleted";
	}
	
	
	
	
	
	
	
	/*@DeleteMapping("delete")
	
	public String deleteStudent(@RequestParam long id)
	{
		return studentService.deleteStudent(id);
		
	}
	*/
	
@DeleteMapping("delete/{id}")
	
	public String deleteStudent(@PathVariable long id)
	{
		return studentService.deleteStudent(id);
		
	}
	
@GetMapping("getByFirstName/{firstName}")

public List<StudentResponse> getByFirstName(@PathVariable String firstName)
{
	List<Student> studentList=studentService.getByFirstName(firstName);
	
	
	List<StudentResponse> studentResponseList=new ArrayList<StudentResponse>();
	
	studentList.stream().forEach(student->{
		
		studentResponseList.add(new StudentResponse(student));
	});
	
	return studentResponseList;
	}



@GetMapping("getByCity/{city}")

public List<StudentResponse> getByCity(@PathVariable String city)
{
	List <Student> studentList=studentService.getByCity(city);
	
	List <StudentResponse> studentResponseList= new ArrayList<StudentResponse>();
	studentList.stream().forEach(student->{studentResponseList.add(new StudentResponse(student));});
	return studentResponseList;
	
}

/*
@GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")

public StudentResponse getByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName)
{
	
	
	
return	new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
	
	}
*/




@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")

public List <StudentResponse> getByFirstNameOrLastName(@PathVariable String firstName,@PathVariable String lastName)
{
	
	
	
  List<Student> studentList=studentService.getByFirstNameOrLastName(firstName, lastName);
  
  List<StudentResponse> studentResponseList=new ArrayList<StudentResponse>();
	
	studentList.stream().forEach(student->{
		
		studentResponseList.add(new StudentResponse(student));
	});
	
	return studentResponseList;
	
	}



@GetMapping("getByFirstNameIn")

public List <StudentResponse> getByFirstNameIn(@RequestBody InQueryRequest inQueryRequest)
{
	
	
	
  List<Student> studentList=studentService.getByFirstNameIn(inQueryRequest);		

  List <StudentResponse> studentResponseList=new ArrayList<StudentResponse>();
	
	studentList.stream().forEach(student->{
		
		studentResponseList.add(new StudentResponse(student));
	});
	
	return studentResponseList;
	
	}

@GetMapping("getAllWithPagination")
public List<StudentResponse> getAllStudentWithPagination(@RequestParam int pageNo,@RequestParam int pageSize)
{
	
	List<Student> studentList=studentService.getAllStudentWithPagination(pageNo,pageSize);
List <StudentResponse> studentResponseList=new ArrayList<StudentResponse>();
	
	studentList.stream().forEach(student->{
		
		studentResponseList.add(new StudentResponse(student));
	});
	
	return studentResponseList;
	
}
}
	
	

