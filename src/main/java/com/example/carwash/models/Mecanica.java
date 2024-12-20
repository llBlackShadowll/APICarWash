package com.example.carwash.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Mecanica")
public class Mecanica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;

    private String nombre;
    private String descripcion;
    private double precio_auto;
    private double precio_camioneta;
}