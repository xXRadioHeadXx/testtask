package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.BookOrderDTO;
import com.testtask.rest_service.model.BookOrder;
import com.testtask.rest_service.repositories.BookOrderRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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


    @ApiOperation(value = "View a list of available orders", response = List.class)    @GetMapping("/all")
    public List<BookOrderDTO> getAllOrder(){
        BookOrderDTO orderDTO = new BookOrderDTO();
        return orderDTO.getOrderDTOList(repository.findAll());
    }

    @ApiOperation(value = "Add an Order")
    @PostMapping("/add")
    public BookOrder addOrder(
            @ApiParam(value = "Order object store in database table", required = true) @RequestBody BookOrder order){
        return repository.save(order);
    }

    @ApiOperation(value = "Delete an Order")
    @DeleteMapping("/del/{id}")
    public void delOrder(
            @ApiParam(value = "Order Id to delete order object", required = true) @PathVariable long id){
        repository.deleteById(id);
    }

    @ApiOperation(value = "Update an Order")
    @PutMapping("/upd/{id}")
    public ResponseEntity<BookOrder> updOrder(
            @ApiParam(value = "Update order object", required = true) @RequestBody BookOrder order,
            @ApiParam(value = "Order Id to update order object", required = true) @PathVariable long id){
        Optional<BookOrder> orderOptional = repository.findById(id);
        if(!orderOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        order.setId(id);
        repository.save(order);
        return ResponseEntity.noContent().build();
    }
}
