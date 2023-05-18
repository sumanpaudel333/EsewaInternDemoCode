package com.rms.rentalmanagementsystem.repo;

import com.rms.rentalmanagementsystem.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Integer> {
}
