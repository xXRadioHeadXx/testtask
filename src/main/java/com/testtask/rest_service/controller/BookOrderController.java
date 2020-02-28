package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.BookOrderDTO;
import com.testtask.rest_service.model.BookOrder;
import com.testtask.rest_service.repositories.BookOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookorders")
public class BookOrderController {
    @Autowired
    private BookOrderRepository repository;

    @GetMapping("/all")
    public List<BookOrderDTO> getAllOrder(){
        BookOrderDTO orderDTO = new BookOrderDTO();
        return orderDTO.getOrderDTOList(repository.findAll());
    }

    @PostMapping("/add")
    public BookOrder addOrder(@RequestBody BookOrder order){
        return repository.save(order);
    }

    @DeleteMapping("/del/{id}")
    public void delOrder(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<BookOrder> updOrder(@RequestBody BookOrder order, @PathVariable long id){
        Optional<BookOrder> orderOptional = repository.findById(id);
        if(!orderOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        repository.save(order);
        return ResponseEntity.noContent().build();
    }
}
