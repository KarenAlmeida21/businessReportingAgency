package com.api.businessReportingAgency;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("report")
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void generateReport(@RequestBody @Valid EntryReportDto reportDto) {
        Report newReport = modelMapper.map(reportDto, Report.class);
        modelMapper.map(reportService.saveReport(newReport), EntryReportDto.class);

    }
}
