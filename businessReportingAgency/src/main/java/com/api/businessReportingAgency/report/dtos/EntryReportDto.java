package com.api.businessReportingAgency.report.dtos;


import com.api.businessReportingAgency.report.enums.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryReportDto {

    @NotBlank
    private String cnpj;
    @NotBlank
    @Size(min = 5, max = 200, message = "\n" +
            "If there is no description, write empty")
    private String descricao;
    @NotNull
    private Period periodo;
}
