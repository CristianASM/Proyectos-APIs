package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "informacion_contacto")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String name;
    @Column(name = "correo", nullable = false, length = 60)
    private String email;
    @Column(name = "mensaje", nullable = false, length = 300)
    private String message;
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime date;
}
