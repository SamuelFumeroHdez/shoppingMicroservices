package com.tienda.samuelfhz.controller;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.ennumerations.Countries;
import com.tienda.samuelfhz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> listAllAddresses(@RequestParam(name = "customerId", required = false) Long customerId ){
        List<Address> addresses = null;

        if(customerId == null){
            addresses = addressService.listAllAddressess();
        }else{
            addresses = addressService.findByCustomer(Customer.builder().id(customerId).build());
        }

        return addresses.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(addresses);
    }

    @GetMapping(value = "/countries")
    public ResponseEntity<Map<Countries, String>> listCountries(){
        Map<Countries, String> mapCountries = addressService.listAllCountries();
        System.out.println(mapCountries);
        return (ResponseEntity.ok(mapCountries));
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        Address addressCreated = addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressCreated);
    }


}
