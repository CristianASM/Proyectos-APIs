package com.api.exceptions.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String name;
    @Column(name = "apellido", nullable = false, length = 60)
    private String lastName;
    @Column(name = "correo", nullable = false, length = 45)
    private String email;
    @Column(name = "genero", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
