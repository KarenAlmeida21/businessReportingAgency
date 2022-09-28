package com.api.businessReportingAgency.config.configSecurity;

import com.api.businessReportingAgency.employee.Employee;
import com.api.businessReportingAgency.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class EmployeeDetailsService implements UserDetailsService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found with name"));
        return new User(employee.getUsername(), employee.getPassword(), true, true, true,
                true, employee.getAuthorities());
    }
}
