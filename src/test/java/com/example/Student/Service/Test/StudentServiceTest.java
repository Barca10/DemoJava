package com.example.Student.Service.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Student.Model.Student;
import com.example.Student.Service.StudentService;
import com.example.Student.Store.StudentStore;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

	@MockBean
	private StudentStore studentStore;
	
	@Autowired
	private StudentService studentService;
	
	 @Before
	 public void init() {
	  //  studentService = Mockito.mock(StudentService.class);
	 }
	
	@Test
	public void InsertStudent_Success() throws Exception {
		
		Student student = new Student();
		student.setFirstName("TestFirstName");
		student.setLastName("TestLastName");
		
		 Mockito.when(studentStore.InsertStudent(Mockito.any(Student.class)))
		 .thenReturn(1);
		
		 int success = this.studentService.insertStudent(student);

		 assertEquals(success, 1);
	}
	
	@Test
	public void InsertStudent_Failure() throws Exception {
		
		Student student = new Student();
		student.setFirstName("TestFirstName");
		student.setLastName("TestLastName");
		
		 Mockito.when(studentStore.InsertStudent(Mockito.any(Student.class)))
		 .thenReturn(2);
		
		 int success = this.studentService.insertStudent(student);

		 assertEquals(success, 2);
	}
	
	@Test
	public void getStudent_pass() throws Exception {
		
		Student student = new Student();
		student.setFirstName("TestFirstName");
		student.setLastName("TestLastName");
		
		 Mockito.when(studentStore.GetStudent(Mockito.anyString()))
		 .thenReturn(student);
		
		 Student _student = this.studentService.getStudent(student.getFirstName());

		 assertEquals(_student, student);
	}
	
}
