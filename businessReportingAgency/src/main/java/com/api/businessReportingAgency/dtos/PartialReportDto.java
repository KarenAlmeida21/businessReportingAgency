package com.api.businessReportingAgency.dtos;

import com.api.businessReportingAgency.enums.Period;
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
