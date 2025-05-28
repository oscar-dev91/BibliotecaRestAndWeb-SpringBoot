package edu.sena.biblioteca.service;

import edu.sena.biblioteca.model.Revista;
import edu.sena.biblioteca.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevistaService {

    @Autowired
    RevistaRepository revistaRepository;

    public List<Revista> listarTodas() {
        return revistaRepository.findAll();
    }

    public Optional<Revista> findById(Integer id) {
        return revistaRepository.findById(id);
    }

    public List<Revista> buscarPorTitulo(String titulo) {
        return revistaRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Revista> buscarPorAutor(String autor) {
        return revistaRepository.findByAutorContainingIgnoreCase(autor);
    }
    public List<Revista> buscarPorCategoria(String categoria) {
        return revistaRepository.findByCategoriaContainingIgnoreCase(categoria);
    }

    public Revista guardar(Revista revista) {
        revista.setTipo("Revista");
        return revistaRepository.save(revista);
    }

    public Optional<Revista> actualizar(Integer id, Revista revista) {
        return revistaRepository.findById(id).map(revistaActualizada -> {
            revistaActualizada.setTitulo(revista.getTitulo());
            revistaActualizada.setAutor(revista.getAutor());
            revistaActualizada.setAnoPublicacion(revista.getAnoPublicacion());
            revistaActualizada.setCategoria(revista.getCategoria());
            revistaActualizada.setNumeroEdicion(revista.getNumeroEdicion());

            return revistaRepository.save(revistaActualizada);
        });
    }

    public void eliminar(Integer id) {
        revistaRepository.deleteById(id);
    }
}
