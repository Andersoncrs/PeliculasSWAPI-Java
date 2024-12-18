package com.aluracursos.peliculasswapi.manejopeliculas;

import java.io.FileWriter;
import java.io.IOException;

public class GuardarPelicula {

    public static void GuardarPeliculaEnJson(String json) {
        try (FileWriter fileWriter = new FileWriter("Peliculas.json")) {
            fileWriter.write(json + "\n");
        } catch (IOException e) {
            System.out.println("No se ha podido guardar el Archivo Correctamente");
            System.out.println("intentelo de nuevo");
        }
    }
}
