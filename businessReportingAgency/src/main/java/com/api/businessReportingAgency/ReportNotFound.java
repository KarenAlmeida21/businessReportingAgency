package com.api.businessReportingAgency;

public class ReportNotFound extends RuntimeException {
    public ReportNotFound(String message) {
        super(message);
    }
}
