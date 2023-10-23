package com.integrador.proyecto01.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "formulario_afiliado")
public class Affiliate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String name;
    @Column(name = "correo", nullable = false, length = 45)
    private String email;
    @Column(name = "numero_telefono", nullable = false, length = 15)
    private String phoneNumber;
}
