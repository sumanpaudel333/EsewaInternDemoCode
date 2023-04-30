package com.example.multipledbdemo.mysql.repo;

import com.example.multipledbdemo.mysql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
