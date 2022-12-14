package com.api.businessReportingAgency.report.service;

import com.api.businessReportingAgency.report.dtos.PartialReportDto;
import com.api.businessReportingAgency.report.models.Report;
import com.api.businessReportingAgency.report.exceptions.ReportAlreadyFiled;
import com.api.businessReportingAgency.report.exceptions.ReportNotFound;
import com.api.businessReportingAgency.report.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ReportService {
    @Autowired
    ReportRepository reportRepository;


    public Report saveReport(Report report) {
        if (reportRepository.existsByCnpj(report.getCnpj())) {
            throw new ReportAlreadyFiled("Report already filed");
        }
        reportRepository.save(report);
        return report;
    }

    public void deleteReport(Long id) {
        Optional<Report> reportOptional = reportRepository.findById(id);
        if (reportOptional.isEmpty()) {
            throw new ReportNotFound("ID NOT FOUND");
        }
        reportRepository.deleteById(id);
    }

    public Report displayFullReport(String cnpj) {
        Optional<Report> reportOptional = reportRepository.findByCnpj(cnpj);
        if (reportOptional.isEmpty()) {
            throw new ReportNotFound("CNPJ NOT FOUND");
        }
        return reportOptional.get();
    }

    public List<Report> displayAllReports() {
        List<Report> reportList = (List<Report>) reportRepository.findAll();
        if (reportList.isEmpty()) {
            throw new ReportNotFound("There are no reports");
        }
        return reportList;
    }

    public Report apdateReport(String cnpj, PartialReportDto reportNew) {
        Report report = displayFullReport(cnpj);
        report.setDescricao(reportNew.getDescricao());
        report.setPeriodo(reportNew.getPeriodo());
        return reportRepository.save(report);

    }
}




