package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
}
