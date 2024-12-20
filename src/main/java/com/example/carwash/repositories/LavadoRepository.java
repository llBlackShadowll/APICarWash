package com.example.carwash.repositories;

import com.example.carwash.models.Lavado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LavadoRepository extends JpaRepository<Lavado, Integer> {
}