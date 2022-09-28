package com.api.businessReportingAgency.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

@Transactional
    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.existsByCpf(employee.getCpf())) {
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

    public Employee UpdateEmployee(Long id, EntryEmployeeDto employeeNew) {
        Employee employee = displayById(id);
        employee.setUsername(employeeNew.getUsername());
        employee.setCpf(employeeNew.getCpf());
        employee.setPassword(employeeNew.getPassword());
        employee.setRoles(employeeNew.getRoles());
        return employeeRepository.save(employee);

    }

}
