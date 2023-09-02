package com.sms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	//querry in hql
	@Query("from Student where name=:e")
	List<Student> findStudentByName(@Param("e") String name);
	
	//without wirting hql
	Optional<Student> findByEmail(String email); 
	
	//custom method to fecth student details belognigng to department by using deptid
	@Query("from Student where dept=(from Department where deptId=:d)")
	List<Student> getStudentsByDeptId(@Param("d") int deptId);
	
}
