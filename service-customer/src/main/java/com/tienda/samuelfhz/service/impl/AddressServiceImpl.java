package com.tienda.samuelfhz.service.impl;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.ennumerations.Countries;
import com.tienda.samuelfhz.entity.ennumerations.Status;
import com.tienda.samuelfhz.repository.AddressRepository;
import com.tienda.samuelfhz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public List<Address> listAllAddressess() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public Address createAddress(Address address) {
        address.setStatus(Status.CREATED);
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Address address) {
        Address addressDB = getAddress(address.getId());
        if(addressDB == null){
            return null;
        }

        addressDB.setCountry(address.getCountry());
        addressDB.setCity(address.getCity());
        addressDB.setZipCode(address.getZipCode());
        addressDB.setStreet(address.getStreet());
        addressDB.setNumber(address.getNumber());
        addressDB.setStatus(Status.MODIFIED);

        return addressRepository.save(addressDB);
    }

    @Override
    public Address deleteAddress(Long id) {
        Address addressDB = getAddress(id);
        if(addressDB == null){
            return null;
        }

        addressDB.setStatus(Status.DELETED);
        return addressRepository.save(addressDB);
    }

    @Override
    public Map<Countries, String> listAllCountries() {
        Map<Countries, String> mapCountries = new HashMap<>();
        Countries[] listCountries = Countries.values();
        for(int i=0 ; i<listCountries.length ; i++){
            mapCountries.put(listCountries[i], listCountries[i].getCountryString());
        }

        return mapCountries;
    }

    @Override
    public List<Address> findByCustomer(Customer customer) {
        return addressRepository.findByCustomer(customer);
    }
}
