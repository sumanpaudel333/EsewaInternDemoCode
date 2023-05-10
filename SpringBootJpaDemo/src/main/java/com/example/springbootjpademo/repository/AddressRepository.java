package com.example.springbootjpademo.repository;

import com.example.springbootjpademo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
