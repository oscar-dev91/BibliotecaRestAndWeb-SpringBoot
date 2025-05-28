package edu.sena.biblioteca.service;
import edu.sena.biblioteca.model.DVD;
import edu.sena.biblioteca.repository.DVDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DVDService {

    @Autowired
    private DVDRepository dvdRepository;

    public List<DVD> listarTodos() {
        return dvdRepository.findAll();
    }

    public List<DVD> buscarPorTitulo(String titulo) {
        return dvdRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public Optional<DVD> buscarPorId(Integer id) {
        return dvdRepository.findById(id);
    }

    public List<DVD> buscarPorAutor(String autor) {
        return dvdRepository.findByAutorContainingIgnoreCase(autor);
    }

    public List<DVD> buscarPorGenero(String genero) {
        return dvdRepository.findByGeneroContainingIgnoreCase(genero);
    }

    public DVD guardar(DVD dvd) {
        dvd.setTipo("DVD");
        return dvdRepository.save(dvd);
    }

    public Optional<DVD> actualizar(Integer id, DVD dvd) {
        return dvdRepository.findById(id).map(dvdExistente -> {
            dvdExistente.setTitulo(dvd.getTitulo());
            dvdExistente.setAutor(dvd.getAutor());
            dvdExistente.setAnoPublicacion(dvd.getAnoPublicacion());
            dvdExistente.setDuracion(dvd.getDuracion());
            dvdExistente.setGenero(dvd.getGenero());

            return dvdRepository.save(dvdExistente);
        });
    }

    public void eliminarDVD(Integer id) {
        dvdRepository.deleteById(id);
    }
}
