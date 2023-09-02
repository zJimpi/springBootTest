package com.sms.dto;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sms.entity.Address;
import com.sms.entity.Department;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentDto extends UserDto{

	@NotNull(message="Dob is required")
	private LocalDate dateOfBirth; //yyyy-mm-date
	
	@NotNull(message="doj is required")
	private LocalDate dateOfJoining;
	
	@NotNull(message="provide contact number")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message="Invalid contact")//[1st char is either6 either7 ..][next 9 num can be anything from 0 to 9]
	@Size(min=10,max=10,message="provide a 10 digit number")
	private String contact;
	
	@OneToOne //one student can have only one address
	private Address address;
	
	@ManyToOne //many student can belong to one department
	private Department dept;
}
