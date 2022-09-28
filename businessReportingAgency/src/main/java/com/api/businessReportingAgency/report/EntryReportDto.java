package com.api.businessReportingAgency.report;


import com.api.businessReportingAgency.report.Period;
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
   // @Size(min = 14, max = 14, message = "Inform the cnpj with the 14 mandatory characters")
    private String cnpj;
    @NotBlank
    @Size(min = 5, max = 200, message = "\n" +
            "If there is no description, enter empty")
    private String descricao;
    @NotNull
    private Period periodo;
}
