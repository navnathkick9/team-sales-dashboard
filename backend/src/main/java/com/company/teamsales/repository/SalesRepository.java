package com.company.teamsales.repository;

import com.company.teamsales.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalesRepository extends JpaRepository<SalesRecord, Long> {
    List<SalesRecord> findByEmployeeId(String employeeId);
    List<SalesRecord> findByTlName(String tlName);
}