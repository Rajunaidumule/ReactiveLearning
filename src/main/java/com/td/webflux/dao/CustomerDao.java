package com.td.webflux.dao;

import com.td.webflux.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Component
public class CustomerDao {

    public List<Customer> getAllCustomers() {
        return IntStream.rangeClosed(1,50).peek(CustomerDao::stopForOneSecon).peek(i->System.out.println("processing "+ i)).mapToObj(number ->
             new Customer(number,"name"+ number)
        ).collect(Collectors.toList());
    }

    public static void stopForOneSecon(int i){
        try{
           Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println("exception occurred"+ e);
        }
    }
}
