package com.api.businessReportingAgency.employee;

import com.api.businessReportingAgency.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByCpf(String cpf);
    Optional<Employee> findByUsername(String username);

}
