package com.aluracursos.peliculasswapi.apis;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PeticionApiSwapi {

    String URIAPI =  "https://swapi.py4e.com/api/films/";
    String eleccionUsuario;

    public PeticionApiSwapi(String eleccionUsuario) {
        this.eleccionUsuario = eleccionUsuario;
    }

    public String peticionPeliculaUsiario() throws IOException, InterruptedException {
        String uriBase = URIAPI + eleccionUsuario + "/";
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uriBase))
                    .header("parses", "application/json")
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
    }
}
