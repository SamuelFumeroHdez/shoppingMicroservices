package com.tienda.samuelfhz.service;

import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CustomerService {
    List<Customer> listAllCustomers();
    Customer getCustomer(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Long id);
    Customer getCustomerByNumber(NumberId numberId);
}
