package com.experis.se.hampus.olsson.MusicDatabase.contollers;

import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.data_access.CustomerRepository;
import com.experis.se.hampus.olsson.MusicDatabase.models.Customer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    CustomerRepository customerRepo = new CustomerRepository();

    @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepo.getAllCustomers();
    }

    //Set endpoints
    @RequestMapping(value = "api/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerFromId(@PathVariable int id) { return customerRepo.getCustomerFromId(id);}
}
   
    

