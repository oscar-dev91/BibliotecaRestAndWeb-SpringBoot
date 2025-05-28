package edu.sena.biblioteca.model;
import jakarta.persistence.*;

@Entity
@Table(name = "dvd")
public class DVD extends ElementoBiblioteca {

    // private Integer id;
    private Integer Duracion;
    private String genero;

    // Getters y Setters
    //

    public Integer getDuracion() {
        return Duracion;
    }
    public void setDuracion(Integer Duracion) {
        this.Duracion = Duracion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
