package com.testtask.rest_service.dto;

import com.testtask.rest_service.model.Author;
import com.testtask.rest_service.model.Book;
import com.testtask.rest_service.model.BookOrder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
public class BookDTO {
    private long id;
    private String title;
    private String year;
    private String annotation;
    private List<AuthorDTO> authorList;
    private List<BookOrderDTO> orderList;

    @Transactional
    public List<BookDTO> getBookDTOList (List<Book> booksList){
        List<BookDTO> booksDTOList = new ArrayList<>();

        for (Book books : booksList){

            BookDTO booksDTO = new BookDTO();
            booksDTO.setId(books.getId());
            booksDTO.setTitle(books.getTitle());
            booksDTO.setYear(books.getYear());
            booksDTO.setAnnotation(books.getAnnotation());

            authorList = new ArrayList<>();
            for (Author author : books.getAuthors()){
                AuthorDTO authorDTO = new AuthorDTO();
                authorDTO.setId(author.getId());
                authorDTO.setName(author.getName());
                authorDTO.setYear(author.getYear());
                authorDTO.setBooksList(new ArrayList<BookDTO>());
                authorList.add(authorDTO);
            }

            orderList = new ArrayList<>();
            for (BookOrder order : books.getOrders()){
                BookOrderDTO orderDTO = new BookOrderDTO();
                orderDTO.setId(order.getId());
                orderDTO.setCdate(order.getCdate());
                orderDTO.setRdate(order.getRdate());
                orderDTO.setStatus(order.getStatus());
                orderList.add(orderDTO);
            }

            booksDTO.setAuthorList(authorList);
            booksDTO.setOrderList(orderList);

            booksDTOList.add(booksDTO);

        }
        return booksDTOList;
    }

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

    public List<AuthorDTO> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<AuthorDTO> authorList) {
        this.authorList = authorList;
    }

    public List<BookOrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<BookOrderDTO> orderList) {
        this.orderList = orderList;
    }
}
