package com.example.lab5.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="viajes")
@Getter
@Setter
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idViajes;

    private String punto_recojo;
    private String cant_personas;
    private String cant_perros;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares")
    private Lugares lugares;
}
