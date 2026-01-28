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
@ToString(exclude = {"remarks"})   // optional: exclude large text from toString
public class SalesRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "policy_number", unique = true, nullable = false, length = 50)
    private String policyNumber;

    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;

    @Column(name = "scrutiny_number", length = 50)
    private String scrutinyNumber;

    @Column(name = "net_premium", precision = 15, scale = 2)
    private BigDecimal netPremium;

    @Column(name = "gross_premium", precision = 15, scale = 2)
    private BigDecimal grossPremium;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "lob", length = 100)
    private String lob;

    @Column(name = "employee_id", nullable = false, length = 50)
    private String employeeId;

    @Column(name = "employee_name", length = 100)
    private String employeeName;

    @Column(name = "tl_name", length = 100)
    private String tlName;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}