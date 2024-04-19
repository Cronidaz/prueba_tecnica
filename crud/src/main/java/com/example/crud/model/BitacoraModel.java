package com.example.crud.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class BitacoraModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Boolean isLog;

    @OneToOne
    private UserModel user;
}
