package com.sms.service;

import com.sms.entity.Student;

public interface StudentService {

	//method used to save save studebt details into the database
	String createStudent(Student student);
	//same as above with different return type ..just for demo
	Student saveStudent(Student student);
	
	Student getStudentById(int stuId);
}
