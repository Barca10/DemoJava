package com.example.Student.Store.Test;

import static org.junit.Assert.assertEquals;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Student.DBModel.StudentDTOModel;
import com.example.Student.Store.StudentStore;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentStoreTest {
	
	@Mock
	private MongoClient mockClient;
	
	@Mock
	private MongoDatabase mockDB;
	
	@Mock
	private MongoCollection<Document> mockCollection;
	
	@InjectMocks
	private StudentStore studentStore;

	

	
	//@Test
	public void InsertStudent_Success() throws Exception {
		StudentDTOModel student = new StudentDTOModel();
		student.setFirstName("FirstName1");
		student.setLastName("LastName1");		
		
		
		int success = this.studentStore.InsertStudent(student);
		
		assertEquals(success, 1);
	}
	
	@Test
	public void GetStudent_Success() throws Exception {
		StudentDTOModel student = new StudentDTOModel();
		student.setFirstName("FirstName1");
		student.setLastName("LastName1");	
		
		StudentDTOModel _student = this.studentStore.GetStudent("FirstName1");
		
		assertEquals(_student.getFirstName(), student.getFirstName());
		assertEquals(_student.getLastName(), student.getLastName());
	}

}
