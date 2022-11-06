package com.tienda.samuelfhz.service.impl;

import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.repository.CustomerRepository;
import com.tienda.samuelfhz.repository.NumberIdRepository;
import com.tienda.samuelfhz.service.CustomerService;
import com.tienda.samuelfhz.service.NumberIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NumberIdServiceImpl implements NumberIdService {

    @Autowired
    private NumberIdRepository numberIdRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<NumberId> listAllNumberIds() {
        return numberIdRepository.findAll();
    }

    @Override
    public NumberId getNumberId(Long id) {
        return numberIdRepository.findById(id).orElse(null);
    }

    @Override
    public NumberId createNumberId(NumberId numberId) {
        //numberId.getCustomer().setName(customerRepository.findById(numberId.getCustomer().getId()).orElse(new Customer()).getName());
        return numberIdRepository.save(numberId);
    }

    @Override
    public NumberId updateNumberId(NumberId numberId) {
        NumberId numberIdDB = numberIdRepository.findById(numberId.getId()).orElse(null);
        if(numberIdDB == null){
            return null;
        }
        numberIdDB.setNumber(numberId.getNumber());
        //numberIdDB.setCustomer(numberId.getCustomer());
        numberIdDB.setType(numberId.getType());
        return numberIdRepository.save(numberIdDB);

    }

    @Override
    public NumberId findByNumber(String number){
        return numberIdRepository.findByNumber(number);
    }

}
