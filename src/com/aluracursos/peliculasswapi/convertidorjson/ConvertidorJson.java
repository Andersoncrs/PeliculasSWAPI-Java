package com.aluracursos.peliculasswapi.convertidorjson;

import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;
import com.aluracursos.peliculasswapi.modelos.Pelicula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertidorJson {
    private String json;

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public ConvertidorJson() {
    }

    public ConvertidorJson(String json) {
        this.json = json;
    }

    public PeliculaSwapi fromJsonToPeliculaSwapi() {
        return gson.fromJson(this.json, PeliculaSwapi.class);
    }

    public String toJson(Pelicula pelicula) {
        return gson.toJson(pelicula);
    }
}
