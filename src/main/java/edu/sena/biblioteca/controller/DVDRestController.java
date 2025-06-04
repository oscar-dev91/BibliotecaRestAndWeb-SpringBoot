// DVDRestController.java
package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.DVD;
import edu.sena.biblioteca.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dvds")
@CrossOrigin(origins = "http://localhost:5173")
public class DVDRestController {

    @Autowired
    private DVDService dvdService;

    @GetMapping
    public List<DVD> obtenerDVDs() {
        return dvdService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<DVD> obtenerDVDPorId(@PathVariable Integer id) {
        return dvdService.buscarPorId(id);
    }

    @PostMapping
    public DVD guardarDVD(@RequestBody DVD dvd) {
        return dvdService.guardar(dvd);
    }

    @PutMapping("/{id}")
    public Optional<DVD> actualizarDVD(@PathVariable Integer id, @RequestBody DVD dvd) {
        return dvdService.actualizar(id, dvd);
    }

    @GetMapping("/buscar")
    public List<DVD> buscarDVDs(@RequestParam(required = false) String titulo,
                                @RequestParam(required = false) String autor,
                                @RequestParam(required = false) String genero) {
        List<DVD> dvds = dvdService.listarTodos();

        if (titulo != null && !titulo.isEmpty()) {
            dvds = dvdService.buscarPorTitulo(titulo);
        }
        if (autor != null && !autor.isEmpty()) {
            dvds = dvdService.buscarPorAutor(autor);
        }
        if (genero != null && !genero.isEmpty()) {
            dvds = dvdService.buscarPorGenero(genero);
        }
        return dvds;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        dvdService.eliminarDVD(id);
    }
}