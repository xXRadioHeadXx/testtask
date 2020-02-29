package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.BookDTO;
import com.testtask.rest_service.model.Book;
import com.testtask.rest_service.repositories.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository repository;


    @ApiOperation(value = "View a list of available books", response = List.class)    @GetMapping("/all")
    public List<BookDTO> getBook(){
        BookDTO booksDTO = new BookDTO();
        return booksDTO.getBookDTOList(repository.findAll());
    }

    @ApiOperation(value = "Add an Book")
    @PostMapping("/add")
    public Book addBook(
            @ApiParam(value = "Book object store in database table", required = true) @RequestBody Book books){
        return repository.save(books);
    }

    @ApiOperation(value = "Delete an Book")
    @DeleteMapping("/del/{id}")
    public void delBook(
            @ApiParam(value = "Book Id to delete book object", required = true) @PathVariable long id){
        repository.deleteById(id);
    }

    @ApiOperation(value = "Update an Book")
    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updBook(
            @ApiParam(value = "Update book object", required = true) @RequestBody Book book,
            @ApiParam(value = "Book Id to update book object", required = true) @PathVariable long id){
        Optional<Book> booksOptional = repository.findById(id);
        if (!booksOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        repository.save(book);
        return ResponseEntity.noContent().build();
    }
}
