package com.api.businessReportingAgency;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public void deleteReport (@PathVariable Long id){
        reportService.deleteReport(id);
    }

}
