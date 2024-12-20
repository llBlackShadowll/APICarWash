package com.example.carwash.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;

    private String nombre;
    @Column(unique = true) // Asegura que no se repita en la base de datos
    private String email;
    private String contrasena;
    private String celular;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        Cliente,
        Admin
    }
}