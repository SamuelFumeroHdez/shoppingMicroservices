package com.tienda.samuelfhz.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Date;

@Entity
@Table(name = "SFHZPRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @NotEmpty(message = "El nombre del campo no debe ser vacío")
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;


    @Column(name = "STOCK")
    private Double stock;

    @Positive(message = "El precio debe ser mayor de cero")
    @Column(name = "PRICE")
    private Double price;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Category category;
}
