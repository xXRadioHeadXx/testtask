package com.testtask.rest_service.model;

import io.swagger.annotations.Api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement
@Entity
@Table(name="book")
@Api(value="Book Management System", description="Operations pertaining to book in Book Management System")
public class Book implements Serializable {
    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="year")
    private String year;

    @Column(name="annotation")
    private String annotation;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<BookOrder> orders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public long getAuthorCount() {
        return getAuthors().size();
    }

    public List<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<BookOrder> orders) {
        this.orders = orders;
    }

    public int getBookOrdersCount() {
        return getOrders().size();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", annotation='" + annotation + '\'' +
                ", authors=" + authors +
                '}';
    }
}
