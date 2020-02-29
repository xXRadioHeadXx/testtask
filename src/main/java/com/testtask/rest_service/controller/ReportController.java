package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.ReportDTO;
import com.testtask.rest_service.repositories.ReportRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
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


    @ApiOperation(value = "View a report", response = List.class)
//    @RequestMapping("/bild")
    @GetMapping("/bild")
    public List<ReportDTO> bildReport(
            @ApiParam(value = "Date to bild report", required = true) @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date to
            , @ApiParam(value = "Date from bild report", required = true) @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date from
            , @ApiParam(value = "Mode group by status order. Value true is group by status. Default false. ", required = false) @RequestParam(defaultValue = "false", required = false, value = "status") Boolean status) {
        ReportDTO reportDTO = new ReportDTO();
        if(status) {
            return reportDTO.getReportDTOList(repository.bildReport(to, from));
        } else {
            return reportDTO.getReportDTOList(repository.bildReportClosed(to, from));
        }
    }

}
