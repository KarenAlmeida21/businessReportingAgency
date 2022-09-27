package com.api.businessReportingAgency.manager;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;
@Getter
@Setter
public class OutManagerDto {
    private Long id;
    private String name;
    private Sector setor;
}
