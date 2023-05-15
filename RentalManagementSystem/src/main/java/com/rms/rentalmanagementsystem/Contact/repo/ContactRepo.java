package com.rms.rentalmanagementsystem.Contact.repo;

import com.rms.rentalmanagementsystem.Contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contact,Integer> {
}
