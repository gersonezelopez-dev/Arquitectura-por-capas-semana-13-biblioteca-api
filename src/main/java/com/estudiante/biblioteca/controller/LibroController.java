
package com.estudiante.biblioteca.controller;

import com.estudiante.biblioteca.entity.Libro;
import com.estudiante.biblioteca.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository repositorio;

    public LibroController(LibroRepository repositorio) {
        this.repositorio = repositorio;
    }
    @GetMapping
    public ResponseEntity<List<Libro>> listar() {
        return ResponseEntity.ok(repositorio.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Long id) {
        return repositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Libro> registrar(@RequestBody Libro libro) {
        libro.setId(null);
        Libro guardado = repositorio.save(libro);
        return ResponseEntity.status(201).body(guardado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(
            @PathVariable Long id,
            @RequestBody Libro datos) {

        return repositorio.findById(id).map(libro -> {
            libro.setCodigo(datos.getCodigo());
            libro.setTitulo(datos.getTitulo());
            libro.setAutor(datos.getAutor());
            libro.setCategoria(datos.getCategoria());
            libro.setAnioPublicacion(datos.getAnioPublicacion());
            libro.setPrecio(datos.getPrecio());
            libro.setDisponible(datos.getDisponible());

            return ResponseEntity.ok(repositorio.save(libro));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Libro>> porCategoria(
            @PathVariable String categoria) {
        return ResponseEntity.ok(
                repositorio.findByCategoria(categoria));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> disponibles() {
        return ResponseEntity.ok(
                repositorio.findByDisponibleTrue());
    }
}
