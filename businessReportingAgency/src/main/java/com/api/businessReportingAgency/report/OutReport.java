package com.api.businessReportingAgency.report;


import com.api.businessReportingAgency.report.Period;
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
