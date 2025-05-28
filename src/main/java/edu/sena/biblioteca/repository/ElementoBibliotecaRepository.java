package edu.sena.biblioteca.repository;

import edu.sena.biblioteca.model.ElementoBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementoBibliotecaRepository extends JpaRepository<ElementoBiblioteca, Integer> {
    List<ElementoBiblioteca> findByTituloContainingIgnoreCase(String titulo);
}
