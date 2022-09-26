package com.api.businessReportingAgency.report;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    Optional<Report>findByCnpj(String cnpj);

    boolean existsByCnpj(String cnpj);
}
