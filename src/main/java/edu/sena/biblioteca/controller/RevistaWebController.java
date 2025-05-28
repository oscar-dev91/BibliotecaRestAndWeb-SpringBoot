package edu.sena.biblioteca.controller;

import edu.sena.biblioteca.model.Revista;
import edu.sena.biblioteca.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/revistas")
public class RevistaWebController {

    @Autowired
    private RevistaService revistaService;

    // Listar todas las revistas sin filtros
    @GetMapping
    public String listarRevistas(Model model) {
        model.addAttribute("revistas", revistaService.listarTodas());
        return "revista_lista";
    }

    // Buscar revistas con múltiples filtros
    @GetMapping("/buscar")
    public String buscarRevistas(@RequestParam(required = false) String titulo,
                                 @RequestParam(required = false) String autor,
                                 @RequestParam(required = false) String categoria,
                                 @RequestParam(required = false) Integer numeroEdicion,
                                 Model model) {

        List<Revista> revistas = revistaService.listarTodas();

        if (titulo != null && !titulo.isEmpty()) {
            revistas = revistas.stream()
                    .filter(r -> r.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (autor != null && !autor.isEmpty()) {
            revistas = revistas.stream()
                    .filter(r -> r.getAutor().toLowerCase().contains(autor.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (categoria != null && !categoria.isEmpty()) {
            revistas = revistas.stream()
                    .filter(r -> r.getCategoria().toLowerCase().contains(categoria.toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (numeroEdicion != null) {
            revistas = revistas.stream()
                    .filter(r -> numeroEdicion.equals(r.getNumeroEdicion()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("revistas", revistas);
        return "revista_lista";
    }

    @GetMapping("/crear")
    public String mostrarFormulario(Model model) {
        model.addAttribute("revista", new Revista());
        return "revista_formulario";
    }

    @PostMapping("/guardar")
    public String guardarRevista(@ModelAttribute Revista revista) {
        revistaService.guardar(revista);
        return "redirect:/revistas";
    }

    @GetMapping("/editar/{id}")
    public String editarRevista(@PathVariable Integer id, Model model) {
        revistaService.findById(id).ifPresent(r -> model.addAttribute("revista", r));
        return "revista_formulario";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarRevista(@PathVariable Integer id, @ModelAttribute Revista revista) {
        revistaService.actualizar(id, revista);
        return "redirect:/revistas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRevista(@PathVariable Integer id) {
        revistaService.eliminar(id);
        return "redirect:/revistas";
    }
}
