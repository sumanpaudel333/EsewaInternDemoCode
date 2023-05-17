package com.rms.rentalmanagementsystem.repo;

import com.rms.rentalmanagementsystem.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property,Integer> {
}
