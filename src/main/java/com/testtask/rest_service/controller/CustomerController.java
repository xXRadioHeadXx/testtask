package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.CustomerDTO;
import com.testtask.rest_service.model.Customer;
import com.testtask.rest_service.repositories.CustomerRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository repository;


    @ApiOperation(value = "View a list of available customers", response = List.class)
    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        return customerDTO.getCustomerDTOList(repository.findAll());
    }

    @ApiOperation(value = "Add an Customer")
    @PostMapping("/add")
    public Customer addCustomer(
            @ApiParam(value = "Customer object store in database table", required = true) @RequestBody Customer customer){
        return repository.save(customer);
    }

    @ApiOperation(value = "Delete an Customer")
    @DeleteMapping("/del/{id}")
    public void delCustomer(
            @ApiParam(value = "Customer Id to delete customer object", required = true) @PathVariable long id){
        repository.deleteById(id);
    }

    @ApiOperation(value = "Update an Customer")
    @PutMapping("/upd/{id}")
    public ResponseEntity<Customer> updCustomer(
            @ApiParam(value = "Update customer object", required = true) @RequestBody Customer customer,
            @ApiParam(value = "Customer Id to update customer object", required = true) @PathVariable long id){
        Optional<Customer> customerOptional = repository.findById(id);
        if(!customerOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        repository.save(customer);
        return ResponseEntity.noContent().build();
    }
}
