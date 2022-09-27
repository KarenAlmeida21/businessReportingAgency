package com.api.businessReportingAgency.manager;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntryManagerDto {
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;

    private Sector setor;
}
