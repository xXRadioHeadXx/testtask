package com.testtask.rest_service.model;

import io.swagger.annotations.Api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Api(value="Author Management System", description="Operations pertaining to author in Author Management System")
@XmlRootElement
@Entity
@Table(name="author")
public class Author implements Serializable{
    public Author() {
    }

    public Author(String name, String year) {
        super();
        this.name = name;
        this.year = year;
    }

    public Author(long id, String name, String year) {
        super();
        this.id = id;
        this.name = name;
        this.year = year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="year")
    private String year;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn
//            (name = "book_id", referencedColumnName = "id"),
            (name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn
//            (name = "author_id", referencedColumnName = "id")
            (name = "book_id", referencedColumnName = "id")
    )

    private List<Book> books;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", books=" + books +
                '}';
    }
}
