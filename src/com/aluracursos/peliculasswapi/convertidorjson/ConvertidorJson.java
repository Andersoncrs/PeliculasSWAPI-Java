package com.aluracursos.peliculasswapi.convertidorjson;

import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;
import com.aluracursos.peliculasswapi.modelos.Pelicula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Clase encargada de la conversión entre objetos JSON y Java.
 */
public class ConvertidorJson {
    private final String json; // String que contiene el JSON a convertir.

    // Instancia de Gson configurada para formateo de JSON.
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    /**
     * Constructor que inicializa el JSON a procesar.
     *
     * @param json Cadena JSON que será procesada.
     */
    public ConvertidorJson(String json) {
        this.json = json;
    }

    /**
     * Convierte el JSON almacenado en la clase a un objeto PeliculaSwapi.
     *
     * @return Objeto PeliculaSwapi generado desde el JSON.
     */
    public PeliculaSwapi fromJsonToPeliculaSwapi() {
        return gson.fromJson(this.json, PeliculaSwapi.class);
    }

    /**
     * Convierte un objeto Pelicula a formato JSON.
     *
     * @param pelicula Objeto Pelicula a convertir.
     * @return Cadena JSON que representa la película.
     */
    public String toJson(Pelicula pelicula) {
        return gson.toJson(pelicula);
    }
}
