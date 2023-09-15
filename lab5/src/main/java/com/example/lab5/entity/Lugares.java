package com.example.lab5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="lugares")
@Getter
@Setter
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLugares;

    private String nombre_lugar;
    private String descrip_lugar;
    private Date fecha_lugar;

}
