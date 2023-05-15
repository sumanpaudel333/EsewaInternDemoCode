package com.rms.rentalmanagementsystem.Payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Payment {
    @Id
    @Column(name = "payment_id")
    private UUID paymentId;
}
