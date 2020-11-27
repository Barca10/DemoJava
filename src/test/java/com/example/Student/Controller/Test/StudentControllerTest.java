package com.example.Student.Controller.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.Student.Controller.StudentController;
import com.example.Student.DBModel.StudentDTOModel;
import com.example.Student.Model.Student;
import com.example.Student.Service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {

	@MockBean
	private StudentService studentService;
	
	@Autowired
	private MockMvc mockMvc;
	
	String StudentJson = "{\"id\":\"testID\",\"name\":\"testName\"}";
	
	@Test
	public void InsertNewStudent_ResponseStatusOK() throws Exception {
		
		// Mockito.when(studentService.insertStudent(Mockito.any(Student.class)).thenAnswer(1);
		
		Mockito.doReturn(1).when(studentService).insertStudent(Mockito.any(Student.class));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/student")
				.accept(MediaType.APPLICATION_JSON)
				.content(StudentJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
	
	@Test
	public void InsertNewStudent_ResponseStatusBadRequest() throws Exception {
		
		// Mockito.when(studentService.insertStudent(Mockito.any(Student.class)).thenAnswer(1);
		
		Mockito.doReturn(2).when(studentService).insertStudent(Mockito.any(Student.class));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/student")
				.accept(MediaType.APPLICATION_JSON)
				.content(StudentJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

	}
	
	@Test
	public void GetStudent_ReturnStudent() throws Exception {
		
		Student student = new Student();
		student.setFirstName("TestFirstName");
		student.setLastName("TestLastName");
		
		 Mockito.when(studentService.getStudent(Mockito.anyString()))
				 .thenReturn(student);
		
		// Mockito.doReturn(2).when(studentService).insertStudent(Mockito.any(Student.class));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/student/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertThat(response.getContentAsString().contains("student"));

	}
}
