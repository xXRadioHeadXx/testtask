package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.BookDTO;
import com.testtask.rest_service.model.Book;
import com.testtask.rest_service.repositories.BookRepository;
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

    @GetMapping("/all")
    public List<BookDTO> getBook(){
        BookDTO booksDTO = new BookDTO();
        return booksDTO.getBookDTOList(repository.findAll());
    }

    @PostMapping("/add")
    public Book addBook(@RequestBody Book books){
        return repository.save(books);
    }

    @DeleteMapping("/del/{id}")
    public void delBook(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Object> updBook(@RequestBody Book book, @PathVariable long id){
        Optional<Book> booksOptional = repository.findById(id);
        if (!booksOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        repository.save(book);
        return ResponseEntity.noContent().build();
    }
}
