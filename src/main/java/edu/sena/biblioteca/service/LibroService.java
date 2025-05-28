package edu.sena.biblioteca.service;

import edu.sena.biblioteca.model.Libro;
import edu.sena.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public Optional<Libro> buscarPorId(Integer id) {
        return libroRepository.findById(id);
    }

    public Libro guardar(Libro libro) {
        libro.setTipo("Libro");
        return libroRepository.save(libro);
    }

    public Optional<Libro> actualizar(Integer id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libroExistente -> {
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setAnoPublicacion(libroActualizado.getAnoPublicacion());
            libroExistente.setIsbn(libroActualizado.getIsbn());
            libroExistente.setNumeroPaginas(libroActualizado.getNumeroPaginas());
            libroExistente.setGenero(libroActualizado.getGenero());
            libroExistente.setEditorial(libroActualizado.getEditorial());
            return libroRepository.save(libroExistente);
        });
    }

    public void eliminar(Integer id) {
        libroRepository.deleteById(id);
    }
}
