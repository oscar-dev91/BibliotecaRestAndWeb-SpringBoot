package edu.sena.biblioteca.repository;

import edu.sena.biblioteca.model.Libro;
import jakarta.persistence.Inheritance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    List<Libro> findByAutorContainingIgnoreCase(String autor);

    List<Libro> findByGeneroContainingIgnoreCase(String genero);

    List<Libro> findByEditorialContainingIgnoreCase(String editorial);
}
