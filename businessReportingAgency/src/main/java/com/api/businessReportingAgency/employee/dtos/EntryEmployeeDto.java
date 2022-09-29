package com.api.businessReportingAgency.employee.dtos;


import com.api.businessReportingAgency.role.model.RoleModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class EntryEmployeeDto {
    private String username;
    private String cpf;
    private String password;
    private List<RoleModel> roles;

}
