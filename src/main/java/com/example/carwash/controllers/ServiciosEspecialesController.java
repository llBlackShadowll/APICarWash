package com.example.carwash.controllers;

import com.example.carwash.models.ServiciosEspeciales;
import com.example.carwash.repositories.ServiciosEspecialesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios-especiales")
public class ServiciosEspecialesController {
    @Autowired
    private ServiciosEspecialesRepository serviciosEspecialesRepository;

    @GetMapping
    public List<ServiciosEspeciales> getAllServiciosEspeciales() {
        return serviciosEspecialesRepository.findAll();
    }

    @GetMapping("/{id}")
    public ServiciosEspeciales getServiciosEspecialesById(@PathVariable int id) {
        return serviciosEspecialesRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ServiciosEspeciales createServiciosEspeciales(@RequestBody ServiciosEspeciales servicio) {
        return serviciosEspecialesRepository.save(servicio);
    }

    @PutMapping("/{id}")
    public ServiciosEspeciales updateServiciosEspeciales(@PathVariable int id, @RequestBody ServiciosEspeciales updatedServicio) {
        ServiciosEspeciales servicio = serviciosEspecialesRepository.findById(id).orElse(null);
        if (servicio != null) {
            servicio.setNombre(updatedServicio.getNombre());
            servicio.setDescripcion(updatedServicio.getDescripcion());
            servicio.setPrecio_auto(updatedServicio.getPrecio_auto());
            servicio.setPrecio_camioneta(updatedServicio.getPrecio_camioneta());
            return serviciosEspecialesRepository.save(servicio);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteServiciosEspeciales(@PathVariable int id) {
        serviciosEspecialesRepository.deleteById(id);
    }
}