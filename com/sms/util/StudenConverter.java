package com.sms.util;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.dto.StudentDto;
import com.sms.entity.Student;

@Component //part of the application
public class StudenConverter {
	//method to convert dto to entity
	public Student convertDtoToStdEntity(StudentDto sDto)
	{
		Student std =new Student();
		if(sDto != null)
		{
			BeanUtils.copyProperties(sDto, std);//copies from studentDto to student
		}
		return std;
	}
	//method to convert student entoty to dto
	
	public StudentDto convertEntityToStdDto(Student std)
	{
		StudentDto sDto =new StudentDto();
		if(std!=null)
		{
			BeanUtils.copyProperties(std, sDto);
		}
		return sDto;
	}
}
