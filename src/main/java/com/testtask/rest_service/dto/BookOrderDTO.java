package com.testtask.rest_service.dto;

import com.testtask.rest_service.model.Book;
import com.testtask.rest_service.model.BookOrder;
import com.testtask.rest_service.model.Customer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableTransactionManagement
public class BookOrderDTO {
    private long id;
    private Date cdate;
    private Date rdate;
    private String status;
    private Customer customer;
    private List<BookDTO> booksList;

    @Transactional
    public List<BookOrderDTO> getOrderDTOList (List<BookOrder> ordersList){
        List<BookOrderDTO> ordersDTOList = new ArrayList<>();

        for (BookOrder order : ordersList){

            BookOrderDTO orderDTO = new BookOrderDTO();
            orderDTO.setId(order.getId());
            orderDTO.setCdate(order.getCdate());
            orderDTO.setRdate(order.getRdate());
            orderDTO.setStatus(order.getStatus());
            order.getCustomer().setOrders(new ArrayList<BookOrder>());
            orderDTO.setCustomer(order.getCustomer());

            booksList = new ArrayList<>();
            for (Book books : order.getBooks()){
                BookDTO booksDTO = new BookDTO();

                booksDTO.setId(books.getId());
                booksDTO.setTitle(books.getTitle());
                booksDTO.setYear(books.getYear());
                booksDTO.setAnnotation(books.getAnnotation());
                booksDTO.setAuthorList(new ArrayList<AuthorDTO>());
                booksDTO.setOrderList(new ArrayList<BookOrderDTO>());
                booksList.add(booksDTO);
            }
            orderDTO.setBooksList(booksList);
            ordersDTOList.add(orderDTO);
        }
        return ordersDTOList;
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

    public List<BookDTO> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BookDTO> booksList) {
        this.booksList = booksList;
    }
}
