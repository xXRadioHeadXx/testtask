package com.testtask.rest_service.dto;

import com.testtask.rest_service.model.ReportEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
public class ReportDTO {
    private long id;
    private String name;
    private String telephone;
    private String status;
    private long countBook;

    @Transactional
    public List<ReportDTO> getReportDTOList (List<ReportEntity> reportsList){
        List<ReportDTO> reportsDTOList = new ArrayList<>();

        for (ReportEntity report : reportsList){

            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setId(report.getId());
            reportDTO.setName(report.getName());
            reportDTO.setTelephone(report.getTelephone());
            reportDTO.setStatus(report.getStatus());
            reportDTO.setCountBook(report.getBookCount());

            reportsDTOList.add(reportDTO);
        }
        return reportsDTOList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCountBook() {
        return countBook;
    }

    public void setCountBook(long countBook) {
        this.countBook = countBook;
    }
}
