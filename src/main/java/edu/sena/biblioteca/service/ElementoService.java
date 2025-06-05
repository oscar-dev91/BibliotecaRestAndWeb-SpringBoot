package edu.sena.biblioteca.service;
import edu.sena.biblioteca.model.ElementoBiblioteca;
import edu.sena.biblioteca.repository.ElementoBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementoService {

    @Autowired
    private ElementoBibliotecaRepository elementoBibliotecaRepository;

    public List<ElementoBiblioteca> listarElementosBiblioteca() { return elementoBibliotecaRepository.findAll(); }

    public List<ElementoBiblioteca> buscarPorTitulo(String titulo) {
        return elementoBibliotecaRepository.findByTituloContainingIgnoreCase(titulo);
    }
}
