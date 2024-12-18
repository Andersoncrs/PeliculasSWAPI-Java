package com.aluracursos.peliculasswapi.modelos;

import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;

/**
 * Clase que representa una película de Star Wars con detalles específicos
 * como nombre, episodio, texto de apertura, director y productor.
 */
public class Pelicula {
    private final String nombre; // Nombre de la película.
    private final int episodio; // Número de episodio de la película.
    private final String textoDeApertura; // Texto introductorio de la película.
    private final String director; // Nombre del director de la película.
    private final String productor; // Nombre del productor de la película.

    /**
     * Constructor que recibe un objeto PeliculaSwapi y extrae sus valores
     * para inicializar los atributos de la clase.
     *
     * @param peliculaSwapi Objeto DTO que contiene los datos de la película.
     */
    public Pelicula(PeliculaSwapi peliculaSwapi) {
        this.nombre = peliculaSwapi.title();
        this.episodio = peliculaSwapi.episode_id();
        this.textoDeApertura = peliculaSwapi.opening_crawl();
        this.director = peliculaSwapi.director();
        this.productor = peliculaSwapi.producer();
    }

    /**
     * Método que devuelve una representación en cadena de los detalles de la película.
     *
     * @return Detalles de la película en formato String.
     */
    @Override
    public String toString() {
        return "nombre=" + nombre + "\n" +
                "episodio=" + episodio + "\n" +
                "textoApertura" + textoDeApertura.substring(0, 20) + "\n" +
                "director=" + director + "\n" +
                "productor=" + productor + "\n";
    }
}
