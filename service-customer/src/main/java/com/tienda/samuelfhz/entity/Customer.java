package com.tienda.samuelfhz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tienda.samuelfhz.entity.ennumerations.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Table( name = "SFHZCUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Email(message = "La dirección de email no es válida")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "NUMBER_ID")
    private NumberId numberId;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("customer")
    private List<Address> address;
}
