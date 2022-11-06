package com.tienda.samuelfhz.controller;

import com.tienda.samuelfhz.entity.Customer;
import com.tienda.samuelfhz.entity.NumberId;
import com.tienda.samuelfhz.service.NumberIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/numberIds")
public class NumberIdController {

    @Autowired
    private NumberIdService numberIdService;

    @GetMapping
    public ResponseEntity<List<NumberId>> listAllNumberIds(){
        List<NumberId> numberIds = numberIdService.listAllNumberIds();
        return numberIds.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(numberIds);
    }

    @GetMapping(value = "/{number}")
    public ResponseEntity<NumberId> getNumberIdByNumber(@PathVariable("number") String number){
        NumberId numberId = numberIdService.findByNumber(number);

        return numberId == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(numberId);
    }

    @PostMapping
    public ResponseEntity<NumberId> createNumberId(@RequestBody NumberId numberId){
        NumberId numberIdDB = numberIdService.createNumberId(numberId);

        return ResponseEntity.status(HttpStatus.CREATED).body(numberIdDB);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NumberId> updateNumberId(@PathVariable("id") Long id, @RequestBody NumberId numberId){
        numberId.setId(id);
        NumberId numberIdDB = numberIdService.updateNumberId(numberId);
        return numberIdDB == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(numberIdDB);
    }

}
