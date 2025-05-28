package edu.sena.biblioteca.repository;
import edu.sena.biblioteca.model.DVD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DVDRepository extends JpaRepository<DVD, Integer> {
    List<DVD> findByTituloContainingIgnoreCase(String titulo);

    List<DVD> findByGeneroContainingIgnoreCase(String genero);

    List<DVD> findByAutorContainingIgnoreCase(String autor);
}
