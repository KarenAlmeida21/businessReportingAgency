package com.api.businessReportingAgency.dtos;

import com.api.businessReportingAgency.enums.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutReport {
    private Long id;
    private String cnpj;
    private String descricao;
    private Period periodo;
}