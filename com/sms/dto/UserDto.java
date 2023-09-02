package com.sms.dto;

import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	//take same variable as user class
	private int id;
	
	@NotNull(message="name is required")
	@Size(min=2, message="min 2 charecter required")
	@Size( max=30, message="max 30 char allowed")
	@NotBlank(message="enter corect name")
	private String name;
	
	
	@Size( max=50, message="max 50 char allowed")
	@Email(message="Invalid email")
	private String email;
	
	
	private String userName;
	private String password;
	
	@OneToOne
	private Role role;

}
