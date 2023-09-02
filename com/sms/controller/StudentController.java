package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.StudentDto;
import com.sms.entity.Student;
import com.sms.service.StudentService;
import com.sms.util.StudenConverter;

@RestController //business layer
public class StudentController {
	
	@Autowired //ingecting
	StudentService stdService;
	
	@Autowired
	StudenConverter stdConverter;
	//mathod name can be different it just for demo pourpose
	@PostMapping("/createStudent")//post is used to inset a data into db
	public String createStudent (@Valid @RequestBody StudentDto stdDto)
	{
		final Student std = stdConverter.convertDtoToStdEntity(stdDto);
		//call the business layer
		return stdService.createStudent(std);
	}

	@PostMapping("/saveStudent") //custom url
	public StudentDto saveStudent(@Valid @RequestBody StudentDto stdDto)//mapps jason to this
	{
		final Student std = stdConverter.convertDtoToStdEntity(stdDto);
		return stdService.saveStudent(std);
	}
	
	@GetMapping("/getStudent/{id}") //get is used when we need to fetch the details
	public StudentDto getStudentById(@PathVariable("id") int id)
	{
		return stdService.getStudentById(id);
	}
	//we are fetching id from url instead of fetching from method
	
	
	@GetMapping("/getAllStudents")
	public List<StudentDto> getAllStudent()
	{
		return stdService.getAllStudents();
	}
	
	@PutMapping("/updateStudent/{id}") //used for updating get and post mapping //diff b/w put:upadte all things patch :update only one parameter
	public StudentDto updateStudent(@PathVariable("id") int stdId,@Valid @RequestBody StudentDto stdDto)
	{
		final Student std = stdConverter.convertDtoToStdEntity(stdDto);
		return stdService.updateStudent(stdId, std);
	}
	
	@DeleteMapping("/deleteStdById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int stdId)
	{
		stdService.deleteStudentById(stdId);
		return new ResponseEntity<String>("Student with id"+stdId+"deleted susscessfully!",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		stdService.deteleAll();
		
		return new ResponseEntity<String>("all students are deleted susessfully!", HttpStatus.OK);
	}
	
	
	@GetMapping("/getStudentByName/{name}")
	public List<StudentDto> findStudentByName(@PathVariable("name") String name)
	{
		return stdService.getStudentByName(name);
	}
	
	@GetMapping("/getStudentByEmail/{email}")
	public StudentDto findStudentByEmail(@PathVariable("email") String email)
	{
		return stdService.getStudentByEmail(email);
	}
	
	@GetMapping("/getStudentsByDeptId/{dId}")
	public List<StudentDto> getStudentByDeptID(@PathVariable("dId") int deptId)
	{
		return stdService.getStudentsByDeptId(deptId);
	}
}
