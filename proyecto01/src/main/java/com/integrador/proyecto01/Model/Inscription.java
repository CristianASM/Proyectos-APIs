package com.integrador.proyecto01.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "formulario_inscripcion")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String name;
    @Column(name = "nombre_estudiante", nullable = false, length = 45)
    private String studentName;
    @Column(name = "correo", nullable = false, length = 45)
    private String email;
    @Column(name = "numero_telefono", nullable = false, length = 15)
    private String phoneNumber;
    @Column(name = "turno", nullable = false)
    @Enumerated(EnumType.STRING)
    private Shift shift;
    @Column(name = "mensaje", nullable = false, length = 300)
    private String message;

}
