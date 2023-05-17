package com.rms.rentalmanagementsystem.repo;

import com.rms.rentalmanagementsystem.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepo extends JpaRepository<Lease,Integer> {
}
