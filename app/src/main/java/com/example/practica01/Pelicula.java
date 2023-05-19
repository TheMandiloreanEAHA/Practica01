package com.example.practica01;

public class Pelicula {
    //Atributos
    private String titulo;
    private String genero;

    //Contructores
    public Pelicula(){}
    public Pelicula(String titulo, String genero){
        this.titulo = titulo;
        this.genero = genero;
    }
    //Setters y getters
    public String getTitulo() {
        return titulo;
    }
    public String getGenero() {
        return genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
