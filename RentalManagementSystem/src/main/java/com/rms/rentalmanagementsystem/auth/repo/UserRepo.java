package com.rms.rentalmanagementsystem.auth.repo;

import com.rms.rentalmanagementsystem.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUserName(String username);
}
