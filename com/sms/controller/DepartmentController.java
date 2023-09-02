package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.DepartmentDto;
import com.sms.entity.Department;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentService deptService;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@PostMapping("/saveDept")
	public DepartmentDto saveDepartment(@Valid @RequestBody DepartmentDto dDto)
	{
		final Department dept = deptConverter.convertDtoToDeptEntity(dDto);
		return deptService.saveDepartment(dept);
	}
	
	@PostMapping("/assignStd/{sId}/toDept/{dId}")
	public ResponseEntity<String> assignStudentToDept(@PathVariable("sId") int stdId,@PathVariable("dId") int deptId)
	{
		deptService.assignStudentToDept(stdId, deptId);
		
		return new ResponseEntity<String>("student with id"+stdId+" assigned to department id: "+deptId, HttpStatus.OK);
	}
}
