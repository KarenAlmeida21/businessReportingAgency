package com.api.businessReportingAgency.repositories;

import com.api.businessReportingAgency.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Long> {
}
