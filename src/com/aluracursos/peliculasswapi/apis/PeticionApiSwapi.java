package com.aluracursos.peliculasswapi.apis;

import com.aluracursos.peliculasswapi.Excepciones.FilmNoEncontradoExcepcion;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase encargada de realizar peticiones HTTP a la API de SWAPI para
 * obtener información sobre películas.
 */
public class PeticionApiSwapi {

    @SuppressWarnings(URIAPI)
    private final String URIAPI = "https://swapi.py4e.com/api/films/"; // URL base de la API SWAPI.
    private final String eleccionUsuario; // Número de película elegido por el usuario.

    /**
     * Constructor que inicializa la elección del usuario.
     *
     * @param eleccionUsuario Número del film seleccionado por el usuario.
     */
    public PeticionApiSwapi(String eleccionUsuario) {
        this.eleccionUsuario = eleccionUsuario;
    }

    /**
     * Método que realiza la petición HTTP para obtener los detalles de la película.
     *
     * @return Respuesta en formato JSON de la API.
     * @throws IOException               Si ocurre un error de comunicación.
     * @throws InterruptedException      Si el hilo es interrumpido durante la operación.
     * @throws FilmNoEncontradoExcepcion Si la película no es encontrada en la API.
     */
    public String peticionPeliculaUsiario() throws IOException, InterruptedException, FilmNoEncontradoExcepcion {
        String uriBase = URIAPI + eleccionUsuario + "/"; // Construcción del URI con la película seleccionada.
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uriBase))
                .header("parses", "application/json")
                .GET()
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (httpResponse.statusCode() == 404) {
            throw new FilmNoEncontradoExcepcion("\nEl Film indicado no se encuentra");
        }

        return httpResponse.body(); // Retorna el cuerpo de la respuesta como JSON.
    }
}
