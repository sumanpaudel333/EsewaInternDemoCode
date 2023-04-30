package com.example.springbootdtodemo.repository;

import com.example.springbootdtodemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
