package com.testtask.rest_service.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@XmlRootElement
@Entity
@Table(name="bookorder")
public class BookOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cdate")
    @CreatedDate
    private Date cdate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rdate")
    private Date rdate;

    @Column(name="status")
    private String status;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToMany(/*fetch = FetchType.LAZY, */cascade = CascadeType.ALL)
    @JoinTable(name = "book_order",
            joinColumns = @JoinColumn
            (name = "order_id", referencedColumnName = "id"),
//            (name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn
            (name = "book_id", referencedColumnName = "id")
//            (name = "order_id", referencedColumnName = "id")
    )
    private List<Book> books;

    public BookOrder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public int getBookCount() {
        return getBooks().size();
    }

}
