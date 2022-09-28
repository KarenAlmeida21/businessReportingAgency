package com.api.businessReportingAgency.employee;


import com.api.businessReportingAgency.role.RoleModel;
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
