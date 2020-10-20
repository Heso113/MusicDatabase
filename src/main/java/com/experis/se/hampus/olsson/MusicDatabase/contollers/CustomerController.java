package com.experis.se.hampus.olsson.MusicDatabase.contollers;

import java.util.ArrayList;

import com.experis.se.hampus.olsson.MusicDatabase.data_access.CustomerRepository;
import com.experis.se.hampus.olsson.MusicDatabase.models.Customer;
import com.experis.se.hampus.olsson.MusicDatabase.models.Invoice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    CustomerRepository customerRepo = new CustomerRepository();

    @RequestMapping(value = "/api/fetch/customers", method = RequestMethod.GET)
    public ArrayList<Customer> getAllCustomers(){
        return customerRepo.getAllCustomers();
    }

    @RequestMapping(value = "/api/update/customer", method = RequestMethod.PUT)
    public Boolean updateCustomer(@RequestBody Customer customer){
        return customerRepo.updateCustomer(customer);
    }
    @RequestMapping(value = "/api/create/customer", method = RequestMethod.POST)
    public Boolean addCustomer(@RequestBody Customer customer){
        return customerRepo.addCustomer(customer);
}
    @RequestMapping(value = "/api/fetch/countrystats", method = RequestMethod.GET)
    public ArrayList<Customer> getCustomersInEachCountry(){
    return customerRepo.getCustomersInEachCountry();
}
    @RequestMapping(value = "/api/fetch/customers/invoice", method = RequestMethod.GET)
    public ArrayList<Invoice> getCustomersTotalInvoice(){
    return customerRepo.getCustomersTotalInvoice();
}
    @RequestMapping(value = "api/fetch/customer/favoritegenre/{id}", method = RequestMethod.GET)
    public Customer getCustomerGenre(@PathVariable int id) { 
    return customerRepo.getCustomerGenre(id);
}   
}
   
    

