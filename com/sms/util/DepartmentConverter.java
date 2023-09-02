package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.dto.DepartmentDto;
import com.sms.entity.Department;

@Component
public class DepartmentConverter {

	//method to convert dto to entity
	public Department convertDtoToDeptEntity(DepartmentDto dDto)
	{
		Department dept =new Department();
		if(dDto != null)
		{
			BeanUtils.copyProperties(dDto, dept);//copies from studentDto to student
		}
		return dept;
	}
	//method to convert student entoty to dto
	
	public DepartmentDto convertEntityToDeptDto(Department dept)
	{
		DepartmentDto dDto =new DepartmentDto();
		if(dept!=null)
		{
			BeanUtils.copyProperties(dept, dDto);
		}
		return dDto;
	}
}
