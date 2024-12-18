package com.aluracursos.peliculasswapi.modelos;

import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;

public class Pelicula {
     private String nombre;
     private int episodio;
     private String textoDeApertura;
     private String director;
     private String productor;

     public Pelicula(PeliculaSwapi peliculaSwapi){
         this.nombre = peliculaSwapi.title();
         this.episodio = peliculaSwapi.episode_id();
         this.textoDeApertura = peliculaSwapi.opening_crawl();
         this.director = peliculaSwapi.director();
         this.productor = peliculaSwapi.producer();
     }

    @Override
    public String toString() {
        return  "nombre=" + nombre + "\n" +
                "episodio=" + episodio + "\n" +
                "director=" + director + "\n" +
                "productor=" + productor + "\n";
    }
}
