package com.programacion.distribuida.customers.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
public class BookDto {

    private String isbn;
    private String title;
    private BigDecimal price;

}
