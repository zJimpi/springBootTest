package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
