package com.api.businessReportingAgency.employee;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fileEmployee(@RequestBody @Valid EntryEmployeeDto entryEmployeeDto) {
        Employee employeeNew = modelMapper.map(entryEmployeeDto, Employee.class);
        modelMapper.map(employeeService.saveEmployee(employeeNew), EntryEmployeeDto.class);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }


    @GetMapping("id/{id}")
    public OutEmployeeDto displayById(@PathVariable Long id) {
        Employee employee = employeeService.displayById(id);
        return modelMapper.map(employee, OutEmployeeDto.class);
    }

    @PutMapping("update/{id}")
    public EntryEmployeeDto UpdateEmployee(@PathVariable Long id,
                                         @RequestBody EntryEmployeeDto entryEmployeeDto) {
        Employee employee = employeeService.UpdateEmployee(id, entryEmployeeDto);
        return modelMapper.map(employee, EntryEmployeeDto.class);
    }

}
