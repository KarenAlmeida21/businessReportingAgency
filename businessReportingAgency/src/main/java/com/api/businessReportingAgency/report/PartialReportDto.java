package com.api.businessReportingAgency.report;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartialReportDto {

    @NotBlank
    private String descricao;
    @NotBlank
    private Period periodo;
}
