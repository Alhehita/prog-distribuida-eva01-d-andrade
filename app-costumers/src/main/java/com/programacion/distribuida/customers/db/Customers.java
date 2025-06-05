package com.programacion.distribuida.customers.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @Column(length = 128)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(length = 128)
    private String email;

    @Column(length = 128)
    private String name;

    private Integer version = 1;

    @OneToOne(mappedBy = "customer")
    private PurcharseOrder purcharseOrder;

}
