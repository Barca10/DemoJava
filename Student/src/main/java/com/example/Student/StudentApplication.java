package com.example.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@ComponentScan (basePackages= {"com.example.Student.Controller.StudentController", "com.example.Student.Service.StudentService", "com.example.Student.Store.StudentStore"})
//@EnableMongoRepositories("com.example.Student.Store")
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
