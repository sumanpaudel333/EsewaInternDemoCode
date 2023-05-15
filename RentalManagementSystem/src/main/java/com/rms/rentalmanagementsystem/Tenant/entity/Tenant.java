package com.rms.rentalmanagementsystem.Tenant.entity;

import com.rms.rentalmanagementsystem.Contact.entity.Contact;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tenant_id")
    private long tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
}
