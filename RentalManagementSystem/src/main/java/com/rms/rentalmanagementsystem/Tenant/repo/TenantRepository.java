package com.rms.rentalmanagementsystem.Tenant.repo;

import com.rms.rentalmanagementsystem.Tenant.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
