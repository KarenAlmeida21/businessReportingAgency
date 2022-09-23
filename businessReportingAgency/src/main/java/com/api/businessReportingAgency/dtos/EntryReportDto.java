package com.api.businessReportingAgency.dtos;

import com.api.businessReportingAgency.enums.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryReportDto {

    @NotBlank
  //  @Size(min = 14, max =14, message = "Inform the cnpj with the 14 mandatory characters")
    private String cnpj;
    @NotBlank
   // @Size(min = 5, max = 200, message = "\n" +
         //   "If there is no description, enter empty")
    private String descricao;
    @NotNull
    private Period periodo;
}
