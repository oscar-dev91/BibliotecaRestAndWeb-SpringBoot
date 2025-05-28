package edu.sena.biblioteca.repository;
import edu.sena.biblioteca.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Integer> {
    List<Revista> findByTituloContainingIgnoreCase(String titulo);
    List<Revista> findByAutorContainingIgnoreCase(String autor);
    List<Revista> findByCategoriaContainingIgnoreCase(String categoria);
}
