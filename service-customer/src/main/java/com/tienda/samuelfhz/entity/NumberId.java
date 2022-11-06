package com.tienda.samuelfhz.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.tienda.samuelfhz.entity.ennumerations.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "SFHZNUMBERID")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NumberId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER")
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private Type type;


}
