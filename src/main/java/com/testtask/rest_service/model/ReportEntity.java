package com.testtask.rest_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.Api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Api(value="Report Management System", description="Report pertaining to customer in Report Management System")
public class ReportEntity {
    @Id
    @Column(name="pk")
    private String pk;

    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="telephone")
    private String telephone;

    @JsonInclude
    @Column(name="status")
    private String status;

    @Column(name="book_count")
    private long bookCount;

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
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

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }
}
