package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entity.Student;
import com.sms.service.StudentService;

@RestController //business layer
public class StudentController {
	
	@Autowired //ingecting
	StudentService stdService;
	
	//mathod name can be different it just for demo pourpose
	@PostMapping("/createStudent")//post is used to inset a data into db
	public String createStudent (@RequestBody Student std)
	{
		
		//call the business layer
		return stdService.createStudent(std);
	}

	@PostMapping("/saveStudent") //custom url
	public Student saveStudent(@RequestBody Student std)//mapps jason to this
	{
		return stdService.saveStudent(std);
	}
	
	@GetMapping("/getStudent/{id}") //get is used when we need to fetch the details
	public Student getStudentById(@PathVariable("id") int id)
	{
		return stdService.getStudentById(id);
	}
	//we are fetching id from url instead of fetching from method
}
