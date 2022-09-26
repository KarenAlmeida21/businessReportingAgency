package com.api.businessReportingAgency.manager;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, CPF> {
    boolean existsByCpf(CPF cpf);

}
