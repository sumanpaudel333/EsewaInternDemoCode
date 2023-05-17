package com.rms.rentalmanagementsystem.repo;

import com.rms.rentalmanagementsystem.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepo extends JpaRepository<Landlord,Integer> {
}
