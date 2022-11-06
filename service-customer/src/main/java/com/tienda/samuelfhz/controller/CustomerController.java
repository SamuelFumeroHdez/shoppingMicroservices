package com.tienda.samuelfhz.controller;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.repository.CustomerRepository;
import com.tienda.samuelfhz.service.AddressService;
import com.tienda.samuelfhz.service.CustomerService;
import com.tienda.samuelfhz.service.NumberIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private NumberIdService numberIdService;

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.listAllCustomers();
        return customers.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomer(id);

        return customer == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/numberId")
    public ResponseEntity<Customer> getCustomerByNumberId(@RequestParam(name = "number", required = true) String numberId){
        NumberId numberIdBD = numberIdService.findByNumber(numberId);
        Customer customer = customerService.getCustomerByNumber(numberIdBD);

        return customer == null ? ResponseEntity.noContent().build() : ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerCreated = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        customer.setId(id);
        Customer customerDB = customerService.updateCustomer(customer);
        return customerDB == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(customer);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
        Customer customerDeleted = customerService.deleteCustomer(id);

        return customerDeleted == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(customerDeleted);
    }


    
}
