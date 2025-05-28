package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.Revista;
import edu.sena.biblioteca.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/revistas")
public class RevistaRestController {

    @Autowired
    private RevistaService revistaService;

    @GetMapping
    public List<Revista> listar() {
        return revistaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Revista> obtenerPorId(@PathVariable Integer id) {
        return revistaService.findById(id);
    }

    @GetMapping("/buscar/titulo")
    public List<Revista> buscarPorTitulo(@RequestParam String titulo) {
        return revistaService.buscarPorTitulo(titulo);
    }

    @GetMapping("/buscar/autor")
    public List<Revista> buscarPorAutor(@RequestParam String autor) {
        return revistaService.buscarPorAutor(autor);
    }

    @GetMapping("/buscar/categoria")
    public List<Revista> buscarPorCategoria(@RequestParam String categoria) {
        return revistaService.buscarPorCategoria(categoria);
    }

    @PostMapping
    public Revista guardar(@RequestBody Revista revista) {
        return revistaService.guardar(revista);
    }

    @PutMapping("/{id}")
    public Optional<Revista> actualizar(@PathVariable Integer id, @RequestBody Revista revista) {
        return revistaService.actualizar(id, revista);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        revistaService.eliminar(id);
    }
}
