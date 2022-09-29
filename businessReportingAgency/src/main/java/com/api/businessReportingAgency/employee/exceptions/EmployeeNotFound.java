package com.api.businessReportingAgency.employee.exceptions;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message) {
        super(message);
    }
}
