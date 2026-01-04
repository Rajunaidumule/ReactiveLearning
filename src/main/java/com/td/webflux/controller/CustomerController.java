package com.td.webflux.controller;

import com.td.webflux.model.Customer;
import com.td.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.fetchAllCustomers();
    }
}
