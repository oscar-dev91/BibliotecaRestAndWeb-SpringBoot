package edu.sena.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")
public class Libro extends ElementoBiblioteca{

    private String isbn;

    @Column(name = "numero_paginas")
    private Integer numeroPaginas;

    private String genero;
    private String editorial;

    // Getters y Setters
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }
    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
}
