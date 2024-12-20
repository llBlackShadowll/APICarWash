package com.example.carwash.controllers;

import com.example.carwash.models.Usuario;
import com.example.carwash.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtener todos los usuarios
     * @return Lista de usuarios registrados
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    /**
     * Crear un nuevo usuario
     * @param usuario Detalles del usuario a registrar
     * @return Usuario creado o un conflicto si el email ya está en uso
     */
    @PostMapping
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El email ya está en uso.");
        }
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    /**
     * Inicio de sesión
     * @param usuario Objeto con email y contraseña
     * @return Detalles del usuario autenticado o error si las credenciales son incorrectas
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (existingUsuario != null && existingUsuario.getContrasena().equals(usuario.getContrasena())) {
            return ResponseEntity.ok(existingUsuario);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas.");
    }
}