package com.example.carwash.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Lavado")
public class Lavado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_servicio;

    private String nombre;
    private double precio_auto;
    private double precio_camioneta;
}