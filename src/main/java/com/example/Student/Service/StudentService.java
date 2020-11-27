package com.example.Student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.DBModel.StudentDTOModel;
import com.example.Student.Model.Student;
import com.example.Student.Store.StudentStore;

@Service
public class StudentService {
	
	@Autowired
	private StudentStore _studentStore;
	
	public StudentService(StudentStore studentStore) {
		this._studentStore = studentStore;	
	}

	public int insertStudent(Student student) {
		int success = 0;
		
		if(student != null) {
		 success = this._studentStore.InsertStudent(student);
		}
		
		else {
			success = 2;
		}
		return success;
	}
	
	public Student getStudent(String id) {
	Student student = new Student();
	
	student = (Student) this._studentStore.GetStudent(id);
	
	return student;
	}
}
