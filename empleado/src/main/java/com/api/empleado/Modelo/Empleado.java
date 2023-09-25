package com.api.empleado.Modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "DNI", nullable = false)
    private int DNI;
    @Column(name = "genero", nullable = false)
    private Genero genero;
}
