package com.mevan.spring.scheduler.repository;

import com.mevan.spring.scheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
