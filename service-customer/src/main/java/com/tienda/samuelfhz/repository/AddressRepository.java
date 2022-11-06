package com.tienda.samuelfhz.repository;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByCustomer(Customer customer);
}
