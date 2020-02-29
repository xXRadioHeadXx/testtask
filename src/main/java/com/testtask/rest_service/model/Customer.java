package com.testtask.rest_service.model;

import io.swagger.annotations.Api;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@Entity
@Table(name="customer")
@Api(value="Customer Management System", description="Operations pertaining to customer in Customer Management System")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="telephone")
    private String telephone;

    @OneToMany(/*fetch = FetchType.LAZY,*/ mappedBy = "customer", cascade = CascadeType.ALL)
    private List<BookOrder> orders;

    public Customer() {
    }

    public Customer(String name, String telephone) {
        super();
        this.name = name;
        this.telephone = telephone;
    }

    public Customer(long id, String name, String telephone) {
        super();
        this.id = id;
        this.name = name;
        this.telephone = telephone;
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

    public List<BookOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<BookOrder> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(name, customer.name) &&
                Objects.equals(telephone, customer.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telephone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public int getBookOrderCount() {
        return getOrders().size();
    }
}
