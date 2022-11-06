package com.tienda.samuelfhz.repository;

import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNumberId(NumberId numberId);
}
