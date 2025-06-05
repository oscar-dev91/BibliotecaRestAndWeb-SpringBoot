package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.ElementoBiblioteca;
import edu.sena.biblioteca.service.ElementoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/elementos")
@CrossOrigin(origins = "http://localhost:5173")
public class ElementoRestController {

    @Autowired
    private ElementoService elementoService;

    @GetMapping
    public List<ElementoBiblioteca> obtenerElementos() { return elementoService.listarElementosBiblioteca(); }

    @GetMapping("/buscar")
    public  List<ElementoBiblioteca> buscarElementosPorTitulo(@RequestParam String titulo) {
        return elementoService.buscarPorTitulo(titulo);
    }
}
