package com.api.businessReportingAgency.report;

public class ReportNotFound extends RuntimeException {
    public ReportNotFound(String message) {
        super(message);
    }
}
