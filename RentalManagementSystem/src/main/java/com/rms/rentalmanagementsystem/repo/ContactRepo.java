package com.rms.rentalmanagementsystem.repo;

import com.rms.rentalmanagementsystem.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
}
