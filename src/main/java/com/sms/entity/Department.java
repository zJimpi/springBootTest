package com.sms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	
	@Column(length = 30, nullable = false)
	private String deptName;
	
	@Column(nullable = false)
	private int totalStudents;
	
	@Column(nullable = false)
	private int noOfStaff;
	
	@OneToMany
	private List<Student> student;
	

}
