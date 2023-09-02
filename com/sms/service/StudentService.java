package com.sms.service;

import java.util.List;

import com.sms.dto.StudentDto;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFound;

public interface StudentService {

	//method used to save save studebt details into the database
	String createStudent(Student student);
	//same as above with different return type ..just for demo
	StudentDto saveStudent(Student student);
	
	
	//method to fetch all student details using id
	StudentDto getStudentById(int stuId) throws ResourceNotFound;
	
	//method to fetch all student details
	List<StudentDto> getAllStudents();
	
	
	//method to update student details 
	StudentDto updateStudent(int stdId,Student std);
	
	//method to delete one student details
	void  deleteStudentById(int stdId);
	
	//method to delete all the student from the db
	void deteleAll();
	
	//method to fetch student deatils by name
	List<StudentDto> getStudentByName(String name);
	
	//fetch sudent deails by email
	StudentDto getStudentByEmail(String email);
	
	//method to fetch stdent deatils from dept using deptId
	List<StudentDto> getStudentsByDeptId(int deptId);
}
