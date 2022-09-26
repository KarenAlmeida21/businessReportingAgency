package com.api.businessReportingAgency.employee;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
