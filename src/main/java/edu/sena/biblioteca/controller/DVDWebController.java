// DVDWebController.java
package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.DVD;
import edu.sena.biblioteca.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/dvds")
public class DVDWebController {

    @Autowired
    private DVDService dvdService;

    @GetMapping
    public String obtenerDVDs(Model model) {
        model.addAttribute("dvds", dvdService.listarTodos());
        return "dvd_lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("dvd", new DVD());
        return "dvd_formulario";
    }

    @PostMapping("/guardar")
    public String guardarDVD(@ModelAttribute("dvd") DVD dvd) {
        dvdService.guardar(dvd);
        return "redirect:/dvds";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        dvdService.buscarPorId(id).ifPresent(dvd -> model.addAttribute("dvd", dvd));
        return "dvd_formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarDVD(@PathVariable Integer id, @ModelAttribute("dvd") DVD dvd) {
        dvdService.actualizar(id, dvd);
        return "redirect:/dvds";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDVD(@PathVariable Integer id) {
        dvdService.eliminarDVD(id);
        return "redirect:/dvds";
    }

    @GetMapping("/buscar")
    public String buscarDVDs(@RequestParam(required = false) String titulo,
                             @RequestParam(required = false) String autor,
                             @RequestParam(required = false) String genero,
                             Model model) {
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

        model.addAttribute("dvds", dvds);
        return "dvd_lista";
    }
}