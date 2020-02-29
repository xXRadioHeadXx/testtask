package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.AuthorDTO;
import com.testtask.rest_service.model.Author;
import com.testtask.rest_service.repositories.AuthorRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository repository;

    @ApiOperation(value = "View a list of available authors", response = List.class)
    @GetMapping("/all")
    public List<AuthorDTO> getAllAuthor(){
        AuthorDTO authorDTO = new AuthorDTO();
        return authorDTO.getAuthorDTOList(repository.findAll());
    }

    @ApiOperation(value = "Add an Author")
    @PostMapping("/add")
    public Author addAuthor(
            @ApiParam(value = "Author object store in database table", required = true) @Valid @RequestBody Author author){
        return repository.save(author);
    }

    @ApiOperation(value = "Delete an Author")
    @DeleteMapping("/del/{id}")
    public void delAuthor(@ApiParam(value = "Author Id to delete author object", required = true) @PathVariable long id){
        repository.deleteById(id);
    }

    @ApiOperation(value = "Update an Author")
    @PutMapping("/upd/{id}")
    public ResponseEntity<Author> updAuthor(@ApiParam(value = "Update author object", required = true) @Valid @RequestBody Author author,
                                            @ApiParam(value = "Author Id to update author object", required = true) @PathVariable long id){
        Optional<Author> authorOptional = repository.findById(id);
        if(!authorOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        repository.save(author);
        return ResponseEntity.noContent().build();
    }
}
