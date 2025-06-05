package com.programacion.distribuida.customers.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="purcharse_order")
@Getter
@Setter
public class PurcharseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private Date deliveredor;

    private Date placedon;

    private Integer status;

    private Integer total;

    @OneToOne
    @JoinColumn(name = "purcharseOrder")
    private Customers customer;
}
