package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.Libro;
import edu.sena.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroRestController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libroService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Libro> obtenerLibroPorId(@PathVariable Integer id) {
        return libroService.buscarPorId(id);
    }

    @PostMapping
    public Libro guardarLibro(@RequestBody Libro libro) {
        return libroService.guardar(libro);
    }

    @PutMapping("/{id}")
    public Optional<Libro> actualizarLibro(@PathVariable Integer id, @RequestBody Libro libro) {
        return libroService.actualizar(id, libro);
    }

    @GetMapping("/buscar")
    public List<Libro> buscarLibros(@RequestParam(required = false) String titulo,
                                    @RequestParam(required = false) String autor,
                                    @RequestParam(required = false) String genero,
                                    @RequestParam(required = false) String editorial) {
        List<Libro> libros = libroService.listarTodos();

        if (titulo != null && !titulo.isEmpty()) {
            libros = libros.stream().filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())).toList();
        }
        if (autor != null && !autor.isEmpty()) {
            libros = libros.stream().filter(libro -> libro.getAutor().toLowerCase().contains(autor.toLowerCase())).toList();
        }
        if (genero != null && !genero.isEmpty()) {
            libros = libros.stream().filter(libro -> libro.getGenero().toLowerCase().contains(genero.toLowerCase())).toList();
        }
        if (editorial != null && !editorial.isEmpty()) {
            libros = libros.stream().filter(libro -> libro.getEditorial().toLowerCase().contains(editorial.toLowerCase())).toList();
        }
        return libros;
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Integer id) {
        libroService.eliminar(id);
    }
}
