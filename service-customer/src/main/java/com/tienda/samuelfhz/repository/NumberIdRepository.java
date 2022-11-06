package com.tienda.samuelfhz.repository;

import com.tienda.samuelfhz.entity.NumberId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberIdRepository extends JpaRepository<NumberId, Long> {
    NumberId findByNumber(String number);
}
