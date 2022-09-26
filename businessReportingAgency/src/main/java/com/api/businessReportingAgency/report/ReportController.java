package com.api.businessReportingAgency.report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/report")
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
    }

    @GetMapping("cnpj/{cnpj}")
    public OutReport displayReportByCnpj(@PathVariable String cnpj) {
        Report report = reportService.displayFullReport(cnpj);
        return modelMapper.map(report, OutReport.class);
    }

    @GetMapping("display")
    public List<OutReport> displayAllReports() {
        List<OutReport> userList = new ArrayList<>();
        for (Report report : reportService.displayAllReports()) {
            OutReport outReport = modelMapper.map(report, OutReport.class);
            userList.add(outReport);
        }
        return userList;
    }

    @PutMapping("cnpj/{cnpj}")
    public PartialReportDto updateReport(@PathVariable String cnpj,
                                         @RequestBody PartialReportDto partialReportDto) {
        Report report = reportService.apdateReport(cnpj, partialReportDto);
        return modelMapper.map(report, PartialReportDto.class);
    }


}
