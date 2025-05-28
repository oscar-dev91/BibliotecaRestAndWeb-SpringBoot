package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.Libro;
import edu.sena.biblioteca.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/libros")
public class LibroWebController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public String obtenerLibros(Model model) {
        model.addAttribute("libros", libroService.listarTodos());
        return "libros_lista";
    }

    @GetMapping("/nuevo")
    public String MostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "libros_formulario";
    }

    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute("libro") Libro libro) {
        libroService.guardar(libro);
        return "redirect:/libros";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        libroService.buscarPorId(id).ifPresent(libro -> model.addAttribute("libro", libro));
        return "libros_formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarLibro(@PathVariable Integer id, @ModelAttribute("libro") Libro libro) {
        libroService.actualizar(id, libro);
        return "redirect:/libros";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Integer id) {
        libroService.eliminar(id);
        return "redirect:/libros";
    }

    @GetMapping("/buscar")
    public String buscarLibros(@RequestParam(required = false) String titulo,
                               @RequestParam(required = false) String autor,
                               @RequestParam(required = false) String genero,
                               @RequestParam(required = false) String editorial,
                               Model model) {
        List<Libro> libros = libroService.listarTodos();

        if (titulo != null && !titulo.isEmpty()) {
            libros = libros.stream()
                    .filter(libro -> libro.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (autor != null && !autor.isEmpty()) {
            libros = libros.stream()
                    .filter(libro -> libro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (genero != null && !genero.isEmpty()) {
            libros = libros.stream()
                    .filter(libro -> libro.getGenero().toLowerCase().contains(genero.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (editorial != null && !editorial.isEmpty()) {
            libros = libros.stream()
                    .filter(libro -> libro.getEditorial().toLowerCase().contains(editorial.toLowerCase()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("libros", libros);
        return "libros_lista";
    }
}
