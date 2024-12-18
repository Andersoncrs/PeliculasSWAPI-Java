package com.aluracursos.peliculasswapi.manejopeliculas;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase encargada de manejar el almacenamiento de películas en formato JSON.
 */
public class GuardarPelicula {

    /**
     * Método estático que guarda un String JSON en un archivo llamado "Peliculas.json".
     *
     * @param json Cadena JSON que contiene la información de la película.
     */
    public static void GuardarPeliculaEnJson(String json) {
        try (FileWriter fileWriter = new FileWriter("Peliculas.json")) {
            fileWriter.write(json + "\n"); // Escribe el JSON en el archivo.
        } catch (IOException e) {
            // Mensaje de error en caso de fallo al guardar.
            System.out.println("No se ha podido guardar el Archivo Correctamente");
            System.out.println("intentelo de nuevo");
        }
    }
}
