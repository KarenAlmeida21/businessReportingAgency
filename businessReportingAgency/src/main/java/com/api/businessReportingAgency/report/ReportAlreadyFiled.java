package com.api.businessReportingAgency.report;

public class ReportAlreadyFiled extends RuntimeException {
    public ReportAlreadyFiled(String message) {
        super(message);
    }
}
