package com.programacion.distribuida.customers.db;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CustomerBookId {

    @Column(name = "books_isbn")
    private String bookIsbn;

    @Column(name = "customers_id")
    private Integer customerId;
}
