package com.example.carwash.controllers;

import com.example.carwash.models.Mecanica;
import com.example.carwash.repositories.MecanicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mecanica")
public class MecanicaController {
    @Autowired
    private MecanicaRepository mecanicaRepository;

    @GetMapping
    public List<Mecanica> getAllMecanica() {
        return mecanicaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mecanica getMecanicaById(@PathVariable int id) {
        return mecanicaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Mecanica createMecanica(@RequestBody Mecanica mecanica) {
        return mecanicaRepository.save(mecanica);
    }

    @PutMapping("/{id}")
    public Mecanica updateMecanica(@PathVariable int id, @RequestBody Mecanica updatedMecanica) {
        Mecanica mecanica = mecanicaRepository.findById(id).orElse(null);
        if (mecanica != null) {
            mecanica.setNombre(updatedMecanica.getNombre());
            mecanica.setDescripcion(updatedMecanica.getDescripcion());
            mecanica.setPrecio_auto(updatedMecanica.getPrecio_auto());
            mecanica.setPrecio_camioneta(updatedMecanica.getPrecio_camioneta());
            return mecanicaRepository.save(mecanica);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteMecanica(@PathVariable int id) {
        mecanicaRepository.deleteById(id);
    }
}