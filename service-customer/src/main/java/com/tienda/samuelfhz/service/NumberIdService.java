package com.tienda.samuelfhz.service;

import com.tienda.samuelfhz.entity.Address;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.entity.ennumerations.Countries;

import java.util.List;
import java.util.Map;

public interface NumberIdService {
    List<NumberId> listAllNumberIds();
    NumberId getNumberId(Long id);
    NumberId createNumberId(NumberId numberId);
    NumberId updateNumberId(NumberId numberId);
    NumberId findByNumber(String number);
}
