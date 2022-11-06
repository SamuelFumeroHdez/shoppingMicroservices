package com.tienda.samuelfhz.service;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.ennumerations.Countries;

import java.util.List;
import java.util.Map;

public interface AddressService {

    List<Address> listAllAddressess();
    Address getAddress(Long id);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddress(Long id);
    Map<Countries, String> listAllCountries();
    List<Address> findByCustomer(Customer customer);

}
