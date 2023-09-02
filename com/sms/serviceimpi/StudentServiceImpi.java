package com.sms.serviceimpi;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dto.StudentDto;
import com.sms.entity.Address;
import com.sms.entity.Department;
import com.sms.entity.Role;
import com.sms.entity.Student;
import com.sms.exception.ResourceNotFound;
import com.sms.repository.AddressRepository;
import com.sms.repository.DeptmentRepository;
import com.sms.repository.RoleRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import com.sms.util.StudenConverter;

@Service //denotes what role this class will play
public class StudentServiceImpi implements StudentService{

	@Autowired
	StudentRepository stdRepository;
	
	@Autowired
	StudenConverter stdConverter;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AddressRepository addRepository;
	
	@Autowired
	DeptmentRepository deptRepository;
	
	@Override
	public String createStudent(Student student) {
		//if return type is srting website console gices error so use onject or void
		//auto generating user name
		
		int endIndex = student.getEmail().lastIndexOf('@');
		String user=student.getEmail().substring(0,endIndex);
		student.setUserName(user);
		//auto generating password
		String pass = student.getName().substring(0,3).toLowerCase();
		student.setPassword(pass+"123");
		
		
		
		
		stdRepository.save(student);//saving
		
		
		
		return "student created succesfully!";
	}

	//just showing the difference b/t two
	@Override
	public StudentDto saveStudent(Student student) {
		//auto generating user name
		int endIndex = student.getEmail().lastIndexOf('@');
		String user=student.getEmail().substring(0,endIndex);
		student.setUserName(user);
		//auto generating password
		String pass = student.getName().substring(0,3).toLowerCase();
		student.setPassword(pass+"123");
				
		//setting the role
		Role role = roleRepository.findById(2).get();
		student.setRole(role);
		
		addRepository.save(student.getAddress());
		stdRepository.save(student);//saving
		
		StudentDto sDto = stdConverter.convertEntityToStdDto(student);
		return sDto;
	}

	@Override
	public StudentDto getStudentById(int stuId) throws ResourceNotFound{
													//if found show the detals if not found thow exception
		Student std = stdRepository.findById(stuId).orElseThrow(
				//interact with db using persistance layer.from jpa repo(but returns optional object).returns student
				()-> new ResourceNotFound("Student", "id ", stuId)
		);
					
		
		return stdConverter.convertEntityToStdDto(std);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = stdRepository.findAll();
		
		List<StudentDto> sDtos = new ArrayList<>();
		
		for(Student s :students)
		{
			StudentDto sDto= stdConverter.convertEntityToStdDto(s);
			sDtos.add(sDto);
		}
		
		return sDtos;
	}

	@Override
	public StudentDto updateStudent(int stdId, Student std) {
		
		//fetch students using id
		
		Student existingStd = stdRepository.findById(stdId).orElseThrow( ()->
			new ResourceNotFound("Student", "id", stdId));
		
		//updating the existing std details with new details
		existingStd.setName(std.getName());
		
		existingStd.setEmail(std.getEmail());
		existingStd.setAddress(std.getAddress());
		existingStd.setContact(std.getContact());
		existingStd.setDateOfBirth(std.getDateOfBirth());
		existingStd.setDateOfJoining(std.getDateOfJoining());
		
		//save it permanetly in db
		stdRepository.save(existingStd);
		
		return stdConverter.convertEntityToStdDto(existingStd);
	}

	@Override
	public void deleteStudentById(int stdId) {
		
		Student std = stdRepository.findById(stdId).orElseThrow(()->
				new ResourceNotFound("Student", "id", stdId));
		
		Department dept = std.getDept();
		
		Address add =std.getAddress();
		if(add !=null)
		{
			std.setAddress(null);
			addRepository.delete(add);
		}
		
		if(dept !=null)
		{
			dept.setTotalStudents(dept.getTotalStudents()-1);
		}
		
		deptRepository.save(dept);
		
		stdRepository.deleteById(stdId);
			
	}

	@Override
	public void deteleAll() {
		
		stdRepository.deleteAll();
	}

	@Override
	public List<StudentDto> getStudentByName(String name) {
		
		List<Student> students= stdRepository.findStudentByName(name);
		
		List<StudentDto> sDtos = new ArrayList<>();
		
		for(Student s :students)
		{
			StudentDto sDto= stdConverter.convertEntityToStdDto(s);
			sDtos.add(sDto);
		}
		
		return sDtos;
	}

	@Override
	public StudentDto getStudentByEmail(String email) {
		 
		Student std = stdRepository.findByEmail(email).orElseThrow(
				()->new ResourceNotFound("Student", "email",email));
		
		 
		 return stdConverter.convertEntityToStdDto(std);
	}

	@Override
	public List<StudentDto> getStudentsByDeptId(int deptId) {
		
		List<Student> students =stdRepository.getStudentsByDeptId(deptId);
		
		List<StudentDto> sDtos = new ArrayList<>();
		
		for(Student s :students)
		{
			StudentDto sDto= stdConverter.convertEntityToStdDto(s);
			sDtos.add(sDto);
		}
		
		return sDtos;
		
	}
	
	
	

}
