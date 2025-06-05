package com.programacion.distribuida.customers.db;

import java.awt.print.Book;
import java.math.BigInteger;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "line_item")
public class LineItem {

    private Integer quantity;

   // private Book book;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idx;


    private BigInteger orderId;
}
