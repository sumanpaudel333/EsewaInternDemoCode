package com.rms.rentalmanagementsystem.Property.repo;

import com.rms.rentalmanagementsystem.Property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepo extends JpaRepository<Property,Integer> {
}
