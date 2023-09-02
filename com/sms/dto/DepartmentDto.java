package com.sms.dto;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentDto {

	private int deptId;
	
	@NotNull(message="Department name is required")
	@Size(min=2, message="min 2 charecter required")
	@Size( max=30, message="max 30 char allowed")
	@NotBlank(message="enter corect Dept name")
	private String deptName;
	
	@NotNull(message="Total no of student is required")
	private int totalStudents;
	
	@NotNull(message="Total no of staff is required")
	private int noOfStaff;
	
	@OneToMany
	private List<Student> student;
}
