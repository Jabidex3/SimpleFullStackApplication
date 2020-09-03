package com.tutorial.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
