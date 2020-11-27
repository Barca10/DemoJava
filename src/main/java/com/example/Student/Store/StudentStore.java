package com.example.Student.Store;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import com.example.Student.DBModel.StudentDTOModel;
import com.mongodb.MongoClient;

@Component
public class StudentStore  {
	
	@Autowired
	MongoOperations mongoOperations;
	
	public int InsertStudent(StudentDTOModel student) {
		Morphia morphia = new Morphia();
		new ValidationExtension( morphia );
		
		MongoClient client = new MongoClient("localhost", 27017);
		
		Datastore dataStore = morphia.createDatastore(client, "student");
		
		dataStore.ensureIndexes();
		
		dataStore.save(student);
//		dataStore.ensureCaps();
		return 1;
	}
	
	public StudentDTOModel GetStudent(String id) {

		StudentDTOModel student = new StudentDTOModel();
		
		Morphia morphia = new Morphia();
		MongoClient client = new MongoClient("localhost", 27017);
		
		Datastore dataStore = morphia.createDatastore(client, "student");
		
		student = dataStore.find(StudentDTOModel.class)
										.filter("FirstName", id)
										.get();
		
		
		
		
		return student;
	}

}
