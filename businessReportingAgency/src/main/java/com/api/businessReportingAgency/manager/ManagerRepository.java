package com.api.businessReportingAgency.manager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {
    boolean existsByCpf(String cpf);
    Optional<Manager> findByCpf(String cpf);





}
