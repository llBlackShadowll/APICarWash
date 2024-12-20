package com.example.carwash.controllers;

import com.example.carwash.models.OtrosLavados;
import com.example.carwash.repositories.OtrosLavadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/otros-lavados")
public class OtrosLavadosController {
    @Autowired
    private OtrosLavadosRepository otrosLavadosRepository;

    @GetMapping
    public List<OtrosLavados> getAllOtrosLavados() {
        return otrosLavadosRepository.findAll();
    }

    @GetMapping("/{id}")
    public OtrosLavados getOtrosLavadosById(@PathVariable int id) {
        return otrosLavadosRepository.findById(id).orElse(null);
    }

    @PostMapping
    public OtrosLavados createOtrosLavados(@RequestBody OtrosLavados otrosLavados) {
        return otrosLavadosRepository.save(otrosLavados);
    }

    @PutMapping("/{id}")
    public OtrosLavados updateOtrosLavados(@PathVariable int id, @RequestBody OtrosLavados updatedOtrosLavados) {
        OtrosLavados otrosLavados = otrosLavadosRepository.findById(id).orElse(null);
        if (otrosLavados != null) {
            otrosLavados.setNombre(updatedOtrosLavados.getNombre());
            otrosLavados.setDescripcion(updatedOtrosLavados.getDescripcion());
            otrosLavados.setPrecio_auto(updatedOtrosLavados.getPrecio_auto());
            otrosLavados.setPrecio_camioneta(updatedOtrosLavados.getPrecio_camioneta());
            return otrosLavadosRepository.save(otrosLavados);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteOtrosLavados(@PathVariable int id) {
        otrosLavadosRepository.deleteById(id);
    }
}