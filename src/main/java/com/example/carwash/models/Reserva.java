package com.example.carwash.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    private LocalDate fecha;
    private LocalTime hora;

    @Enumerated(EnumType.STRING)
    private Servicio servicio;

    @Enumerated(EnumType.STRING)
    private TipoVehiculo tipoVehiculo;

    public enum Servicio {
        Lavado,
        Servicios_Especiales,
        Mecanica,
        Otros_Lavados
    }

    public enum TipoVehiculo {
        Auto,
        Camioneta
    }
}