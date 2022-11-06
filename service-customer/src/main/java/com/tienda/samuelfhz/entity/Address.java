package com.tienda.samuelfhz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tienda.samuelfhz.entity.ennumerations.Countries;
import com.tienda.samuelfhz.entity.ennumerations.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "SFHZADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY")
    private Countries country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "STREET")
    private String street;

    @Column(name = "NUMBER")
    private int number;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "address"})
    private Customer customer;
}
