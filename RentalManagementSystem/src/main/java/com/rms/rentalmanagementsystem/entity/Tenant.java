package com.rms.rentalmanagementsystem.entity;

import com.rms.rentalmanagementsystem.entity.Contact;
import com.rms.rentalmanagementsystem.enums.UserStatusEnum;
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
    private int tenantId;
    @Column(name = "tenant_name")
    private String tenantName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Contact contact;
    @JoinColumn(name = "tenant_status")
    private UserStatusEnum tenantStatus;
}
