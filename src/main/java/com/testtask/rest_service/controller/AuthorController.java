package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.AuthorDTO;
import com.testtask.rest_service.model.Author;
import com.testtask.rest_service.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository repository;

    @GetMapping("/all")
    public List<AuthorDTO> getAllAuthor(){
        AuthorDTO authorDTO = new AuthorDTO();
        return authorDTO.getAuthorDTOList(repository.findAll());
    }

    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author){
        return repository.save(author);
    }

    @DeleteMapping("/del/{id}")
    public void delAuthor(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Author> updAuthor(@RequestBody Author author, @PathVariable long id){
        Optional<Author> authorOptional = repository.findById(id);
        if(!authorOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        repository.save(author);
        return ResponseEntity.noContent().build();
    }
}
