package com.rms.rentalmanagementsystem.Landlord.repo;

import com.rms.rentalmanagementsystem.Landlord.entity.Landlord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandlordRepo extends JpaRepository<Landlord,Integer> {
}
