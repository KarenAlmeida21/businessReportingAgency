package com.api.businessReportingAgency.report.dtos;


import com.api.businessReportingAgency.report.enums.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class PartialReportDto {

    @NotBlank
    private String descricao;
    @NotBlank
    private Period periodo;
}
