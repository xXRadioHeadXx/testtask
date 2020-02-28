package com.testtask.rest_service.dto;

import com.testtask.rest_service.model.BookOrder;
import com.testtask.rest_service.model.Customer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement
public class CustomerDTO {
    private long id;
    private String name;
    private String telephone;
    private List<BookOrderDTO> orderList;

    @Transactional
    public List<CustomerDTO> getCustomerDTOList (List<Customer> customersList){
        List<CustomerDTO> customersDTOList = new ArrayList<>();

        for (Customer customer : customersList){

            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setId(customer.getId());
            customerDTO.setName(customer.getName());
            customerDTO.setTelephone(customer.getTelephone());

            orderList = new ArrayList<>();
            for (BookOrder order : customer.getOrders()){
                BookOrderDTO orderDTO = new BookOrderDTO();

                orderDTO.setId(order.getId());
                orderDTO.setCdate(order.getCdate());
                orderDTO.setRdate(order.getRdate());
                orderDTO.setStatus(order.getStatus());
                orderList.add(orderDTO);
            }
            customerDTO.setOrderList(orderList);
            customersDTOList.add(customerDTO);
        }
        return customersDTOList;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<BookOrderDTO> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<BookOrderDTO> orderList) {
        this.orderList = orderList;
    }
}
