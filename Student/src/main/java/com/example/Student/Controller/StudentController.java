package com.example.Student.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.Model.Student;
import com.example.Student.Service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService _studentService;
	
	
	
	public StudentController(StudentService studentService) {
		this._studentService = studentService;
	}

	 @RequestMapping(value = "/student", method = RequestMethod.POST)	
	 @ResponseBody
	 public ResponseEntity<Void> insertNewStudent(@RequestBody Student newStudent) throws Exception {
		 Student student = new Student();
		 student.setFirstName(newStudent.FirstName);
		 student.setLastName(newStudent.LastName);
		 
		 
     int success = this._studentService.insertStudent(student);
		 
	 if (success == 1){
			 return ResponseEntity.ok().build();
     }		 
	 else{
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		 }
	 }
	 
	 @RequestMapping(value = "/student/{studentid}", method = RequestMethod.GET)	
	 @ResponseBody
	 public Student getStudent(@PathVariable String studentid) throws Exception {
		 Student student = null; 
		 if(studentid != null) {
			 student  = this._studentService.getStudent(studentid);
		 }
	 return student;
	 }
	 
	 @RequestMapping(value = "/student/get", method = RequestMethod.GET)
	 @ResponseBody
	 public String NewStudent() throws Exception {
		 
     return "this is test";
		 
	 }

	
}
