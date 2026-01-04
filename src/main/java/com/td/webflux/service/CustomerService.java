package com.td.webflux.service;

import com.td.webflux.dao.CustomerDao;
import com.td.webflux.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;

    public List<Customer> fetchAllCustomers() {

        long startTime = System.currentTimeMillis();
        List<Customer> output= customerDao.getAllCustomers();

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken to process the request in millis : "+ (endTime - startTime));
        return output;

    }

    public Flux<Customer> fetchAllCustomersStream() {
        long startTime = System.currentTimeMillis();
        Flux<Customer> output= customerDao.getAllCustomersStream();

        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken to process the request in millis : "+ (endTime - startTime));
        return output;

    }
}
