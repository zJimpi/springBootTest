package com.sms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User{
	
	@Column(nullable=false)
	private LocalDate dateOfBirth; //yyyy-mm-date
	
	@Column(nullable=false)
	private LocalDate dateOfJoining;
	
	@Column(length = 10, nullable=false, unique = true)
	private String contact;
	
	@OneToOne //one student can have only one address
	private Address address;
	
	@ManyToOne //many student can belong to one department
	private Department dept;

}
