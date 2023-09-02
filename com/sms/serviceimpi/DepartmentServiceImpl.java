package com.sms.serviceimpi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.DepartmentDto;
import com.sms.entity.Department;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFound;
import com.sms.repository.DeptmentRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.DepartmentService;
import com.sms.util.DepartmentConverter;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DeptmentRepository deptRepository;
	
	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	DepartmentConverter deptConverter;
	
	@Override
	public DepartmentDto saveDepartment(Department dept) {
		
		deptRepository.save(dept);
		return deptConverter.convertEntityToDeptDto(dept);
	}

	@Override
	public void assignStudentToDept(int stdId, int deptId) {
		
	Student std = stdRepository.findById(stdId).orElseThrow(
				()-> new ResourceNotFound("Student", "id", stdId));
		
	Department dept = deptRepository.findById(deptId).orElseThrow(
			()-> new ResourceNotFound("Student", "id", deptId));
	
	std.setDept(dept);
	//update the total students
	dept.setTotalStudents(dept.getTotalStudents()+1);
	
	
	//dept.setStudent(List.of(std));
	
	stdRepository.save(std);
	deptRepository.save(dept);
	
	}

}
