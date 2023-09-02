package com.sms.service;

import com.sms.dto.DepartmentDto;
import com.sms.entity.Department;

public interface DepartmentService {

	DepartmentDto saveDepartment(Department dept);
	
	//method to assign studenn to department
	void assignStudentToDept(int stdid, int deptId);
}
