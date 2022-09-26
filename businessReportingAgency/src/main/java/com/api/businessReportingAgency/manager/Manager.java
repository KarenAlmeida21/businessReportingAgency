package com.api.businessReportingAgency.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Manager {
    @Id
    private CPF cpf;
    private String name;
    private String setor;




}
