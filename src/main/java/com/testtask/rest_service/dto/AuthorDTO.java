package com.testtask.rest_service.dto;

import com.testtask.rest_service.model.Author;
import com.testtask.rest_service.model.Book;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
public class AuthorDTO {
    private long id;
    private String name;
    private String year;
    private List<BookDTO> booksList;

    @Transactional
    public List<AuthorDTO> getAuthorDTOList(List<Author> authorList){
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author : authorList){
            booksList = new ArrayList<>();

            AuthorDTO authorDTO = new AuthorDTO();
            authorDTO.setId(author.getId());
            authorDTO.setName(author.getName());
            authorDTO.setYear(author.getYear());

            for (Book books : author.getBooks()){
                BookDTO booksDTO = new BookDTO();

                booksDTO.setId(books.getId());
                booksDTO.setTitle(books.getTitle());
                booksDTO.setYear(books.getYear());
                booksDTO.setAnnotation(books.getAnnotation());
                booksDTO.setAuthorList(new ArrayList<AuthorDTO>());
                booksList.add(booksDTO);
            }
            authorDTO.setBooksList(booksList);
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<BookDTO> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<BookDTO> booksList) {
        this.booksList = booksList;
    }
}
