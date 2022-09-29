package com.api.businessReportingAgency.employee.controller;

import com.api.businessReportingAgency.employee.dtos.EntryEmployeeDto;
import com.api.businessReportingAgency.employee.dtos.OutEmployeeDto;
import com.api.businessReportingAgency.employee.model.Employee;
import com.api.businessReportingAgency.employee.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ModelMapper modelMapper;


    @ApiOperation(value = "Save a employee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fileEmployee(@RequestBody @Valid EntryEmployeeDto entryEmployeeDto) {
        Employee employeeNew = modelMapper.map(entryEmployeeDto, Employee.class);
        modelMapper.map(employeeService.saveEmployee(employeeNew), EntryEmployeeDto.class);
    }

    @ApiOperation(value = "Delete a employee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @ApiOperation(value = "Display a specific employee by id")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("id/{id}")
    public OutEmployeeDto displayById(@PathVariable Long id) {
        Employee employee = employeeService.displayById(id);
        return modelMapper.map(employee, OutEmployeeDto.class);
    }

    @ApiOperation(value = "Change data from a specific employee")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("update/{id}")
    public EntryEmployeeDto UpdateEmployee(@PathVariable Long id,
                                         @RequestBody EntryEmployeeDto entryEmployeeDto) {
        Employee employee = employeeService.UpdateEmployee(id, entryEmployeeDto);
        return modelMapper.map(employee, EntryEmployeeDto.class);
    }

}
