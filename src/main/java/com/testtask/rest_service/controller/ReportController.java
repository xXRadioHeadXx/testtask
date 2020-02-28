package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.ReportDTO;
import com.testtask.rest_service.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportRepository repository;

    @RequestMapping("/bild")
    public List<ReportDTO> bildReport(
              @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date to
            , @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date from
            , @RequestParam(defaultValue = "false", required = false, value = "status") Boolean status) {
        ReportDTO reportDTO = new ReportDTO();
        if(status) {
            return reportDTO.getReportDTOList(repository.bildReport(to, from));
        } else {
            return reportDTO.getReportDTOList(repository.bildReportClosed(to, from));
        }
    }

}
