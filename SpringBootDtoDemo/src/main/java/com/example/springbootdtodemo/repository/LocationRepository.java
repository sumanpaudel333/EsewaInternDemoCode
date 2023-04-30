package com.example.springbootdtodemo.repository;

import com.example.springbootdtodemo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
