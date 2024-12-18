package com.aluracursos.peliculasswapi.principal;

import com.aluracursos.peliculasswapi.Excepciones.FilmNoEncontradoExcepcion;
import com.aluracursos.peliculasswapi.apis.PeticionApiSwapi;
import com.aluracursos.peliculasswapi.convertidorjson.ConvertidorJson;
import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;
import com.aluracursos.peliculasswapi.manejopeliculas.GuardarPelicula;
import com.aluracursos.peliculasswapi.modelos.Menu;
import com.aluracursos.peliculasswapi.modelos.Pelicula;

import java.io.IOException;

/**
 * Clase principal que orquesta la interacción con el usuario y los componentes del sistema.
 */
public class Main {
    /**
     * Método principal que ejecuta el flujo del programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Menu menu = new Menu(); // Instancia del menú para interactuar con el usuario.
        menu.bienvenidaMenu();

        while (true) {
            // Muestra el menú y recibe la elección del usuario.
            String eleccionUsuario = menu.mostrarMenu();

            if (eleccionUsuario.contains("salir")) { // Finaliza el programa si el usuario elige salir.
                break;
            }

            try {
                // Realiza la petición a la API de SWAPI con la elección del usuario.
                PeticionApiSwapi peticionApiSwapi = new PeticionApiSwapi(eleccionUsuario);
                String resultadoPeticionApi = peticionApiSwapi.peticionPeliculaUsiario();

                // Convierte el resultado de la API a un objeto de tipo PeliculaSwapi.
                ConvertidorJson convertidorJson = new ConvertidorJson(resultadoPeticionApi);
                PeliculaSwapi peliculaSwapi = convertidorJson.fromJsonToPeliculaSwapi();

                // Crea un objeto Pelicula basado en los datos recibidos.
                Pelicula pelicula = new Pelicula(peliculaSwapi);
                System.out.println(pelicula);

                // Guarda la información de la película en un archivo JSON.
                String json = convertidorJson.toJson(pelicula);
                GuardarPelicula.GuardarPeliculaEnJson(json);

            } catch (InterruptedException | IOException e) {
                // Manejo de errores relacionados con la conexión a la API.
                System.out.println("No se ha podido comunicar correctamente con el servidor para obtener los datos. " +
                        "Intentelo mas tarde");
                break;
            } catch (FilmNoEncontradoExcepcion e) {
                // Manejo del caso en que el ID de la película no existe.
                System.out.println(e.getMessage());
                System.out.println("Intente con otro Numero de Film\n");
            }
        }

        // Mensaje de despedida al finalizar el programa.
        System.out.println("Gracias por utilizar nuestros servicios");
    }
}
