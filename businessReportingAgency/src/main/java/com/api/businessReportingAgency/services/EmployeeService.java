package com.api.businessReportingAgency.services;

import com.api.businessReportingAgency.dtos.EntryEmployeeDto;
import com.api.businessReportingAgency.exceptions.EmployeeNotFound;
import com.api.businessReportingAgency.exceptions.RegistrationAlreadyDone;
import com.api.businessReportingAgency.models.Employee;
import com.api.businessReportingAgency.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            throw new RegistrationAlreadyDone("Registration Already Done");
        } else {
            employeeRepository.save(employee);
            return employee;
        }
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFound("\n" +
                    "id not found");
        }
        employeeRepository.deleteById(id);
    }

    public Employee displayById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFound("id not found");
        }
        Employee employeeGet = employee.get();
        return employeeGet;
    }

    public Employee UpdateEmployee(Long id, EntryEmployeeDto employeeNew){
        Employee employee= displayById(id);
        employee.setName(employeeNew.getName());
        employee.setCpf(employeeNew.getCpf());
        return employeeRepository.save(employee);

    }

}
