package com.company.teamsales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_number", unique = true, nullable = false)
    private String policyNumber;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    private String scrutinyNumber;

    @Column(precision = 15, scale = 2)
    private BigDecimal netPremium;

    @Column(precision = 15, scale = 2)
    private BigDecimal grossPremium;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    private String lob;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    private String employeeName;

    private String tlName;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}