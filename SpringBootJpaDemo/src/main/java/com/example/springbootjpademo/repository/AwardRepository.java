package com.example.springbootjpademo.repository;

import com.example.springbootjpademo.entity.Awards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Awards,Integer> {
}
