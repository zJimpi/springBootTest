package com.sms.serviceimpi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entity.Student;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;

@Service //denotes what role this class will play
public class StudentServiceImpi implements StudentService{

	@Autowired
	StudentRepository stdRepository;
	
	@Override
	public String createStudent(Student student) {
		//if return type is srting website console gices error so use onject or void
		//auto generating user name
		int endIndex = student.getEmail().lastIndexOf('@');
		String user=student.getEmail().substring(0,endIndex);
		student.setUserName(user);
		//auto generating password
		String pass = student.getName().substring(0,3).toLowerCase();
		student.setPassword(pass+"123");
		
		
		stdRepository.save(student);//saving
		
		return "student created succesfully!";
	}

	//just showing the difference b/t two
	@Override
	public Student saveStudent(Student student) {
		//auto generating user name
		int endIndex = student.getEmail().lastIndexOf('@');
		String user=student.getEmail().substring(0,endIndex);
		student.setUserName(user);
		//auto generating password
		String pass = student.getName().substring(0,3).toLowerCase();
		student.setPassword(pass+"123");
				
				
		stdRepository.save(student);//saving
		return student;
	}

	@Override
	public Student getStudentById(int stuId) {
		
		Student std = stdRepository.findById(stuId).get();
					//interact with db using persistance layer.from jpa repo(but returns optional object).returns student
		
		return std;
	}

}
