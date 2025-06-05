package com.programacion.distribuida.customers.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books_customers")
@Getter
@Setter
public class CustomerBook {

    @EmbeddedId
    private CustomerBookId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name ="books_isbn", nullable = false)

    private Customers customers;

}
