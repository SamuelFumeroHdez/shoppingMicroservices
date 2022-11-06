package com.tienda.samuelfhz.service.impl;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.entity.ennumerations.Status;
import com.tienda.samuelfhz.repository.CustomerRepository;
import com.tienda.samuelfhz.service.AddressService;
import com.tienda.samuelfhz.service.CustomerService;
import com.tienda.samuelfhz.service.NumberIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private NumberIdService numberIdService;


    @Override
    public List<Customer> listAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setStatus(Status.CREATED);
        List<Address> addresses = customer.getAddress();
        for(Address a : addresses){
            a.setCustomer(customer);
            addressService.createAddress(a);
        }
        Customer customerCreated = customerRepository.save(customer);
        return customerCreated;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer customerDB = getCustomer(customer.getId());
        if(customerDB == null){
            return null;
        }
        customerDB.setName(customer.getName());
        customerDB.setSurname(customer.getSurname());
        customerDB.setPhoneNumber(customer.getPhoneNumber());
        customerDB.setEmail(customer.getEmail());
        customerDB.setStatus(Status.MODIFIED);
        customerDB.setAddress(customer.getAddress());

        return customerDB;
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customerDB = getCustomer(id);
        if(customerDB == null){
            return null;
        }
        customerDB.setStatus(Status.DELETED);
        return customerDB;
    }

    @Override
    public Customer getCustomerByNumber(NumberId numberId) {
        return customerRepository.findByNumberId(numberId);
    }
}
