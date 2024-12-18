package com.aluracursos.peliculasswapi.modelos;

import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;

public class Pelicula {
    private final String nombre;
    private final int episodio;
    private final String textoDeApertura;
    private final String director;
    private final String productor;

    public Pelicula(PeliculaSwapi peliculaSwapi) {
        this.nombre = peliculaSwapi.title();
        this.episodio = peliculaSwapi.episode_id();
        this.textoDeApertura = peliculaSwapi.opening_crawl();
        this.director = peliculaSwapi.director();
        this.productor = peliculaSwapi.producer();
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + "\n" +
                "episodio=" + episodio + "\n" +
                "textoApertura" + textoDeApertura.substring(0, 20) + "\n" +
                "director=" + director + "\n" +
                "productor=" + productor + "\n";
    }
}
