package com.programacion.distribuida.customers.dtos;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
public class CurstomerDto {

    private String name;
    private String email;
    private Date deliveredor;
    private List<String> books;


}
