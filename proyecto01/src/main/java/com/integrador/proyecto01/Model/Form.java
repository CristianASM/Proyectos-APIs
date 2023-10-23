package com.integrador.proyecto01.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "formulario_contacto")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String name;
    @Column(name = "correo", nullable = false, length = 45)
    private String email;
    @Column(name = "mensaje", nullable = false, length = 300)
    private String message;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate date;
}
