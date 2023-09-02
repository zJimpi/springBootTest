package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Department;

public interface DeptmentRepository extends JpaRepository<Department, Integer> {

}
