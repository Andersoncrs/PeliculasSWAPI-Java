package com.aluracursos.peliculasswapi.principal;

import com.aluracursos.peliculasswapi.Excepciones.FilmNoEncontradoExcepcion;
import com.aluracursos.peliculasswapi.apis.PeticionApiSwapi;
import com.aluracursos.peliculasswapi.convertidorjson.ConvertidorJson;
import com.aluracursos.peliculasswapi.dtos.PeliculaSwapi;
import com.aluracursos.peliculasswapi.manejopeliculas.GuardarPelicula;
import com.aluracursos.peliculasswapi.modelos.Menu;
import com.aluracursos.peliculasswapi.modelos.Pelicula;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.bienvenidaMenu();

        while (true) {
            String eleccionUsuario = menu.mostrarMenu();

            if (eleccionUsuario.contains("salir")) {
                break;
            }

            try {
                PeticionApiSwapi peticionApiSwapi = new PeticionApiSwapi(eleccionUsuario);
                String resultadoPeticionApi = peticionApiSwapi.peticionPeliculaUsiario();

                ConvertidorJson convertidorJson = new ConvertidorJson(resultadoPeticionApi);
                PeliculaSwapi peliculaSwapi = convertidorJson.fromJsonToPeliculaSwapi();
                Pelicula pelicula = new Pelicula(peliculaSwapi);
                System.out.println(pelicula);

                String json = convertidorJson.toJson(pelicula);
                GuardarPelicula.GuardarPeliculaEnJson(json);

            } catch (InterruptedException | IOException e) {
                System.out.println("No se ha podido comunicar correctamente con el servidor para obtener los datos. " +
                        "Intentelo mas tarde");
                break;
            } catch (FilmNoEncontradoExcepcion e) {
                System.out.println(e.getMessage());
                System.out.println("Intente con otro Numero de Film\n");
            }
        }
        System.out.println("Gracias por utilizar nuestros servicios");

    }
}