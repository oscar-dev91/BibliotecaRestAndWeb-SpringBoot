package edu.sena.biblioteca.model;
import jakarta.persistence.*;

@Entity
@Table(name = "revista")
public class Revista extends ElementoBiblioteca {

    @Column(name = "numero_edicion")
    private Integer numeroEdicion;
    private String categoria;

    // Getters y Setters
    public Integer getNumeroEdicion() {
        return numeroEdicion;
    }
    public void setNumeroEdicion(Integer numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
