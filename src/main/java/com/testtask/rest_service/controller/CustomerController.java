package com.testtask.rest_service.controller;

import com.testtask.rest_service.dto.CustomerDTO;
import com.testtask.rest_service.model.Customer;
import com.testtask.rest_service.repositories.CustomerRepository;
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

    @GetMapping("/all")
    public List<CustomerDTO> getAllCustomer(){
        CustomerDTO customerDTO = new CustomerDTO();
        return customerDTO.getCustomerDTOList(repository.findAll());
    }

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return repository.save(customer);
    }

    @DeleteMapping("/del/{id}")
    public void delCustomer(@PathVariable long id){
        repository.deleteById(id);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Customer> updCustomer(@RequestBody Customer customer, @PathVariable long id){
        Optional<Customer> customerOptional = repository.findById(id);
        if(!customerOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        customer.setId(id);
        repository.save(customer);
        return ResponseEntity.noContent().build();
    }

//    @GetMapping("/report/{all,to, from}")
//    public List<CustomerDTO> getAllCustomer(){
//        OrderRepository orderRepository = new OrderRepository();
//        Iterable<Long> listCustomerId;
//        CustomerDTO customerDTO = new CustomerDTO();
//        return customerDTO.getCustomerDTOList(repository.findAll());
//    }
}
